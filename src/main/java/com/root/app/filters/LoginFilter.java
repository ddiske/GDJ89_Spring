package com.root.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터 객체가 소멸될 때 실행
		// 서버가 종료되기 직전
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청이 들어오면 실행하는 영역
		System.out.println("요청 발생");
		HttpServletRequest req = (HttpServletRequest)request;
		Object user = req.getSession().getAttribute("user");
		if(user != null) {
			// 다음 필터의 doFilter메서드 호출
			chain.doFilter(request, response);
			// 다음 필터가 없다면 DispatcherServlet으로 이동			
		}
		
		// 1. redirect
//		HttpServletResponse res = (HttpServletResponse)response;
//		res.sendRedirect("/users/login");
		
		// 2. forward
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		req.setAttribute("result", "로그인이 필요합니다");
		req.setAttribute("path", "/users/login");
		view.forward(request, response);
		
		// 응답이 나갈 때 실행하는 영역
		System.out.println("응답 발생");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 객체가 생성될 때 실행
	}

}
