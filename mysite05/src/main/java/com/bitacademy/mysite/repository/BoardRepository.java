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

	public List<BoardVo> findAllByPageAndKeword(String keyword, Integer page, Integer size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("startIndex", (page - 1) * size);
		map.put("size", size);

		return sqlSession.selectList("board.findAllByPageAndKeword", map);
	}
	public int getTotalCount(String keyword) {
		return sqlSession.selectOne("board.totalCount", keyword);
	}
}