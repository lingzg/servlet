package com.ling.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter {
	/*
	 * 容器启动之后，会立即创建 过滤器实例(只会创建一个)
	 */
	public CommentFilter() {
		System.out.println("Filter's constructor...");
	}

	public void destroy() {

	}

	/*
	 * 容器调用doFilter方法来处理请求。 FilterChain 过滤器链 如果调用了FilterChain的
	 * doFilter(request,response),则容器 会继续向后调用。
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Filter's doFilter begin...");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		if (content.indexOf("狗") != -1) {
			out.println("评论的内容非法");
		} else {
			// 向后继续调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("Filter's doFilter end.");
	}

	/*
	 * 容器在创建好过滤器实例之后， 会调用其init方法。 该方法只会执行一次。
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter's init...");
	}

}
