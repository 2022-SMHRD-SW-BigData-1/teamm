package teammpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import Model.MemberVO;

	public class DAO {
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
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
				String sql = "insert into memberInfo values(?, ?, ?)";

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
		public int login(String id, String pw) {
			try {
				getCon();
				String sql = "select * from memberInfo where id = ? and pw = ?";

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);

				rs = psmt.executeQuery();
				
				if (rs.next()) {
					if (rs.getString(1).contentEquals(id) && rs.getString(2).contentEquals(pw)) {
						return 1; // 로그인 성공
					} else {
						return 0; // 비밀번호 불일치
					}
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return -1;
		}
		
}
