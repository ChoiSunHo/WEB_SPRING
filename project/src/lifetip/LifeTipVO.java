package lifetip;

public class LifeTipVO {

	private Integer no = null;
	private String title = null;
	private String text = null;
	private String theTime = null;
	private String clientIp = null;
	private String userId = null;
	private Integer viewNo = null;
	private Integer likeNo = null;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTheTime() {
		return theTime;
	}
	public void setTheTime(String theTime) {
		this.theTime = theTime;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getViewNo() {
		return viewNo;
	}
	public void setViewNo(Integer viewNo) {
		this.viewNo = viewNo;
	}
	public Integer getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(Integer likeNo) {
		this.likeNo = likeNo;
	}
	@Override
	public String toString() {
		return "MovieVideoVO [no=" + no + ", title=" + title + ", text=" + text
				+ ", theTime=" + theTime + ", clientIp=" + clientIp
				+ ", userId=" + userId + ", viewNo=" + viewNo + ", likeNo="
				+ likeNo + ", getNo()=" + getNo() + ", getTitle()="
				+ getTitle() + ", getText()=" + getText() + ", getTheTime()="
				+ getTheTime() + ", getClientIp()=" + getClientIp()
				+ ", getUserId()=" + getUserId() + ", getViewNo()="
				+ getViewNo() + ", getLikeNo()=" + getLikeNo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	
	


}
