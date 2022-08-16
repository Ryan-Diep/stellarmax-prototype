package com.stellarmaxprototype.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.stellarmaxprototype.entity.Client;
import com.stellarmaxprototype.entity.Job;
import com.stellarmaxprototype.entity.User;
import com.stellarmaxprototype.fileUpload.FileUploadUtil;
import com.stellarmaxprototype.repository.ClientRepository;
import com.stellarmaxprototype.repository.JobRepository;
import com.stellarmaxprototype.repository.UserRepository;
import com.stellarmaxprototype.service.ClientService;
import com.stellarmaxprototype.service.JobService;
import com.stellarmaxprototype.service.UserService;

@Controller
public class AppController {
	
	
	private UserService userService;
	
	private ClientService clientService;
	
	private JobService jobService;
	
	public AppController(UserService userService, 
			ClientService clientService, JobService jobService){
		super();
		this.userService = userService;
		this.clientService = clientService;
		this.jobService = jobService;
	}
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	@GetMapping("")
	public String viewHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
			model.addAttribute("user", new User());
			
			return "register";
	}
	
	@PostMapping("/register/process")
	public String processRegistration(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String viewUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	    
		return "users";
	}
	
	@GetMapping("/users/add")
	public String addUsers(Model model) {
		
			User user = new User();
			model.addAttribute("user", new User());
			
			List<String> listRole = Arrays.asList("Administrator", "Technician");
	        model.addAttribute("listRole", listRole);
			
			return "add_user";
	}
	
	@PostMapping("/users/process")
	public String processUser(User user, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    user.setRoleId(user.roleToRoleId(user.getRole()));
	    
		userRepo.save(user);
		
		return viewUsers(model);
		
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepo.findById(id));
		return "edit_user";
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model) {
		
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		userService.updateUser(existingUser);
		return "redirect:/users";		
	}
	
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}
	
	@GetMapping("/clients")
	public String viewClients(Model model) {
		List<Client> listClients = clientRepo.findAll();
	    model.addAttribute("listClients", listClients);
	    
		return "clients";
	}
	
	@GetMapping("/clients/add")
	public String addClients(Model model) {
		
			Client client = new Client();
			model.addAttribute("client", new Client());
			
			return "add_client";
	}
	
	@PostMapping("/clients/process")
	public String processClients(Client client, Model model) {
		clientRepo.save(client);
		
		return viewClients(model);	
	}
	
	@GetMapping("/clients/edit/{id}")
	public String editClient(@PathVariable Long id, Model model) {
		model.addAttribute("client", clientRepo.findById(id));
		return "edit_client";
	}
	
	@PostMapping("/clients/{id}")
	public String updateClient(@PathVariable Long id,
			@ModelAttribute("client") Client client,
			Model model) {
		
		Client existingClient = clientService.getClientById(id);
		existingClient.setId(id);
		existingClient.setFirstName(client.getFirstName());
		existingClient.setLastName(client.getLastName());
		existingClient.setEmail(client.getEmail());
		
		clientService.updateClient(existingClient);
		return "redirect:/client";		
	}
	
	@GetMapping("/clients/{id}")
	public String deleteClients(@PathVariable Long id) {
		clientService.deleteClientById(id);
		return "redirect:/clients";
	}
	
	@GetMapping("/jobs")
	public String viewJobs(Model model) {
		List<Job> listJobs = jobRepo.findAll();
	    model.addAttribute("listJobs", listJobs);
	    
		return "jobs";
	}
	
	@GetMapping("/jobs/add")
	public String addJobs(Model model) {
		
			Job jobs = new Job();
			model.addAttribute("job", new Job());
			
			return "add_job";
	}
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@PostMapping("/jobs/process")
	public String processJobs(Job jobs, Model model,
			@RequestParam("beforePic") MultipartFile multipartFile1,
			@RequestParam("afterPic") MultipartFile multipartFile2
			) throws IOException {
		
		String beforePhotoFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
		String afterPhotoFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
		
		jobs.setBeforePhoto(beforePhotoFileName);
		jobs.setAfterPhoto(afterPhotoFileName);
		
		Job savedJob = jobRepo.save(jobs);
		String uploadDir = "uploads/" + savedJob.getId();


		FileUploadUtil.saveFile(uploadDir, beforePhotoFileName, multipartFile1);
		FileUploadUtil.saveFile(uploadDir, afterPhotoFileName, multipartFile2);
		System.out.println("after");
		return viewJobs(model);	
	}
	
	@GetMapping("/jobs/edit/{id}")
	public String editJob(@PathVariable Long id, Model model) {
		model.addAttribute("job", jobRepo.findById(id));
		return "edit_job";
	}
	
	@GetMapping("/jobs/{id}")
	public String deleteCases(@PathVariable Long id) {
		jobService.deleteJobById(id);
		return "redirect:/jobs";
	}
	
//	@PostMapping("/jobs/pic")
//	public Object upload(@RequestParam("beforePhoto") MultipartFile multipartFile) {
//	
//	    return fileService.upload(multipartFile);
//	}
//
//	@PostMapping("/jobs/pic/{beforePhoto}")
//	public Object download(@PathVariable String fileName) throws IOException {
//	    return fileService.download(fileName);
//	}
}
