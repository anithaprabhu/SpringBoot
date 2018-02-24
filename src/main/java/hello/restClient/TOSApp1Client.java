package hello.restClient;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.io.IOUtils;


@Component
public class TOSApp1Client {

	Logger log = LoggerFactory.getLogger(TOSApp1Client.class);
	
	private RestTemplate myRestTemplate;

	@Autowired
	public TOSApp1Client(RestTemplate myRestTemplate) {
		this.myRestTemplate = myRestTemplate;
	}
	
	public void execute(Object request) throws Exception {
		log.info("Inside execute ");	
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/getReport");
		URI uri = uriBuilder.build().toUri();
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<byte[]> respEntity = myRestTemplate.getForEntity(uri, byte[].class);
		if(respEntity.getStatusCode().equals(HttpStatus.OK))
        {       
                String fileName = respEntity.getHeaders().getFirst("FileName");
				FileOutputStream output = new FileOutputStream(new File("logs/"+fileName));
                IOUtils.write(respEntity.getBody(), output);
                log.info("Obtained File"+fileName);
        }
		
	}
	
	
	
	
}
