package com.root.app.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getTotalCount();
		pager.make(totalCount);
		return qnaDAO.getList(pager);
	}
	
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
		qnaDAO.updateHit(qnaDTO);
		return qnaDAO.getDetail(qnaDTO);
	}
	
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}
	
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

}
