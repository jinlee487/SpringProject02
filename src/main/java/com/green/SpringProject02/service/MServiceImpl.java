package com.green.SpringProject02.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.SpringProject02.dao.UserRepository;
import com.green.SpringProject02.error.UserAlreadyExistException;
import com.green.SpringProject02.model.UserDTO;
import com.green.SpringProject02.model.UserVO;


@Service
public class MServiceImpl implements MService {
	@Autowired
	UserRepository repo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
       
	@Override
	public 	List<UserVO> findAll(){
		List<UserVO> list = repo.findAll();	
		return list;
	}
	@Override
	public UserVO findByUserName(String userName) {
		Optional<UserVO> user = repo.findByUserName(userName);
		UserVO vo = user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		return vo;
	} 
	
	@Transactional
    @Override
    public UserVO registerNewUserAccount(UserDTO userDTO) 
      throws UserAlreadyExistException {
        
        if (repo.findByUserName(userDTO.getUserName()).isPresent()) {  
            throw new UserAlreadyExistException(
              "There is an account with that email address: "
              +  userDTO.getUserName());
        }
        
        final UserVO vo= new UserVO();
        vo.setUserName(userDTO.getUserName());
        vo.setActive(true);
        vo.setFirstName(userDTO.getFirstName());
        vo.setLastName(userDTO.getLastName());
        vo.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        vo.setEmail(userDTO.getEmail());
        vo.setRoles("ROLE_USER");
        // the rest of the registration operation
        return repo.save(vo);
    }

//	
//	@Override
//	public int insert(MemberVO vo) {  
//		return dao.insert(vo);  // 처리된 row 갯수 return	 
//	} // insert
//	
//	@Override
//	public int update(MemberVO vo) { // row(vo) 전달 받아 수정
//		return dao.update(vo);  // 처리된 row 갯수 return
//	} // update
//
//	@Override
//	public int delete(MemberVO vo) {
//		return dao.delete(vo);  // 처리된 row 갯수 return
//	} // delete
//
//	@Override
//	public int imgUpdate(MemberVO vo) {
//		return dao.imgUpdate;
//	}
	
} // class
