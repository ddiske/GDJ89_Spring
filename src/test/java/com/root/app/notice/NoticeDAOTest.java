package com.root.app.notice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTestCase;
import com.root.app.boards.notice.NoticeDAO;
import com.root.app.boards.notice.NoticeDTO;

public class NoticeDAOTest extends SampleTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest() throws Exception {
//		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
//		ar = noticeDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
//	public void getDetailTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setBoardNum(1);
//		noticeDTO = noticeDAO.getDetail(noticeDTO);
//		
//		assertNotNull(noticeDTO);
//	}
	
//	@Test
	public void addTest() throws Exception {
		
		for(int i = 1; i <= 100; i++) {
			
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setUserName("admin");
			noticeDTO.setBoardTitle("addTest"+i);
			noticeDTO.setBoardContents("addTest"+i);
			noticeDAO.add(noticeDTO);
			
			if(i%10 == 0) {
				Thread.sleep(500);
			}
			
		}
		
//		assertEquals(1, result);
	}
	
//	@Test
	public void updateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1L);
		noticeDTO.setBoardTitle("test");
		noticeDTO.setBoardContents("test");
		int result = noticeDAO.update(noticeDTO);
		
		assertEquals(1,result);
	}
	
//	@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(2L);
		int result = noticeDAO.delete(noticeDTO);
		
		assertEquals(1, result);
	}

}
