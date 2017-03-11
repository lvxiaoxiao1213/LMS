package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.lms.entity.User;
import com.lms.service.RegisterService;
import com.lms.util.ValidatorUtil;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String tell = request.getParameter("tell");
		String idcard = request.getParameter("idcard");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String passwordconfirm = request.getParameter("passwordconfirm");
		if (StringUtils.isNoneEmpty(name) && StringUtils.isNotEmpty(tell) && StringUtils.isNotEmpty(address)
				&& StringUtils.isNotEmpty(password) && ValidatorUtil.isEmail(email) && StringUtils.isNotEmpty(idcard)) {
			if(password.equals(passwordconfirm)){
				User user = new User(name, tell, idcard, address, email, password);		
				RegisterService service = new RegisterService();
				PrintWriter out = response.getWriter();
				out.write(JSON.toJSONString(service.register(user)));
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
		
}
