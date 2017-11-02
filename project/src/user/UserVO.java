package user;

public class UserVO {

	private String userId = null;
	private String passwd = null;
	private Integer point = null;
	private String userName = null;
	private Integer power = null;
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", passwd=" + passwd + ", point="
				+ point + ", userName=" + userName + ", photo="+
				", power=" + power + "]";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
}
/*
CREATE TABLE UserTb(
	user_id VARCHAR2(16) ,
	passwd VARCHAR2(16) , 
	point NUMBER(8) ,
	user_name VARCHAR2(16) , 
	power NUMBER(2)
);
*/