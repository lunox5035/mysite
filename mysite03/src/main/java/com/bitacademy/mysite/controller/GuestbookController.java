package com.bitacademy.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.mysite.service.GuestbookService;
import com.bitacademy.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;

	//O
	@RequestMapping("")
	public String getContentsList(Model model) {
		List<GuestbookVo> list = guestbookService.getContentsList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	
	//O
	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookService.addContents(vo);
		return "redirect:/guestbook";
	}
	//O
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String deleteContents (@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		System.out.println(no);
	
		return "guestbook/delete";
	}

	//O
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String deleteContents(
			@PathVariable("no") Long no,
			@RequestParam(value = "password",required = true,defaultValue = "") String password) {
		
		guestbookService.deleteContents(no, password);
		return "redirect:/guestbook";
	
	}
	
}
