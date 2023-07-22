package com.evaluation.user.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@Column
	protected UUID id;
	
	@Column(nullable = false, length = 150)
	protected String name;
	
	@Column(nullable = false, length = 320)
	protected String email;
	
	@Column(nullable = false, length = 16)
	protected String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	protected List<Phone> phones = new ArrayList<Phone>();
	
	@Column(nullable = false)
	protected Date created;
	
	@Column(nullable = false)
	protected Date modified;
	
	@Column(nullable = true)
	protected Date last_login;
	
	@Column(nullable = true)
	protected String token;
	
	@Column(nullable = false)
	protected boolean isactive;
	
	public User() {
		this.id = UUID.randomUUID();
		this.created = Calendar.getInstance().getTime();
		this.modified = Calendar.getInstance().getTime();
		this.isactive = true;
	}
	
	public void setId(UUID id) {
        this.id = id;
    }

	public UUID getId() {
		return id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

}
