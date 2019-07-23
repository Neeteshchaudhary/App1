package com.eminosoft.eazTravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eminosoft.eazTravels.model.User;
import com.eminosoft.eazTravels.service.UserService;
import com.eminosoft.eazTravels.util.StatusMsg;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> PostServiceVSeeUserProvider(@RequestBody User user) {
		
		StatusMsg response=new StatusMsg();
		StatusMsg result= userService.addUser(user);
		
		if(result.isStatus()==true) {
			response.setUserId(result.getUserId());
			response.setUserName(result.getUserName());
			response.setMessage(result.getMessage());
			response.setStatus(result.isStatus());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.setMessage(result.getMessage());
			response.setStatus(result.isStatus());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}}}
