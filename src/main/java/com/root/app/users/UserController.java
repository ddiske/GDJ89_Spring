package com.root.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		return "/users/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO) throws Exception {
		String path = "./join";
		
		if(userService.join(userDTO) > 0) {
			path = "redirect:/";
		}
		
		return path;
	}
	

}
