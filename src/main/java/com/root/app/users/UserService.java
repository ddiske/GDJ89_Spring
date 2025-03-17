package com.root.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.root.app.carts.CartDTO;
import com.root.app.files.FileDAO;
import com.root.app.pages.Pager;
import com.root.app.products.ProductDTO;

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
		
		UserFileDTO userFileDTO = this.save(context, profile, userDTO);
		
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
			
			throw new UserNameException("비밀번호가 틀렸다");
		}
		
		return null;
		
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		return userDAO.getDetail(userDTO);
	}
	
	public int update(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		// dao user정보를 update
		int result = userDAO.update(userDTO);
		
		// update 후에 결과값이 0이면 insert 시도
		UserFileDTO userFileDTO = this.save(context, profile, userDTO);
		
		if(result == 0) {
			
		}
		
		return result;
	}
	
	public int addCart(CartDTO cartDTO) throws Exception {
		return userDAO.addCart(cartDTO);
	}
	
	public List<ProductDTO> getCartList(Pager pager, Object userDTO) throws Exception {
		Long totalCount = userDAO.getCartTotalCount(userDTO);
		
		pager.make(totalCount);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("user", userDTO);
		
		return userDAO.getCartList(map);
	}
	
	private UserFileDTO save(ServletContext context, MultipartFile profile, UserDTO userDTO) throws Exception {
		String path = context.getRealPath("/resources/images/profiles/");
		
		String f = fileDAO.upload(path, profile);
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUserName());
		userFileDTO.setFileName(f);
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		return userFileDTO;
	}
	
	public int cartDelete(Map<String, Object> map) throws Exception {
		return userDAO.cartDelete(map);
	}

}
