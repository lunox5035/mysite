package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.mysite.service.UserService;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private UserService guestbookService;
}
