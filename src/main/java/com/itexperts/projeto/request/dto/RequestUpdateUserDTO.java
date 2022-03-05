package com.itexperts.projeto.request.dto;

import com.itexperts.projeto.model.User;

public class RequestUpdateUserDTO {

	private String lastName;
	
	public RequestUpdateUserDTO() {		
	}

	public RequestUpdateUserDTO(String lastName) {
		this.lastName = lastName;
	}
	
	public RequestUpdateUserDTO(User user) {
		lastName = user.getLastName();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
}
