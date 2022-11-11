package com.bitacademy.mysite.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.mysite.dao.BoardDao;
import com.bitacademy.mysite.vo.BoardVo;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("a");
		
		if("writeform".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
			.forward(request, response);
		} else if("write".equals(action)) {
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContents(contents);

			new BoardDao().write(vo);

			response.sendRedirect(request.getContextPath());
			
//=================================================================================
		}else if("viewform".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/view.jsp")
			.forward(request, response);
		}else if("view".equals(action)) {
			HttpSession session = request.getSession();
			BoardVo authUser  = (BoardVo)session.getAttribute("authUser ");
		
//=================================================================================			
		}else if("modifyform".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/modify.jsp")
			.forward(request, response);
		}else if("modify".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
			.forward(request, response);
			
//=================================================================================
//		}else if("list".equals(action)) {
//			
//			UserDao dao = new UserDao();
//			UserVo authUser = dao.load(no);
//			
		}else if("viewform".equals(action)) {
			request
			.getRequestDispatcher("/WEB-INF/views/board/write.jsp")
			.forward(request, response);
		}else{
			request
				.getRequestDispatcher("/WEB-INF/views/board/list.jsp")
				.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}