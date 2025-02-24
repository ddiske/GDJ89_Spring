package com.root.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.pages.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getTotalCount();
		
		pager.make(totalCount);
		
		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
	
	public int updateHit(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.updateHit(noticeDTO);
	}

}
