package teammpro;

public class MemberVO {
	private String user_id;
	private String user_pw;
	private String nickname;
	private int point;
	public MemberVO(String user_id, String user_pw, String nickname, int point) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.nickname = nickname;
		this.point = point;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public String getNickname() {
		return nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
