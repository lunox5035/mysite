package com.bitacademy.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.mysite.service.UserService;
import com.bitacademy.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
		
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		userService.join(vo);
		return "redirect:/user/joinsuccess";
		
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, UserVo vo, Model model) {
		UserVo authUser = userService.findUser(vo);
		if(authUser==null) {
			model.addAttribute("email", vo.getEmail());
			return"/user/login";
		}
		
		session.setAttribute("authUser", authUser);
		return "redirect:/";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//Access Control
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		if(authUser==null) {
			return "redirect:/"; 
		}
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/"; 
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, HttpSession session) {
		// Access Control
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		
		UserVo vo = userService.findUser(authUser.getNo());
		model.addAttribute("userVo", vo);
		return "user/update";
		
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpSession session, UserVo vo) {
		//Access Control
				UserVo authUser=(UserVo)session.getAttribute("authUser");
				if(authUser==null) {
					return "redirect:/"; 
				}
				
				vo.setNo(authUser.getNo());
				userService.updateUser(vo);
				
				authUser.setName(vo.getName());
				
				return "redirect:/"; 
	}
}
