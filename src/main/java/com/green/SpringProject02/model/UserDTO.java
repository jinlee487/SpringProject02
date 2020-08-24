package com.green.SpringProject02.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.green.SpringProject02.validation.PasswordMatches;
import com.green.SpringProject02.validation.ValidEmail;

@PasswordMatches
public class UserDTO {
	
	@NotNull
	@NotEmpty
	@Size(min = 1, message = "{Size.userDto.userName}")
	private String userName;
	
	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;

    @NotNull
	@NotEmpty
	@Size(min = 1, message = "{Size.userDto.firstName}")
	private String firstName;
    
	@NotNull
	@NotEmpty
	@Size(min = 1, message = "{Size.userDto.lastName}")
	private String lastName;
	@ValidEmail
	@NotNull
	@NotEmpty
	@Size(min = 1, message = "{Size.userDto.email}")
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}


}
