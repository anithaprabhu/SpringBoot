package user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/login/{uId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Employee login(@PathVariable String uId, @RequestParam String pwd) {
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
        Employee emp = new Employee(request.getuId(), request.getuId()+"Name", newPwd.hashCode());
        ChgPwdResult chgResult = new ChgPwdResult("Success", emp);
		return chgResult;
    }

}
