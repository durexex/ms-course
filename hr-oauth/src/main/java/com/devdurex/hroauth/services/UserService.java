package com.devdurex.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdurex.hroauth.entities.User;
import com.devdurex.hroauth.feignClients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class); 
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		logger.error("Email not found: " + email);
		if (user == null) {
			throw new IllegalArgumentException("email not found");
		}
		logger.info("Email found: " + email);
				
		return user;
	}
}
