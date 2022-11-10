package com.bitacademy.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitacademy.mysite.vo.UserVo;



public class UserDao {
	public static void main(String[] args) {
		
	}
//=====================================================================================================
	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;
		
		try {
			conn = getConnection();
			//3. Statement 생성
			String sql = "select no,name from user where password=? and email=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);

			rs=pstmt.executeQuery();
			if(rs.next()) {
				Long no= rs.getLong(1);
				String name= rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}

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
	
//=====================================================================================================
//		public UserVo findByNo(String email, String password) {
//			UserVo result = null;
//			
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			
//			ResultSet rs=null;
//			
//			try {
//				conn = getConnection();
//				//3. Statement 생성
//				String sql = "select no from user"
//						+ "where email =? and password=?;";
//				
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, email);
//				pstmt.setString(2, password);
//
//				rs=pstmt.executeQuery();
//				if(rs.next()) {
//					Long no= rs.getLong(1);
//					
//					result = new UserVo();
//					result.setNo(no);
//					}
//
//			} catch (SQLException e) {
//				System.out.println("Error:" + e);
//			} finally {
//				try {
//					if (pstmt != null) {
//						pstmt.close();
//					}
//
//					if (conn != null) {
//						conn.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			return result;
//			
//		}

//=====================================================================================================
		public static boolean update(UserVo vo) {
			boolean result = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
					if(vo.getPassword()!="") {
					//3. Statement 준비
					String sql = "UPDATE user "
							+ "set name = ?, password= ? , gender= ?"
							+ "where no = ?";
					pstmt = conn.prepareStatement(sql);
					
					//4. Binding
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getPassword());
					pstmt.setString(3, vo.getGender());
					
					pstmt.setLong(4, vo.getNo());
				}else {

					//3. Statement 준비
					String sql = "UPDATE user "
							+ "set name = ?, gender= ?"
							+ "where no = ?";
					pstmt = conn.prepareStatement(sql);
					
					//4. Binding
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getGender());
					
					pstmt.setLong(3, vo.getNo());

				}
				//5. SQL 실행
				int count = pstmt.executeUpdate();

				//6. 결과 처리
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

//=====================================================================================================
	public Boolean insert(UserVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			//3. Statement 생성
			String sql = "insert into user values(null,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
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
//=====================================================================================================
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
