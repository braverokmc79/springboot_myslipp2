package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue  ///자동으로 1씩 증가해서 추가
	private Long id;
	
	@Column(nullable=false, length=20)
	private String userId;
	
	private String password;
	private String name;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void update(User newUser) {
		this.name=newUser.getName();
		this.password=newUser.getPassword();
		this.email=newUser.getEmail();		
	}
	
	public boolean matchPassword(String newPassword) {
		if(newPassword ==null) {
			return false;
		}
		return newPassword.equals(password);
	}
	
	
	public boolean matchId(Long newId) {
		if(newId ==null) {
			return false;
		}
		return newId.equals(id);
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
