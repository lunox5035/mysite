package com.bitacademy.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.dao.guestbookDao;
import com.bitacademy.mysite.vo.guestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("a");
		
		if("insert".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			guestbookVo vo=new guestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(message);
			new guestbookDao().insert(vo);
			
			response.sendRedirect("/mysite02/guestbook");
		}else if("deleteform".equals(action)){
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(request, response);

		}else if("delete".equals(action)){
			String sno=request.getParameter("no");
			Long no=Long.parseLong(sno);
			String password = request.getParameter("password");
			
			new guestbookDao().deleteByNoAndPassword(no, password);

			response.sendRedirect(request.getContextPath()+"/guestbook");
			
		}else {	
			List<guestbookVo> list = new guestbookDao().findAll();
			
			request.setAttribute("list", list);
			request
			.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp")
			.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
