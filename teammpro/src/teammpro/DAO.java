package teammpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


	public class DAO {
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO mv=null;
		
		public void getCon() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_h_0830_3";
				String db_pw = "smhrd3";

				conn = DriverManager.getConnection(url, db_id, db_pw);

				if (conn != null) {
					System.out.println("접속 성공");
				} else {
					System.out.println("접속 실패");
				}
			} catch (Exception e) { // ClassNotFoundException + SQLException
				System.out.println("오류발생");
			}
		}

		private void close() {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("자원반납 시 오류");
			}
		}

		// [1]회원가입
		public int join(String id, String pw, String nick) {
			int cnt = 0;
			try {
				getCon();
				String sql = "insert into join_users values(?, ?, ?, 100)";

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, nick);

				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return cnt;
		}

		// [2]로그인
		public MemberVO login(String id, String pw) {
			try {
				getCon();
				String sql = "select * from join_users where user_id = ? and user_password = ?";

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);

				rs = psmt.executeQuery();
				
				if (rs.next()) {
					if (rs.getString(1).contentEquals(id) && rs.getString(2).contentEquals(pw)) {
						mv= new MemberVO(id, pw, rs.getString("nickname"), rs.getInt("point"));
						System.out.println("로그인 성공");
						return mv; // 로그인 성공
					} else {
						System.out.println("로그인 실패");
						return mv; // 비밀번호 불일치
					}
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return mv;
		}
		public MemberVO minus_point(MemberVO mv,int point) {
			getCon();
			String sql = "update join_users set point =? where id = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, point);
				psmt.setNString(2, mv.getUser_id());
				psmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL 오류");
			}
			mv.setPoint(point);
			return mv;
		}
		
}
