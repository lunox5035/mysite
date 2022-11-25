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

	//--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
//		public Map<String, Object> findContentsList(int currentPage){
	//	
//		// view의 페이징을 처리하기 위한 데이터의 값 계산
//		if (currentPage<1){
//			int beginPage = 1;
//			int endPage = 1;
//		}
//		// 리스트 가져오기
//		List<BoardVo> list = boardRepository.findAll();
	//	
//		Map<String,Object> map = new HashMap<String,Object>();
	//	
//		map.put("no",no);
//		map.put("title", title);
//		map.put("name", name);
//		map.put("hit", hit);
//		map.put("reg_date", reg-date);
		
		public List<BoardVo>  findContentsList() {
			 List<BoardVo> list=boardRepository.findAll();
			 
			return list;
		}
	//--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==

	public BoardVo findContents(Long no) {
		
		boardRepository.hitPuls(no);//hit +1
		
		return boardRepository.findByNo(no);
	}
	
	//★
	public boolean OrderNOPuls(BoardVo vo) {
		return boardRepository.OrderNOPuls(vo.getGroupNo(), vo.getOrderNo())>0;
	}
	
	//수정하는 화면갈때
	public BoardVo findContents(Long no, Long userNo) {
		
		return boardRepository.findByNoAndUserNo(no,userNo);
	}

//-----------------------------------------------------------------------------

	public void updateContents(BoardVo vo) {
		boardRepository.update(vo);
	}
//-----------------------------------------------------------------------------
	
	public boolean addContents(BoardVo vo) {
		if(vo.getGroupNo() !=null) {	//★
			OrderNOPuls(vo);
		}
		return boardRepository.insert(vo)==1; 	
	}


		
	public void deleteContents(Long no, Long UserNo) {
		boardRepository.delete(no,UserNo);
	}
}