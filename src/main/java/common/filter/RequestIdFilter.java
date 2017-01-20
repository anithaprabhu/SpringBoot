package common.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RequestIdFilter implements Filter {

	Logger log = LoggerFactory.getLogger(RequestIdFilter.class);
	
	private static final String REQUEST_ID="request-id";
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest sReq, ServletResponse sRes, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) sReq;
		HttpServletResponse res = (HttpServletResponse) sRes;
		String reqId = req.getHeader(REQUEST_ID);
		boolean newRequestId = false;
		if (StringUtils.isEmpty(reqId)) {
			newRequestId = false;
			reqId = UUID.randomUUID().toString();
		}
		MDC.put(REQUEST_ID, reqId);
		try { 
			log.info("Recieved Request {}: {}",req.getMethod(),req.getServletPath());
			filterChain.doFilter(sReq, sRes);
		}
		finally {
			if(newRequestId){
				res.addHeader(REQUEST_ID, reqId);
			}
			log.info("Completed Request {}: {}",req.getMethod(),req.getServletPath());
			MDC.remove(REQUEST_ID);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
