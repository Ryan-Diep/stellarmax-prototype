package com.stellarmaxprototype.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(nullable = false, length = 20)
    private String firstName;
    
	@Column(nullable = false, length = 20)
    private String lastName;
    
	@Column(nullable = false)
    private int roleId;
	
	@javax.persistence.Transient
	private String role;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, int roleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}
	
    public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int roleToRoleId(String role) {
		if(role.equals("Administrator")) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public String roleIdToRole(int roleId) {
		if(roleId == 1) {
			return "Administrator";
		}
		else {
			return "Technician";
		}
	}
  }