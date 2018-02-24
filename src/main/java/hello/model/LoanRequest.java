package hello.model;

public class LoanRequest {

	private String loanId;
	private String ssNumber;
	private Double loanUpb;
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getSsNumber() {
		return ssNumber;
	}
	public void setSsNumber(String ssNumber) {
		this.ssNumber = ssNumber;
	}
	public Double getLoanUpb() {
		return loanUpb;
	}
	public void setLoanUpb(Double loanUpb) {
		this.loanUpb = loanUpb;
	}
	
	
}
