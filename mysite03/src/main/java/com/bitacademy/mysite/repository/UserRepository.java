package com.bitacademy.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.UserVo;

@Repository 
public class UserRepository {

	@Autowired
	private SqlSession sqlsession;
	
	public boolean update(UserVo vo) {
		int count = sqlsession.update("user.update",vo);

		return count==1;
	}

	public UserVo findByNo(Long no) {
		return sqlsession.selectOne(null);
	}
	
	public UserVo findByEmailAndPassword(String email, String password) {
		Map<String, Object> map =new HashMap<>();
		map.put(email, email);
		map.put(password, password);
		
		return sqlsession.selectOne("User.findByEmailAndPassword",map);		
	}
	
	public Boolean insert(UserVo vo) {
		int count = sqlsession.insert("user.insert",vo);
		
		return count == 1;
	}
}
