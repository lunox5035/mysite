package com.bitacademy.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;


public class BoardDao {
	public Boolean write(BoardVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into borad values (null,?,?,0,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			
			int count = pstmt.executeUpdate();
			
			//5. 결과 처리
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean update(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "update borad "
					+ "set title=?,contents=?"
					+ "where no=no";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());

			int count = pstmt.executeUpdate();

			// 5. 결과 처리
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;		
	}
//	private static void load(Long no) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			
//			// 3. Statement 준비
//			String sql = "select a.title, b.name, a.hit, a.date_format(reg_date,'%Y%m%d %H:%i:%S'), a.depth, a.user_no"
//					+ "from borad a,user "
//					+ "where a.user_no = b.no"
//					+ "and a.no=?";
//			pstmt = conn.prepareStatement(sql);
//
//			ResultSet rsResultSet = pstmt.executeQuery(sql);
//			
//			ArrayList<BoardVo> list = new ArrayList<>();
//			
//			
//			while(rs.next()) {
//				BoardVo vo = new BoardVo();
//				vo.setTitle(rs.getString("title"));
//				vo.setName(rs.getString("name"));//조인한 다음 불러오기
//				vo.setHit(rs.getString("hit"));
//				vo.setRegDate(rs.getString("reg_date"));
//				
//				
//				
//				list.add(vo);
//			}
//		}catch (SQLException e) {
//				System.out.println("Error:" + e);
//			} finally {
//				try {
//					if(pstmt != null) {
//						pstmt.close();
//					}
//					
//					if(conn != null) {
//						conn.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}		
//			
//			
//		}

	
	
	
//=====================================================================	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
}
