package com.root.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.root.app.boards.BoardDTO;
import com.root.app.users.UserDTO;


public class UserNameCheckInterceptor extends HandlerInterceptorAdapter {
	


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		BoardDTO boardDTO = (BoardDTO)modelAndView.getModel().get("dto");
		
		if(!userDTO.getUserName().equals(boardDTO.getUserName())) {
			modelAndView.setViewName("commons/result");
			modelAndView.getModel().put("result", "수정 권한 없음");
			modelAndView.getModel().put("path", "./list");
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
