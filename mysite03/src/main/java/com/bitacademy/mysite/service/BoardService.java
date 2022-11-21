package com.bitacademy.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	
	public void addContents(BoardVo vo) {
		boardRepository.insert(vo);
		
	}
	
	public BoardVo findContents(Long no) {
		
		return boardRepository.findByNo(no);
	}
	
	//수정하는 화면갈때
//	public BoardVo findContents(Long no, Long userNo) {
//		
//		return boardRepository.findByNoAndUserNo(no,userNo);
//	}
	
	public Map<String, Object> findContentsList(int currentPage){
		
		// view의 페이징을 처리하기 위한 데이터의 값 계산
		if (currentPage<1){
			int beginPage = 1;
			int endPage = 1;
		}
		// 리스트 가져오기
		List<BoardVo> list = boardRepository.findAll();
		
		
		
		
		return null;
	}
	
	public void updateContents(BoardVo vo) {
		boardRepository.update(vo);
	}
		
//	public void deleteContents(Long no, Long UserNo) {
//		boardRepository.delete(no,UserNo);
//	}
}