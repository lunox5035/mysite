package com.bitacademy.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.vo.GuestbookVo;
@Service
public class GuestbookService  {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	//O
	public List<GuestbookVo> getContentsList() {
		return guestbookRepository.findAll();
	}
	
	//O
	public void deleteContents(Long no, String password) {
		guestbookRepository.deleteByNoAndPassword(no, password);
	}

	//O
	public void addContents(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}
	
}