package hello.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChgPwdRequest {
	
	private String uId;
	private String oldPwd;
	private String newPwd;
	
	@JsonProperty("empId")
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public ChgPwdRequest(String uId, String oldPwd, String newPwd) {
		super();
		this.uId = uId;
		this.oldPwd = oldPwd;
		this.newPwd = newPwd;
	}
	
	public ChgPwdRequest() {
		super();
	}
	
	
	
}
