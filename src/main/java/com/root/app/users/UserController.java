package com.root.app.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.carts.CartDTO;
import com.root.app.pages.Pager;
import com.root.app.products.ProductDTO;


@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "cartDelete", method = RequestMethod.GET)
	public String cartDelete(HttpSession session, Model model, Long [] productNum) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", session.getAttribute("user"));
		map.put("products", productNum);
		int result = userService.cartDelete(map);
		model.addAttribute("result", result);
		System.out.println(result);
		return "commons/ajaxresult";
	}
	
	@RequestMapping(value = "carts", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model, Pager pager) throws Exception {
		List<ProductDTO> list = userService.getCartList(pager, (UserDTO)session.getAttribute("user"));
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.GET)
	public String addCart(CartDTO cartDTO, HttpSession session, HttpServletRequest request, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		if(userDTO == null) {
			
			model.addAttribute("result", "로그인 후 사용 가능");
			model.addAttribute("path", "./login");
			return "../commons/result";
		}
		cartDTO.setUserName(userDTO.getUserName());
		
		int result = userService.addCart(cartDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	
	// check
	// /users/check
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String check(HttpServletRequest request, UserDTO userDTO, Model model) throws Exception{
		String un = request.getParameter("userName");
//		System.out.println(un);
		un = userDTO.getUserName();
//		System.out.println(un);
		userDTO = userService.getDetail(userDTO);
		// userDTO == null 이면 가입가능 중복x
		// userDTO != null 이면 가입불가 중복o
		int result = 0; // 중복o
		if(userDTO == null) {
			result = 1; // 중복x
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		String path = "./join";

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
	public String update(UserDTO userDTO, HttpSession session, MultipartFile profile) throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("user");
		userDTO.setUserName(user.getUserName());
		int result = userService.update(userDTO, profile, session.getServletContext());
		
		if(result > 0) {
			session.setAttribute("user", userDTO);
			return "redirect:./mypage";
		}
		return "./update";
	}

}
