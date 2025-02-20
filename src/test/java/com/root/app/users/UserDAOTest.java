package com.root.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.app.SampleTestCase;

public class UserDAOTest extends SampleTestCase {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserService userService;
	
//	@Test(expected = Exception.class)
	public void joinTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("id");
		userDTO.setPassWord("pw");
		userDTO.setName("name");
		userDTO.setPhone("phone");
		userDTO.setEmail("email");
//		int result = userDAO.join(userDTO);
		int result = 0;
		
//		단정문 assert
		assertEquals(1, result);
		
	}
	
	@Test
	public void getDetailTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("1");
		
		userDTO = userDAO.getDetail(userDTO);
		
		assertNotNull(userDTO);
	}
	
	@Test
	public void loginTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("1");
		userDTO.setPassWord("1234");
		
		userDTO = userService.login(userDTO);
		
		assertNotNull(userDTO);
	}

}
