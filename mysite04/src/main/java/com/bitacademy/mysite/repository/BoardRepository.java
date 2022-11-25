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
	private SqlSession sqlsession;

	public int delete(Long no, Long userNo) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("no",no);
		map.put("userNo",userNo);
		
		return sqlsession.delete("board.update",map);
	}

	public boolean update(BoardVo vo) {
		int count = sqlsession.update("board.update",vo);
		return count==1;
	}
//-----------------------------------------------------------------------------
	public BoardVo view(Long no) {
		BoardVo vo=sqlsession.selectOne("board.view", no);	
		
		return vo;
	}

	public BoardVo findByNoAndUserNo(Long no, Long userNo) {
		
		return sqlsession.selectOne("board.findByNo", no);
	}

	public BoardVo findByNo(Long no) {
		
		return sqlsession.selectOne("board.findByNo", no);
	}

	public List<BoardVo> findAll() {
		List<BoardVo> list=sqlsession.selectList("board.findAll");
		return list;
	}
	
	public int hitPuls(Long no) {
		
		return sqlsession.update("board.hit",no);
	}
//	public boolean newWrite(BoardVo boardVo) {
	
//		return sqlsession.insert("board.insert",boardVo)==1;
	public int insert(BoardVo vo) {
		return sqlsession.insert("board.insert",vo);
	}
	
	public int OrderNOPuls(Integer groupNo,Integer oerderNo) {
		Map<String, Integer> map= new HashMap<>();
		map.put("orderNo", oerderNo);
		map.put("groupNo",groupNo);

		return sqlsession.update("board.orderNo",map);
	}
	
}

