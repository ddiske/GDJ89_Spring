package com.root.app.accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.users.UserDAO;
import com.root.app.users.UserDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private UserDAO userDAO;
	
	public int add(Long [] nums, UserDTO userDTO) throws Exception {
		
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		int count = 0;
		
		for(Long l : nums) {
			if(count > 10) {
				count = 0;
			}
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setProductNum(l);
			accountDTO.setUserName(userDTO.getUserName());
			accountDTO.setAccountNum(this.random()+count);
			list.add(accountDTO);
			count++;
		}
		
		int result = accountDAO.add(list);
		if(result > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", userDTO);
			map.put("products", nums);
			userDAO.cartDelete(map);
		}
		
		
		return result;
	}
	
	private String random() throws Exception {
		String result = null;
		
		Calendar ca = Calendar.getInstance();
		Object obj = ca.getTimeInMillis();
		result = obj.toString();
		
		return result;
	}

}
