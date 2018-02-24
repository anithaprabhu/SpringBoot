package hello.resource;

import org.springframework.web.bind.annotation.RestController;

import hello.model.LoanRequest;
import hello.restClient.TOSApp1Client;



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
public class ReportRequestorSimulator {
	
	Logger log = LoggerFactory.getLogger(ReportRequestorSimulator.class);
	
	private TOSApp1Client tosClient;

	@Autowired
	public ReportRequestorSimulator(TOSApp1Client tosClient) {
		this.tosClient = tosClient;
	}
		
	@RequestMapping(value="/downloadReport", produces=MediaType.APPLICATION_JSON_VALUE)
    public Object simulateRequest(Object request) {
		log.info("Inside Request");
		try {
				tosClient.execute(request);
			}
			catch(Exception ex) {
				log.info("Oops.. got an exception {}", ex.getMessage());
			}
		return "{Success: true}";
    }


}
