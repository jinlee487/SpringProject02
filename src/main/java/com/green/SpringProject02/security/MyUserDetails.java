package com.green.SpringProject02.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.green.SpringProject02.model.UserDTO;
import com.green.SpringProject02.model.UserVO;


public class MyUserDetails implements UserDetails {
	private int id;
	private String userName; 
	private String password; 
	private boolean active; 
	private String bday;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(String userName) {
		super();
		this.userName = userName;
	}
	public MyUserDetails(UserVO vo) {
		this.id=vo.getId();
		this.userName = vo.getUserName();
		this.password = vo.getPassword();
		this.active = vo.isActive();
		this.authorities = Arrays.stream(vo.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	
	public boolean isActive() {
		return active;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String toString() {
		return "MyUserDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", active=" + active
				+ ", bday=" + bday + ", authorities=" + authorities + "]";
	}

	

}
