package com.lms.controller.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lms.service.book.BookService;
import com.lms.service.issuance.IssuanceService;
import com.lms.service.request.RequestService;
import com.lms.service.user.UserService;

/**
 * Servlet implementation class RequestAdmit1
 */
@WebServlet("/RequestAdmit")
public class RequestAdmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAdmit() {
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
		String id=request.getParameter("requestId");
		String bookName=request.getParameter("bookName");
		String userName=request.getParameter("userName");
		
		IssuanceService issuanceService=new IssuanceService();
		RequestService service=new RequestService();
		BookService bookService=new BookService();
		UserService userService=new UserService();
		
		
		Integer bookId=bookService.findId(bookName);
		Integer userId=userService.findId(userName);
		issuanceService.save(bookId, userId);
		
		bookService.statusUp(bookName);
		
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(service.admit((Integer.valueOf(id)))));
	}

}
