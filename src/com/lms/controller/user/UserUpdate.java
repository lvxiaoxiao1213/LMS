package com.lms.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.entity.User;

import com.lms.service.user.UserService;
import com.lms.util.ValidatorUtil;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		String tell=request.getParameter("tell");
		String address=request.getParameter("address");
		String id=request.getParameter("id");
		UserService service=new UserService();
		PrintWriter out=response.getWriter();
		if(ValidatorUtil.isEmail(email)){
			service.update(new User(Integer.valueOf(id),tell,address,email));
			request.getRequestDispatcher("updateSuccessMember.jsp").forward(request, response);
		}else
		out.print("<script language='JavaScript'> alert('邮箱格式不正确');window.location.href='userInfo.jsp';</script>");
	}

}
