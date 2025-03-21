package com.root.app.products;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	Model -> requestScope와 라이프사이클이 비슷
//	응답이 발생하면 소멸
//	request와 비슷한 일을 함
//	java -> jsp로 데이터를 전달할 때 사용
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		
		List<ProductDTO> ar = productService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "products/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ProductDTO productDTO, Pager pager) throws Exception {
		
		productDTO = productService.getDetail(productDTO);
		
		ModelAndView mv = new ModelAndView();
		
		// model
//		mv.addObject("속성명", "값");
		mv.addObject("productDTO", productDTO);
		// view
		mv.setViewName("products/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO) throws Exception {
//		파라미터 처리 방법
//		1. 모든 요청 정보는 Request에 있다.(URL, Method, Parameter, Cookie...)
//		   메서드의 매개변수로 HttpServletRequest request 선언
//		   request.getParameter("");
//		2. 매개변수로 파라미터 이름과 동일한 타입과 변수명을 선언
//		3. 매개변수로 파라미터 값을 담을 객체-Bean(DTO) 선언
//		   파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일
		
//		-1-
//		String name = request.getParameter("productName");
//		Double rate = Double.parseDouble(request.getParameter("productRate"));
//		System.out.println(name);
//		System.out.println(rate);
		
//		-2-
//		System.out.println(productName);
//		System.out.println(productRate);
		
//		-3-
//		System.out.println(productDTO.getProductName());
//		System.out.println(productDTO.getProductRate());
		
		int result = productService.add(productDTO);
		String path = "products/add";
		
		if(result > 0) {
			path = "redirect:./list";
		}
		
		return path;
	}
	
	@RequestMapping(value = "detailFiles", method = RequestMethod.POST)
	public String detailFiles(MultipartFile uploadFile, HttpSession session, Model model) throws Exception {
		String result = productService.fileSave(uploadFile, session.getServletContext());
		result = "/resources/images/products/"+result;
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "detailFilesDelete", method = RequestMethod.POST)
	public String detailFilesDelete(String fileName, HttpSession session, Model model) throws Exception {
		productService.fileDelete(fileName, session);
		model.addAttribute("result", 1);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(ProductDTO productDTO) throws Exception {
		productDTO = productService.getDetail(productDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productDTO", productDTO);
		mv.setViewName("products/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update2(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		String path = "products/update";
		
		if(result > 0) {
			path = "redirect:./list";
		}
		
		return path;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		String path = "products/detail";
		
		if(result > 0) {
			path = "redirect:./list";
		}
		
		return path;
	}
	
//	-------------- Comments -----------------
	
	@RequestMapping(value = "addComments", method = RequestMethod.POST)
	public String addComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		int result = -1;
		if(userDTO != null) {
			commentsDTO.setUserName(userDTO.getUserName());
			result = productService.addComments(commentsDTO);			
		}

		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "listComments", method = RequestMethod.GET)
	public String listComments(CommentsDTO commentsDTO, Pager pager, Model model) throws Exception {
		
		List<CommentsDTO> list = productService.getCommentsList(commentsDTO, pager);
		
		model.addAttribute("list", list);
		
		
		return "commons/commentsList";
	}
	
	@RequestMapping(value = "deleteComments", method = RequestMethod.POST)
	public String deleteComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		int result = -1;
		if(userDTO != null) {
			commentsDTO.setUserName(userDTO.getUserName());
			result = productService.deleteComments(commentsDTO);			
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value = "updateComments", method = RequestMethod.POST)
	public String updateComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		int result = -1;
		if(userDTO != null) {
			commentsDTO.setUserName(userDTO.getUserName());
			result = productService.updateComments(commentsDTO);			
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}

}
