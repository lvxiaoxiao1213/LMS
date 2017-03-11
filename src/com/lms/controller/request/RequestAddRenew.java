package com.lms.controller.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.service.book.BookService;
import com.lms.service.request.RequestService;
import com.lms.service.user.UserService;

/**
 * Servlet implementation class RequestAddRenew
 */
@WebServlet("/RequestAddRenew")
public class RequestAddRenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAddRenew() {
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
		String userName=request.getParameter("userName");
		String bookName=request.getParameter("bookName");
		BookService bookService=new BookService();
		UserService userService=new UserService();
		Integer userId=userService.findId(userName);
		Integer bookId=bookService.findId(bookName);
		RequestService service=new RequestService();
		service.insertRenew(bookId, userId);
	}

}
