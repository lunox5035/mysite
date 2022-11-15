package com.bitacademy.mysite.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.bitacademy.emaillist.dao.EmaillistDao;
import com.bitacademy.emaillist.vo.EmaillistVo;
import com.bitacademy.mysite.dao.BoardDao;
import com.bitacademy.mysite.dao.UserDao;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("a");
		
		if("writeform".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
			.forward(request, response);
			
//		} else if("write".equals(action)) {
//			String title = request.getParameter("title");
//			String contents = request.getParameter("contents");
//			
//			BoardVo vo = new BoardVo();
//			vo.setTitle(title);
//			vo.setContents(contents);
//			
//			new BoardDao().insert(vo);
//
//			response.sendRedirect(request.getContextPath()+"/board");
			
//=================================================================================
		}else if("view".equals(action)) {
			
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContents(contents);
			
			String firstName = request.getParameter("no");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			BoardVo vo = new BoardVo();
			vo.BoardVo(no);
			
			new EmaillistDao().insert(vo);
			
			request
			.getRequestDispatcher("/WEB-INF/views/board/view.jsp")
			.forward(request, response);
		
//=================================================================================			
		}else if("modify".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/modify.jsp")
			.forward(request, response);
			
//		}else if("modify".equals(action)) {
//			request
//			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
//			.forward(request, response);
			
//=================================================================================
		}else if("".equals(action)) {
			
				
//		}else if("".equals(action)) {
//			request
//			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
//			.forward(request, response);
			
//=================================================================================
		}else{
			List<BoardVo> list = new BoardDao().findAll();
			
			request.setAttribute("list", list);
			request
				.getRequestDispatcher("/WEB-INF/views/board/list.jsp")
				.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}