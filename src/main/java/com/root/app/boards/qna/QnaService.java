package com.root.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardService;
import com.root.app.pages.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

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
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}	

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		// boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글번호
		QnaDTO parent = (QnaDTO)qnaDAO.getDetail(qnaDTO);
		
		// ref 부모의 ref
		qnaDTO.setBoardRef(parent.getBoardRef());
		
		// step 부모의 step+1
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		
		// depth 부모의 depth+1
		qnaDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		//step update
		qnaDAO.updateStep(parent);
		
		
		return qnaDAO.reply(qnaDTO);
		
	}
	
	

}
