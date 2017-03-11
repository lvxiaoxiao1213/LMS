package com.lms.controller.issuance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.service.book.BookService;
import com.lms.service.issuance.IssuanceService;

/**
 * Servlet implementation class IssuanceReturn
 */
@WebServlet("/IssuanceReturn")
public class IssuanceReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuanceReturn() {
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
		String id=request.getParameter("issuanceId");
		String bookName=request.getParameter("bookName");
		
		IssuanceService issuanceService=new IssuanceService();
		BookService bookService=new BookService();
		bookService.statusDown(bookName);
		issuanceService.returnBook(Integer.valueOf(id));
	}

}
