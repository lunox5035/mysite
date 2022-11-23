package com.bitacademy.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("")
//	private String list(
//			@RequestParam(value = "currentPage", required = true, defaultValue = "1")Integer currentPage, 
//			Model model) {
//		
//		model.addAttribute("list",boardService.findContentsList(currentPage));
	private String list(Model model) {
		List<BoardVo> list = boardService.findContentsList();
		model.addAttribute("list", list);
		return "board/list";
	}
	@RequestMapping("/view/{no}")
	private String view(@PathVariable("no") Long no ,Model model) {
		BoardVo vo =boardService.findContents(no);
		model.addAttribute("BoardVo",vo);
		return "board/view";
	}
	
//	@RequestMapping("/add")
//	public String add(BoardVo vo) {
//	}
}
