package com.root.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// DS -> Controller
		System.out.println("preHandle");
		Object user = request.getSession().getAttribute("user");
		
		
		// return이 true라면 Controller로 진행
		// return이 False라면 Controller로 진행X
		if(user != null) {
			return true;
		}else {
//			1. redirect
//			response.sendRedirect("/users/login");
//			2. forward
			request.setAttribute("result", "로그인 필요");
			request.setAttribute("path", "/users/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			view.forward(request, response);
			
			return false;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller -> DS
		System.out.println("postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// HTML로 렌더링 후 (거의 안씀)
		System.out.println("afterCompletion");
	}
	
	

}
