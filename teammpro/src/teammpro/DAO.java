package teammpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	Scanner sc = new Scanner(System.in);

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
			System.out.println("\t\t\t\t이미 존재하는 회원입니다.");
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
					mv = new MemberVO(id, pw, rs.getString("nickname"), rs.getInt("point"));
					System.out.println("\n\t\t\t\t\t로그인 성공 ( ͡° ͜ʖ ͡°)\n\n\n\n\n");
					return mv; // 로그인 성공
				} else {
					System.out.println("\n\t\t\t\t\t로그인 실패 (◦ˇ _̆ ˇ◦)\n\n\n\n\n");
					return mv; // 비밀번호 불일치
				}
			}
		} catch (SQLException e) {
			System.out.println("데이터 접속 오류");
		} finally {
			close();
		}
		return mv;
	}

	public MemberVO minus_point(MemberVO mv, int point) {
		getCon();
		String sql = "update join_users set point =? where user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			point = mv.getPoint() + point;
			psmt.setInt(1, point);
			psmt.setNString(2, mv.getUser_id());
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("포인트 업데이트 오류");
		}
		mv.setPoint(point);
		return mv;
	}

	public ArrayList<MemberVO> select(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getCon();
			String sql = "select * from (select*from  join_users  order by point desc) where rownum<=5";
			psmt = conn.prepareStatement(sql);
			System.out.println("                                 "+"\t"+"등수"+"\t"+"닉네임"+"\t"+"포인트");

			rs = psmt.executeQuery();
			int count =1 ;
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nick = rs.getString(3);
				int point = rs.getInt(4);
				System.out.println("                                "+"\t"+count +"등."+"\t"+nick +"\t"+point );
				count++;
			}
			
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return list;
	}
}
