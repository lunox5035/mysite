package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.mysite.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping()
	private String findContents(@PathVariable("no") Long no, Long userNo) {
		boardService.findContents(no, userNo);
		
		return "board/list";
	}
	
	
}
