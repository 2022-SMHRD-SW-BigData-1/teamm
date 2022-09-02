package teammpro;

public class LoanVO {
	private String user_id;
	private int point;
	public LoanVO(String user_id, int point) {
		super();
		this.user_id = user_id;
		this.point = point;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
