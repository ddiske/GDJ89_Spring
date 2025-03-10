package com.root.app.boards.qna;

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
import com.root.app.boards.notice.NoticeDTO;
import com.root.app.files.FileDAO;
import com.root.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileDAO fileDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = qnaDAO.getTotalCount(pager);
		pager.make(totalCount);
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
//		if(check) {
//		}
		qnaDAO.updateHit(boardDTO);			
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches) throws Exception {
		int result = qnaDAO.add(boardDTO);
		for(MultipartFile attach: attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
		}
				
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile [] attaches, HttpSession session) throws Exception {
		int result = qnaDAO.update(boardDTO);
		for(MultipartFile attach: attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			//DB에 저장
			//
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
		}
		
		return result;
	}	

	@Override
	public int delete(BoardDTO boardDTO, MultipartFile [] attaches, HttpSession session) throws Exception {
		boardDTO = qnaDAO.getDetail(boardDTO);
		int result = qnaDAO.delete(boardDTO);
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/qna/");
			for(BoardFileDTO boardFileDTO : ((QnaDTO)boardDTO).getBoardFileDTOs()) {
				
				fileDAO.fileDelete(path, boardFileDTO.getFileName());
			}
		}
		
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		
		
		
		//step update
		qnaDAO.updateStep(qnaDTO);
		
		
		return qnaDAO.reply(qnaDTO);
		
	}
	
	private BoardFileDTO fileSave(MultipartFile attach, ServletContext servletContext)throws Exception{
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/images/qna/");
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 리턴
		String fileName = fileDAO.upload(path, attach);
		
		//3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO, HttpSession session) throws Exception {
		// 1. 정보 조회
		boardFileDTO = qnaDAO.getFileDetail(boardFileDTO);
		// 2. DB에서 삭제
		int result = qnaDAO.fileDelete(boardFileDTO);
		// 3. HDD에서 삭제
		if(result > 0) {
			String path = session.getServletContext().getRealPath("/resources/images/qna/");
			fileDAO.fileDelete(path, boardFileDTO.getFileName());
		}
		return result;
	}
	
	

}
