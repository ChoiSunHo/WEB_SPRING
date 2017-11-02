package safetip;

public class ReplySafeTipVO {

	private Integer no = null;
	private Integer reno = null;
	private String userId = null;
	private String reply = null;
	private String clientIp = null;
	private String theTime = null;
	
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getReno() {
		return reno;
	}

	public void setReno(Integer reno) {
		this.reno = reno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getTheTime() {
		return theTime;
	}

	public void setTheTime(String theTime) {
		this.theTime = theTime;
	}

	@Override
	public String toString() {
		return "ReplyVO [no=" + no + ", reno=" + reno + ", userId=" + userId
				+ ", reply=" + reply + ", clientIp=" + clientIp + ", theTime="
				+ theTime + "]";
	}

	
	

	
}

/*
CREATE TABLE ReplyTb(
no NUMBER(6) , 
user_id VARCHAR2(16),
reply VARCHAR2(500) ,
client_ip VARCHAR2(15),
the_time DATE
);
*/