package user;

public class ChgPwdResult {

	private String status;
	private Employee emp;
	
	public ChgPwdResult(String status, Employee emp) {
		super();
		this.status = status;
		this.emp = emp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
	
}
