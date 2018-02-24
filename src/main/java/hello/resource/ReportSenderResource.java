package hello.resource;

import org.springframework.web.bind.annotation.RestController;

import hello.model.LoanRequest;
import hello.restClient.LoanApp1Client;
import hello.user.ChgPwdRequest;
import hello.user.ChgPwdResult;
import hello.user.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.activation.FileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/")
public class ReportSenderResource {
	
	Logger log = LoggerFactory.getLogger(ReportSenderResource.class);
	
	
	@RequestMapping(value="/getReport", method=RequestMethod.GET)
	public ResponseEntity<byte[]> what() throws IOException{
	    File file = new File("src/main/resources/ADM_Techniques.xls");
	    return ResponseEntity.ok()
	            .header("Content-Disposition", "attachment; filename=" +file.getName())
	            .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
	            .body(Files.readAllBytes(file.toPath()));
	}


}
