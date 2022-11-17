package com.bitacademy.mysite.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.mysite.dao.BoardDao;
import com.bitacademy.mysite.dao.UserDao;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response, BoardVo authUser) throws ServletException, IOException {
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
			
			String sno = request.getParameter("no");
			Long no= Long.parseLong(sno);
			
			BoardVo vo = new BoardDao().view(no);
			request.setAttribute("BoardVo", vo);
			
			request
			.getRequestDispatcher("/WEB-INF/views/board/view.jsp")
			.forward(request, response);
		
//=================================================================================			
		}else if("modifyform".equals(action)) {
			
			
			request
			.getRequestDispatcher("/WEB-INF/views/board/modify.jsp")
			.forward(request, response);
			
		}else if("modify".equals(action)) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserVo vo = new UserVo();
			vo.setNo(authUser.getNo());
			vo.setName(name);
			vo.setPassword(password);
			vo.setGender(gender);
			
			// update db
			new UserDao().update(vo);
			
			// update session
			authUser.setName(name);
			
			response.sendRedirect(request.getContextPath() + "/borad?a=updateform");
			
//=================================================================================
		}else if("reply".equals(action)) {
			
			
			request
				.getRequestDispatcher("/WEB-INF/views/board/reply.jsp")
				.forward(request, response);	
//=================================================================================
				
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