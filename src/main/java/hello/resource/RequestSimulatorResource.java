package hello.resource;

import org.springframework.web.bind.annotation.RestController;

import hello.model.LoanRequest;
import hello.restClient.LoanApp1Client;
import hello.user.ChgPwdRequest;
import hello.user.ChgPwdResult;
import hello.user.Employee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/simulate")
public class RequestSimulatorResource {
	
	Logger log = LoggerFactory.getLogger(RequestSimulatorResource.class);
	
	private LoanApp1Client app1Client;

	@Autowired
	public RequestSimulatorResource(LoanApp1Client app1Client) {
		this.app1Client = app1Client;
	}
		
	@RequestMapping(value="/request/{count}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Object simulateRequest(@PathVariable int count) {
		log.info("# of Requests to simulate: {}", count);
		int baseLoanNo = 1000;
		for (int i=0; i < count; i++)
		{
			LoanRequest loanReq = new LoanRequest();
			loanReq.setLoanId(String.valueOf(baseLoanNo+i));
			loanReq.setLoanUpb(new Double(100000));
			loanReq.setSsNumber("121898");
			try {
				app1Client.execute(loanReq);
			}
			catch(Exception ex) {
				log.info("Oops.. got an exception {}", ex.getMessage());
			}
		}
		return "{Success: "+count+"}";
    }


}
