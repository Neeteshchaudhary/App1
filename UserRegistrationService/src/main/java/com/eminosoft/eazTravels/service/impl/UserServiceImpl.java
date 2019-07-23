package com.eminosoft.eazTravels.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eminosoft.eazTravels.model.User;
import com.eminosoft.eazTravels.repository.UserRepository;
import com.eminosoft.eazTravels.service.UserService;
import com.eminosoft.eazTravels.util.AppUtil;
import com.eminosoft.eazTravels.util.StatusMsg;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public StatusMsg addUser(User user) {

		StatusMsg msg=new StatusMsg();
		String originalPassword = user.getPassword();       
		String encryptedPassword = AppUtil.sha256(originalPassword);
		user.setPassword(encryptedPassword);
	
		User responseUser=userRepository.save(user);
	  
		msg.setUserId(responseUser.getUserId());
		msg.setUserName(responseUser.getUserName());
		msg.setMessage("You are registered successfully");
		msg.setStatus(true);

		return msg;	
	}

}



