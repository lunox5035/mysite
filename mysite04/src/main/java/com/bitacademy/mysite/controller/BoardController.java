package com.bitacademy.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.mysite.security.Auth;
import com.bitacademy.mysite.security.AuthUser;
import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;

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
	
	@RequestMapping("/view/{no}")//○
	private String view(@PathVariable("no") Long no ,Model model) {
		System.out.println(no);
		model.addAttribute("vo",boardService.findContents(no));

		return "board/view";
	}
	@RequestMapping(value = "/modify/{no}", method = RequestMethod.GET)//
	private String modify(@AuthUser UserVo authUser,@PathVariable("no") Long no ,Model model) {		
	model.addAttribute("vo",boardService.findContents(no,authUser.getNo()));
		
		return "board/modify";
		
	}

	@Auth
	@RequestMapping(value = "/delete/{no}",method = RequestMethod.POST)
	private String delete(
			@PathVariable("no") Long no, 
			Long userNo, 
			Model model){
		model.addAttribute("no",no);
		boardService.deleteContents(no, userNo);
		return "redirect:/list";
	}
	
//--------------------------------------------------------------------------
	@Auth
	@RequestMapping(value = "/write", method = RequestMethod.GET)//○
	private String write(Long no,Model model) {
		model.addAttribute("userNo",no );
		return "board/write"; 
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	private String write() {

		return "redirect:/";
	}
	
	
}
