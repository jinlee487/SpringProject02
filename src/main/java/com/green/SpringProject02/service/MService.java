package com.green.SpringProject02.service;

import java.util.List;

import com.green.SpringProject02.error.UserAlreadyExistException;
import com.green.SpringProject02.model.UserDTO;
import com.green.SpringProject02.model.UserVO;


public interface MService {

	List<UserVO> findAll();	
	UserVO findByUserName(String userName); // selectOne
	UserVO registerNewUserAccount(UserDTO userDTO) throws UserAlreadyExistException; // selectOne

//	int insert(MemberVO vo); // insert
//	int update(MemberVO vo); // update
//	int imgUpdate(MemberVO vo); // update
//	int delete(MemberVO vo); // delete
	
} // interface