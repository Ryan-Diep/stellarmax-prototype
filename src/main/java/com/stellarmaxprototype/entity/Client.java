package com.stellarmaxprototype.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
	
	@Column(nullable = false, length = 64)
	private String primaryAddress;
	
	@Column(nullable = true, length = 64)
	private String secondaryAddress;
		
	@Column(nullable = false, length = 10)
	private int phoneNumber;
	
	@Column(nullable = false, length = 20)
    private String firstName;
    
	@Column(nullable = false, length = 20)
    private String lastName;
    
	public Client() {
		
	}
	
	public Client(String firstName, String lastName, String email, String primaryAddress, String secondaryAddress, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.primaryAddress = primaryAddress;
		this.secondaryAddress = secondaryAddress;
		this.phoneNumber = phoneNumber;
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
	
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
	public String getSecondaryAddress() {
		return secondaryAddress;
	}
	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
  }