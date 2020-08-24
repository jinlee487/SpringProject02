package com.green.SpringProject02.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.SpringProject02.model.UserVO;


public interface UserRepository extends JpaRepository<UserVO, Integer> {
	Optional<UserVO> findByUserName(String userName);
	List<UserVO> findAll();
	Optional<UserVO> findByEmail(String email);
	
}
