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
	public void join() throws Exception {
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO) throws Exception {
		String path = "./join";
		
		if(userService.join(userDTO) > 0) {
			path = "redirect:/";
		}
		
		return path;
	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(UserDTO userDTO) throws Exception {
		return "/users/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login2(UserDTO userDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	

}
