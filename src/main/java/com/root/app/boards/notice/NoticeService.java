package com.root.app.boards.notice;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.boards.BoardService;
import com.root.app.files.FileDAO;
import com.root.app.pages.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileDAO fileDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = noticeDAO.getTotalCount(pager);
		pager.make(totalCount);
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
//		if(check) {
//			noticeDAO.updateHit(boardDTO);			
//		}
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches) throws Exception {
		//1. DB에 Notice정보를 Insert
		int result = noticeDAO.add(boardDTO);
		//2. HDD에 파일을 저장하고 그 정보들을 DB에 저장
		for(MultipartFile attach: attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
		}
				
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}
	
	public int update(BoardDTO boardDTO, MultipartFile [] attaches, HttpSession session) throws Exception {
		int result = noticeDAO.update(boardDTO);
		
		for(MultipartFile attach: attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = noticeDAO.addFile(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.delete(boardDTO);
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO, HttpSession session) throws Exception {
		// 1. 정보 조회
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		// 2. DB에서 삭제
		int result = noticeDAO.fileDelete(boardFileDTO);
		// 3. HDD에서 삭제
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/notice/");
			fileDAO.fileDelete(path, boardFileDTO.getFileName());
		}
		return result;
	}
	
	private BoardFileDTO fileSave(MultipartFile attach, ServletContext servletContext)throws Exception{
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/images/notice/");
		
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 리턴
		String fileName=fileDAO.upload(path, attach);
		
		//3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
	
}
