package com.carl.pojo;

import java.io.Serializable;

public class Customer implements Serializable{
	private Integer id;
	private String cu_name;
	private String cu_password;
	private String gender;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCu_name() {
		return cu_name;
	}
	public void setCu_name(String cu_name) {
		this.cu_name = cu_name;
	}
	public String getCu_password() {
		return cu_password;
	}
	public void setCu_password(String cu_password) {
		this.cu_password = cu_password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
