package com.root.app.boards.qna;

import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("kind")
	public String getKind() {
		return "qna";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		model.addAttribute("list", qnaService.getList(pager));
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@RequestMapping(value = "detail",  method = RequestMethod.GET)
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaService.getDetail(qnaDTO));
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model) throws Exception{
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "board/boardForm";
		}
		
		return "commons/result";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO, HttpSession session, Pager pager, MultipartFile [] attaches) throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("user");
		qnaDTO.setUserName(user.getUserName());
		qnaService.add(qnaDTO, session, attaches);
		
		return "redirect: ./list";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		return "board/boardForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update2(QnaDTO qnaDTO, Model model, MultipartFile [] attaches, HttpSession session) throws Exception {
		qnaService.update(qnaDTO, attaches, session);
		model.addAttribute("dto", qnaService.getDetail(qnaDTO));
		return "redirect: ./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(QnaDTO qnaDTO, Model model, MultipartFile [] attaches, HttpSession session) throws Exception {
		qnaService.delete(qnaDTO, attaches, session);
		model.addAttribute("result", "글이 삭제되었습니다");
		model.addAttribute("path", "list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(@ModelAttribute("dto") BoardDTO boardDTO) throws Exception {
		return "board/boardForm";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(@ModelAttribute("dto") QnaDTO qnaDTO, HttpSession session) throws Exception {
		UserDTO user = (UserDTO)session.getAttribute("user");
		qnaDTO.setUserName(user.getUserName());
		qnaService.reply(qnaDTO);
		
		return "redirect: ./list";
	}
	
	@RequestMapping(value = "fileDelete", method = RequestMethod.POST)
	public String fileDelete(BoardFileDTO boardFileDTO, HttpSession session, Model model) throws Exception {
		int result = qnaService.fileDelete(boardFileDTO, session);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
}
