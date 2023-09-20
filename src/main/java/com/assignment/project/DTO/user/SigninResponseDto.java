package com.assignment.project.DTO.user;

public class SigninResponseDto {

	private String status;
	
	private String token;

	public void setStatus(String status) {
		this.status = status;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SigninResponseDto(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public String getToken() {
		return token;
	}
	
}
