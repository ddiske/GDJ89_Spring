package com.root.app.boards.qna;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.root.app.boards.BoardDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Pager pager, Model model) throws Exception {
		model.addAttribute("list", qnaService.getList(pager));
		model.addAttribute("pager", pager);
	}
	
	@RequestMapping(value = "detail",  method = RequestMethod.GET)
	public void getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("qnaDTO", qnaService.getDetail(qnaDTO));
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model) throws Exception{
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "/notice/add";
		}
		
		return "commons/result";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO, HttpSession session, Pager pager) throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("user");
		qnaDTO.setUserName(user.getUserName());
		qnaService.add(qnaDTO);
		
		return "redirect: ./list";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(QnaDTO qnaDTO) throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(QnaDTO qnaDTO, Model model) throws Exception {
		qnaService.update(qnaDTO);
		model.addAttribute("qnaDTO", qnaService.getDetail(qnaDTO));
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO, Model model) throws Exception {
		qnaService.delete(qnaDTO);
		model.addAttribute("result", "글이 삭제되었습니다");
		model.addAttribute("path", "/notice/list");
		
		return "commons/result";
	}

}
