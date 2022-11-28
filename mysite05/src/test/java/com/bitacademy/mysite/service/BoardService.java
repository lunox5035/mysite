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
	private static final int LIST_SIZE = 5; // 리스팅되는 게시물의 수
	private static final int PAGE_SIZE  = 5; // 페이지 리스트의 페이지 수
	
	@Autowired
	private BoardRepository boardRepository;

	//--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
//		public Map<String, Object> findContentsList(int currentPage,String keyword){
//		
//		// view의 페이징을 처리하기 위한 데이터의 값 계산
//			int totalCount = boardRepository.getTotalCount(keyword);
//			int pageCount = (int)Math.ceil((double)totalCount/LIST_SIZE);
//			int blockCount  = (int)Math.ceil((double)totalCount/PAGE_SIZE);
//			int currentBlock  = (int)Math.ceil((double)currentPage/PAGE_SIZE);
//			
//			if(currentPage>pageCount) {
//				currentPage=pageCount;
//				currentBlock=(int)Math.ceil((double) currentPage/LIST_SIZE);
//			}
//		if (currentPage<1){
//			int beginPage = 1;
//			int endPage = 1;
//		}
//
//		int beginPage = currentBlock==0?1:(currentBlock-1)*PAGE_SIZE+1;
//		int prevPage = (currentBlock>1)?(currentBlock-1)*PAGE_SIZE:0;
//		int nextPage = (currentBlock<blockCount)?currentBlock*PAGE_SIZE+1:0;
//		int endPage = (nextPage>0)?(beginPage-1)+LIST_SIZE:pageCount;
//		
//		List<BoardVo> list = boardRepository.변수(keyword,currentPage,LIST_SIZE);
//		// 리스트 가져오기
//		List<BoardVo> map = boardRepository.findAll();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("no",no);
//		map.put("title", title);
//		map.put("name", name);
//		map.put("hit", hit);
//		map.put("reg_date", reg-date);
//		
//		
//		return map;
	public Map<String, Object> getContentsList(int currentPage, String keyword) {

		// 1. 페이징을 위한 기본 데이터 계산
		int totalCount = boardRepository.getTotalCount(keyword);
		int pageCount = (int) Math.ceil((double) totalCount / LIST_SIZE);
		int blockCount = (int) Math.ceil((double) pageCount / PAGE_SIZE);
		int currentBlock = (int) Math.ceil((double) currentPage / PAGE_SIZE);

		// 2. 파라미터 page 값 검증
		if (currentPage > pageCount) {
			currentPage = pageCount;
			currentBlock = (int) Math.ceil((double) currentPage / PAGE_SIZE);
		}

		if (currentPage < 1) {
			currentPage = 1;
			currentBlock = 1;
		}

		// 3. view에서 페이지 리스트를 렌더링 하기위한 데이터 값 계산
		int beginPage = currentBlock == 0 ? 1 : (currentBlock - 1) * PAGE_SIZE + 1;
		int prevPage = (currentBlock > 1) ? (currentBlock - 1) * PAGE_SIZE : 0;
		int nextPage = (currentBlock < blockCount) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = (nextPage > 0) ? (beginPage - 1) + LIST_SIZE : pageCount;

		// 4. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeword(keyword, currentPage, LIST_SIZE);

		// 5. 리스트 정보를 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", currentPage);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("keyword", keyword);

		return map;
	}
	
//		public List<BoardVo>  findContentsList() {
//			 List<BoardVo> list=boardRepository.findAll();
//			 
//			return list;
//		}
	//--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==

	public BoardVo findContents(Long no) {
		
		boardRepository.hitPuls(no);//hit +1
		
		return boardRepository.findByNo(no);
	}
	
	
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