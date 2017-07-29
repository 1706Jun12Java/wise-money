package com.wisemoney.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WM_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 188661191408085712L;

	@Id
	@Column(name="U_ID", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UserIdSequence")
	@SequenceGenerator(allocationSize=1, name="UserIdSequence", sequenceName="USER_SEQ")
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="USERNAME", unique=true)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL", unique=true)
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="UR_ID")
	private UserRole userRole;
	
	public User(String firstName, String lastName, String username, String password, String email,
			UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
	
	

}
