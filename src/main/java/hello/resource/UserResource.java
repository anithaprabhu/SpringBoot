package hello.resource;

import org.springframework.web.bind.annotation.RestController;

import hello.user.ChgPwdRequest;
import hello.user.ChgPwdResult;
import hello.user.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	Logger log = LoggerFactory.getLogger(UserResource.class);

	@RequestMapping(value="/login/{uId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Employee login(@PathVariable String uId, @RequestParam String pwd) {
		log.info("Login Request. uId:{}", uId);
		Employee emp = new Employee(uId, uId+"Name", pwd.hashCode());
		//emp.setEmployeeId(uId);
		//emp.setEmployeeName(uId+"Name");		
		//emp.setToken(pwd.hashCode());
		return emp;
    }
	
	@RequestMapping(value="/chgpwd", consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
    public ChgPwdResult chgpwd(@RequestBody ChgPwdRequest request) {
        String newPwd = request.getNewPwd();
        log.info("Change Password Request. uId:{}", request.getuId());
        Employee emp = new Employee(request.getuId(), request.getuId()+"Name", newPwd.hashCode());
        ChgPwdResult chgResult = new ChgPwdResult("Success", emp);
		return chgResult;
    }

}
