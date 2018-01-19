package com.ling.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 读取请求参数
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		int salary2 = Integer.parseInt(salary) * 2;
		// 处理
		String greeting = "Hello " + name + ", your " + "salary is " + salary2;
		// 设置服务器返回的数据类型
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div style='font-size:30px;color:red;'>" + greeting + "</div>");
		out.close();

		/*
		 * response.setContentType("text/html");
		 * PrintWriter out = response.getWriter();
		 * out.println("<h1>Hello Kitty</h1>");
		 * out.close();
		 */

	}
}
