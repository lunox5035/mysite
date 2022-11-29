package com.bitacademy.mysite.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.mysite.security.Auth;
import com.bitacademy.mysite.security.AuthUser;
import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;
import com.bitacademy.mysite.web.WebUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("")
	public String list(@RequestParam(value="p", required=true, defaultValue="1") Integer page, @RequestParam(value = "kwd", required = true, defaultValue = "") String keyword, Model model) {
		Map<String, Object> map = boardService.getContentsList(page, keyword);
		model.addAttribute("map", map);
		// model.addAllAttributes(map);
		
		return "board/list";
	}
}