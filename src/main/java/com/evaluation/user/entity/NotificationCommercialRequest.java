package com.evaluation.user.entity;

import java.util.List;

public class NotificationCommercialRequest {
	
	private String businessName;
	private String ruc;
	private List<NotificationPhoneDto> responsible;
	private String accounts;
	private String trayStatus;
	private String powerObservationCode;
  	private String createdDate;
	
  	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public List<NotificationPhoneDto> getResponsible() {
		return responsible;
	}
	public void setResponsible(List<NotificationPhoneDto> responsible) {
		this.responsible = responsible;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getTrayStatus() {
		return trayStatus;
	}
	public void setTrayStatus(String trayStatus) {
		this.trayStatus = trayStatus;
	}
	public String getPowerObservationCode() {
		return powerObservationCode;
	}
	public void setPowerObservationCode(String powerObservationCode) {
		this.powerObservationCode = powerObservationCode;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
  
  

}
