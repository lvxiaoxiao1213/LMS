package com.lms.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.entity.User;

import com.lms.service.user.UserService;

/**
 * Servlet implementation class UserPwd
 */
@WebServlet("/UserPwd")
public class UserPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPwd() {
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
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("user");
		User user=(User)session.getAttribute("one");
		String password=user.getPassword();
		UserService service=new UserService();
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String newpasswordconfirm=request.getParameter("newpasswordconfirm");
		PrintWriter out = response.getWriter();
		if(oldpassword.equals(password)){
			if(newpassword.equals(newpasswordconfirm)){
				service.updatePwd(name, newpassword);
				out.print("<script language='JavaScript'> alert('修改成功！');window.location.href='userInfo.jsp';</script>");
			}else
				out.print("<script language='JavaScript'> alert('新密码输入不一致！');window.location.href='passwordUpdate.jsp';</script>");
		}else
			out.print("<script language='JavaScript'> alert('旧密码错误！');window.location.href='passwordUpdate.jsp';</script>");
	
	}

}
