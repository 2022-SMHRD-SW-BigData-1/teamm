package teammpro;

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
	DAO dao = new DAO();

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

	// 포인트 빌려줄때 쓰는 메소드
	public void outShare(MemberVO mv, int point, LoanVO lv) {
		getCon();
		String sql = null;
		if (lv == null) {
			sql = "insert into loan values(?,?,?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, mv.getUser_id());
				psmt.setInt(2, point);
				psmt.setInt(3, 1);
				psmt.executeUpdate();
				mv.setPoint(point);
				lv.setPoint(lv.getPoint()+point);
			} catch (SQLException e) {
				System.out.println();
			} finally {
				close();
			}
		} else {
			sql = "update loan set point = ? where user_id = ?";
			try {

				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, lv.getPoint() + point);
				psmt.setNString(2, mv.getUser_id());
				psmt.execute();
				mv.setPoint(point);
				lv.setPoint(lv.getPoint()+point);
			} catch (SQLException e) {
				System.out.println("빌리는거 실패");
			} finally {
				close();
			}
		}

	}

	public LoanVO Loancheck(MemberVO mv, LoanVO lv) {

		getCon();
		String sql = "select * from loan where user_id = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mv.getUser_id());

			rs = psmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("user_id");
				int point = rs.getInt("point");
				lv = new LoanVO(id, point);
			}

		} catch (SQLException e) {
			System.out.println();
		} finally {
			close();
		}
		return lv;
	}

	// 포인트 돌려받을때 쓰는 메소드
	public void getShare(MemberVO mv, int point, LoanVO lv) {
		if (lv == null || lv.getPoint() == 0) {
			System.out.println("\n\t\t\t\t갚을 포인트가 없습니다.\n\n");
		} else {
			getCon();
			String sql = "update loan set point =? where user_id = ?";
			try {
				
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, lv.getPoint() - point);
				psmt.setString(2, mv.getUser_id());
				psmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("체납 실패");
			} finally {
				close();
			}
			lv.setPoint(lv.getPoint()-point);
			mv.setPoint(mv.getPoint() - point);
			dao.minus_point(mv, mv.getPoint());
		}
	}
}