package com.root.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.files.FileDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FileDAO fileDAO;
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		int result = userDAO.join(userDTO);
		
		if(profile.isEmpty()) {
			return result;
		}else if(result == 0) {
			return result;
		}
		// 1. 어디에 저장할 것인가
		String path = context.getRealPath("/resources/images/profiles/");
		
		String f = fileDAO.upload(path, profile);

		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUserName());
		userFileDTO.setFileName(f);
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		result = userDAO.upload(userFileDTO);
		
		return result;
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
	
	public int update(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		int result = userDAO.update(userDTO);
		
		if(result == 0) {
			String path = context.getRealPath("/resources/images/profiles/");
			
			String f = fileDAO.upload(path, profile);

			
			UserFileDTO userFileDTO = new UserFileDTO();
			userFileDTO.setUserName(userDTO.getUserName());
			userFileDTO.setFileName(f);
			userFileDTO.setOldName(profile.getOriginalFilename());
			
			result = userDAO.upload(userFileDTO);
		}
		
		
		
		return result;
	}

}
