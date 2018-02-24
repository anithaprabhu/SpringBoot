package hello.restClient;

import java.net.URI;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class LoanApp1Client {

	Logger log = LoggerFactory.getLogger(LoanApp1Client.class);
	
	private RestTemplate myRestTemplate;

	@Autowired
	public LoanApp1Client(RestTemplate myRestTemplate) {
		this.myRestTemplate = myRestTemplate;
	}
	
	public Object execute(Object request) {
		log.info("Inside execute ");		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8001/loan/loan-req");
		URI uri = uriBuilder.build().toUri();
		HttpHeaders headers = new HttpHeaders();
		//headers.set("test", "test-value");
		ResponseEntity<Object> respEntity = myRestTemplate.
				exchange(uri, HttpMethod.POST, new HttpEntity<>(request, headers), 
						Object.class);
		Object response = respEntity.getBody();
		log.info("Completed processing ");
		return response;
	}
	
	
}
