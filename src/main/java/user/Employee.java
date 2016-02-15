package user;

public class Employee {

	private String employeeId;
	private String employeeName;
	private int token;
		
	
	public Employee(String employeeId, String employeeName, int token) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.token = token;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	

	
}
