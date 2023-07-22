package com.evaluation.user.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Phones")
public class Phone {
	
	@Id
	@Column
	protected UUID id;
	
	@Column(nullable = false)
	protected String number;
	
	@Column(nullable = false)
	protected int cityCode;
	
	@Column(nullable = false)
	protected int contryCode;
	
	@ManyToOne
	@JsonBackReference
    @JoinColumn(name = "id_user")
    private User user;
	
	public Phone() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public int getContryCode() {
		return contryCode;
	}

	public void setContryCode(int contryCode) {
		this.contryCode = contryCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
