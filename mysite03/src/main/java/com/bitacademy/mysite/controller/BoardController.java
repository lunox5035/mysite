package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	private String list(
			@RequestParam(value = "no", required = true,defaultValue ="")Long no,
			Long userNo) {
		boardService.findContents(no, userNo);
		
		return "board/list";
	}
	
//	@RequestMapping("/add")
//	public String add(BoardVo vo) {
//		
//	}
//	
}
