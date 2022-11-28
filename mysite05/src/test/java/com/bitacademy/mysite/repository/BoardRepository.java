package com.bitacademy.mysite.repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.BoardVo;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlSession;

	public int delete(Long no, Long userNo) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("no",no);
		map.put("userNo",userNo);
		
		return sqlSession.delete("board.update",map);
	}

	public boolean update(BoardVo vo) {
		int count = sqlSession.update("board.update",vo);
		return count==1;
	}
//-----------------------------------------------------------------------------
	public BoardVo view(Long no) {
		BoardVo vo=sqlSession.selectOne("board.view", no);	
		
		return vo;
	}

	public BoardVo findByNoAndUserNo(Long no, Long userNo) {
		
		return sqlSession.selectOne("board.findByNo", no);
	}

	public BoardVo findByNo(Long no) {
		
		return sqlSession.selectOne("board.findByNo", no);
	}

	public List<BoardVo> findAll() {
		List<BoardVo> list=sqlSession.selectList("board.findAll");
		return list;
	}
	
	public int hitPuls(Long no) {
		
		return sqlSession.update("board.hit",no);
	}
	
//	public boolean newWrite(BoardVo boardVo) {
//	
//		return sqlsession.insert("board.insert",boardVo)==1;
//	}
	
	public int insert(BoardVo vo) {
		return sqlSession.insert("board.insert",vo);
	}
	
	public int OrderNOPuls(Integer groupNo,Integer oerderNo) {
		Map<String, Integer> map= new HashMap<>();
		map.put("orderNo", oerderNo);
		map.put("groupNo",groupNo);

		return sqlSession.update("board.orderNo",map);
	}
	
	
	public int getTotalCount(String keyword) {
		return sqlSession.selectOne("board.totalCount", keyword);
	}
	public List<BoardVo> findAllByPageAndKeword(String keyword, Integer page, Integer size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("startIndex", (page - 1) * size);
		map.put("size", size);

		return sqlSession.selectList("board.findAllByPageAndKeword", map);
	}
}

