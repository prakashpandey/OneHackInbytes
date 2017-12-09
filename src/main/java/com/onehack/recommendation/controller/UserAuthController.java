package com.onehack.recommendation.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onehack.recommendation.dao.User;
import com.onehack.recommendation.dao.UserRepository;

@RestController
@RequestMapping("/user")
public class UserAuthController {

	private Logger log = LoggerFactory.getLogger(UserAuthController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String validateUser( @RequestParam("email") String email, @RequestParam("password") String password) {
		log.debug("=========== Inside /user/auth =========");
		User user = userRepository.findByEmail(email);
		JSONObject response = new JSONObject();
		if (user.getPassword().equalsIgnoreCase(password)) {
			response.put("success", true);
			response.put("id", user.getId());
			response.put("name", user.getName());
			response.put("phone", user.getPhone());
		}
		else {
			response.put("success", false);
			response.put("error", "Failed to authenticate user. Please check your email/password");
		}
		return response.toString();
	}
}
