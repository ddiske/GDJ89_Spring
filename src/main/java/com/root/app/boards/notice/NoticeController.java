package com.root.app.boards.notice;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.root.app.boards.BoardDTO;
import com.root.app.pages.Pager;
import com.root.app.users.UserDTO;


@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("kind")
	public String getKind() {
		return "Notice";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", noticeService.getList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		
		noticeDTO = (NoticeDTO)noticeService.getDetail(noticeDTO);
		
		model.addAttribute("dto", noticeDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model) throws Exception {
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "board/boardForm";
		}
		
		return "commons/result";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO, HttpSession session, Pager pager) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		noticeDTO.setUserName(userDTO.getUserName());
		noticeService.add(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", noticeService.getList(pager));
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = (NoticeDTO)noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/boardForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		noticeService.update(noticeDTO);
		noticeDTO = (NoticeDTO)noticeService.getDetail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		if(result > 0) {
			model.addAttribute("result", "글이 삭제되었습니다");
			model.addAttribute("path", "list");
		}else {
			model.addAttribute("result", "삭제 실패");
			model.addAttribute("path", "list");
		}
		
		return "commons/result";
	}

}
