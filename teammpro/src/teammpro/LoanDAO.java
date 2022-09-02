package teammpro;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberVO mv = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_h_0830_3";
			String db_pw = "smhrd3";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (Exception e) { // ClassNotFoundException + SQLException
			System.out.println("conn 생성 오류발생");
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

	public int Loancheck(int point, int count,String user_id) {
		getCon();
		int cnt = 0;

		String sql = "insert into Loan values(?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,mv.getUser_id());
			psmt.setInt(2,point);
			psmt.setInt(3,count);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println();
		} finally {
			close();
		}
		return cnt;

	}

	public void Loanplus(int loanpoint) {
		getCon();

		String sql = "update loan set point =? where user_id = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, loanpoint);
			psmt.setNString(2, mv.getUser_id());

			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println();
		}
		mv.setPoint(loanpoint);

	}

	public void Loanback(int point, int loanpoint) {
		getCon();

		String sql = "update loan set point =? where user_id = ?";

		try {

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1,loanpoint);
			psmt.setNString(2, mv.getUser_id());

			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println();
		}
		mv.setPoint(point - loanpoint);

	}

}