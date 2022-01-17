package com.smart.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/index")
	public String dashBord(Model model,Principal principal)
	{
		String name=principal.getName();
		
		//Get user Using Email
		User user=userRepository.getUserByEmail(name);
		
		model.addAttribute("User",user);
		
		return "normal/user_dashbord";
	}
}
