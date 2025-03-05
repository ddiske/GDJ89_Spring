package com.root.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.root.app.pages.Pager;

public interface BoardService {
	
	// list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	// detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	// add
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches) throws Exception;
	
	// update
	public int update(BoardDTO boardDTO) throws Exception;
	
	// delete
	public int delete(BoardDTO boardDTO) throws Exception;

}
