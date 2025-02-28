package com.root.app.users;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
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
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		String path = "./join";
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		if(userService.join(userDTO, profile, session.getServletContext()) > 0) {
			path = "redirect:/";
		}
		
		return path;
	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(UserDTO userDTO) throws Exception {
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		userDTO = userService.login(userDTO);
		if(userDTO != null) {
			session.setAttribute("user", userDTO);
			return "redirect:/";
		}
		model.addAttribute("result", "로그인 실패");
		model.addAttribute("path", "./login");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) throws Exception {
		session.invalidate();
		
		model.addAttribute("result", "로그아웃 되었습니다");
		model.addAttribute("path", "/");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public UserDTO mypage(UserDTO userDTO, HttpSession session) throws Exception {
		return (UserDTO)session.getAttribute("user");
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public UserDTO update(UserDTO userDTO, HttpSession session) throws Exception {
		return (UserDTO)session.getAttribute("user");
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("user");
		userDTO.setUserName(user.getUserName());
		int result = userService.update(userDTO);
		
		if(result > 0) {
			session.setAttribute("user", userDTO);
			return "redirect:./mypage";
		}
		return "./update";
	}

}
