
package com.infosys.educationConsultancyApplication.bean;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EduconUser extends User {
	@Id
	private String Username;
	private String password;
	private String email;
	private String category;
	public EduconUser() {
		super("abc","pqr",new ArrayList<>());
		// TODO Auto-generated constructor stub
	}
	
	
	public EduconUser(String username, String password, Collection<? extends GrantedAuthority> authorities,

			String username2, String email2, String password2, String category2) {

		super(username, password, authorities);
 
		Username = username2;

		this.password = password2;

		this.email = email2;

		this.category = category2;

	}
 


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "EduconUser [Username=" + Username + ", password=" + password + ", email=" + email + ", category="
				+ category + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}  
	
   
}