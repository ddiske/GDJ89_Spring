package com.root.app.products;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTestCase;

public class ProductDAOTest extends SampleTestCase {
	
	@Autowired
	private ProductDAO productDAO;
	
	@BeforeClass
	public static void bf() {
		System.out.println("전체 테스트 시작 전");
	}

	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료 후");
	}
	
	@Before
	public void fe() {
		System.out.println("개별 테스트 실행 전");
	}
	
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	@Test
	public void getDetailTest() throws Exception {
		System.out.println("getDetailTest");
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(5000L);
		
		productDTO = productDAO.getDetail(productDTO);
		
		assertNull(productDTO);	
	}
	
	@Test
	public void getListTest() throws Exception {
		System.out.println("getListTest");
		List<ProductDTO> ar = productDAO.getList();
		
		assertNotEquals(0, ar.size());
	}

}
