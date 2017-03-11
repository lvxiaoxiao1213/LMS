package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.lms.service.LoginService;
import com.lms.service.message.MessageService;
import com.lms.service.request.RequestService;
import com.lms.service.user.UserService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		request.setAttribute("users", null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		LoginService service = new LoginService();
		System.out.println(name + password);
		HttpSession session = request.getSession();
		session.setAttribute("user", name);
		Integer status = service.loginStatus(name);
		session.setAttribute("status", status);
		PrintWriter out = response.getWriter();
		RequestService requestService=new RequestService();
		session.setAttribute("count", requestService.query());
		
		MessageService messageService=new MessageService();
		UserService userService=new UserService();
		Integer id=userService.findId(name);
		session.setAttribute("countmessage", messageService.query(id));

		if (service.login(name, password)) {
			if (status == 1) {
				out.print("<script language='JavaScript'> alert('你已被管理员拉进小黑屋');window.location.href='login.jsp';</script>");
			} else if (service.loginRole(name) == 1 || service.loginRole(name) == 2) {
				session.setAttribute("role", service.loginRole(name));
				request.getRequestDispatcher("mainmember.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("main.jsp").forward(request, response);
			}

		} else {
			out.print("<script language='JavaScript'> alert('你的用户名或密码错误');window.location.href='login.jsp';</script>");
		}

	}

}
