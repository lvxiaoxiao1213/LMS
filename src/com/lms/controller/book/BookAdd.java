package com.lms.controller.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lms.entity.book.Book;
import com.lms.service.book.BookService;

/**
 * Servlet implementation class Book_add
 */
@WebServlet("/BookAdd")
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdd() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String bookname=request.getParameter("bookname");
		String auth=request.getParameter("auth");
		String catId=request.getParameter("category");
		String publisher=request.getParameter("publisher");
		String remark=request.getParameter("remark");
		BookService service = new BookService();
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(service.save(new Book(bookname, auth,publisher,Integer.valueOf(catId),remark))));
		
		request.getRequestDispatcher("/bookAdd.jsp").forward(request,response);
	}

}
