package com.root.app.notice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTestCase;

public class NoticeDAOTest extends SampleTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
	public void getListTest() throws Exception {
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getDetailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1);
		noticeDTO = noticeDAO.getDetail(noticeDTO);
		
		assertNotNull(noticeDTO);
	}
	
//	@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setUserName("test");
		noticeDTO.setBoardTitle("addTest");
		noticeDTO.setBoardContents("addTest");
		int result = noticeDAO.add(noticeDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
	public void updateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1);
		noticeDTO.setBoardTitle("test");
		noticeDTO.setBoardContents("test");
		int result = noticeDAO.update(noticeDTO);
		
		assertEquals(1,result);
	}
	
//	@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(2);
		int result = noticeDAO.delete(noticeDTO);
		
		assertEquals(1, result);
	}

}
