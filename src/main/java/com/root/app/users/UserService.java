package com.root.app.users;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int join(UserDTO userDTO, MultipartFile proFile, ServletContext context) throws Exception {
		// 1. 어디에 저장할 것인가
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		
		// 2. 어떤 파일을 무슨 이름으로 저장할 것인가
		
		return 0;//userDAO.join(userDTO);
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
//		result는 username(id)만 비교
		UserDTO result = userDAO.getDetail(userDTO);
		if(result != null) {
			if(result.getPassWord().equals(userDTO.getPassWord())) {
				return result;
			}
		}
		
		return null;
		
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		return userDAO.getDetail(userDTO);
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return userDAO.update(userDTO);
	}

}
