package com.bitacademy.mysite.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.BoardVo;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSession sqlsession;

	public List<BoardVo> findAll() {
		return sqlsession.selectList("board.findAll");

	}
	public Boolean insert(BoardVo vo) {
		int count= sqlsession.insert("board.insert",vo);
		
		return count==1;
	}
	
	public Boolean delete(Long no) {
		int count= sqlsession.delete("board.delete",no);
		return count==1;
	}
	public boolean update(BoardVo vo) {
		int count = sqlsession.update("board.update",vo);
		return count==1;
	}

	public BoardVo view(Long no) {
		return sqlsession.selectOne("board.view", no);
	}
	public BoardVo findByNo(Long no) {
		return sqlsession.selectOne("board.view", no);
	}
}

