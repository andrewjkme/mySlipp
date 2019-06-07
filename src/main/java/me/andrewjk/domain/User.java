package me.andrewjk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=20, unique=true)
	private String userId;
	
	private String password;
	private String name;
	private String eMail;
	
	

	public Long getId() {
		return id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public void update(User newUser) {
		// TODO Auto-generated method stub
		this.password = newUser.password;
		this.name = newUser.name;
		this.eMail = newUser.eMail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", eMail=" + eMail + "]";
	}


}
