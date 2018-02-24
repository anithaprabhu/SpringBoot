package hello;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages={"common", "hello"})
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
    
    @Bean
    public RestTemplate myRestTemplate() throws Exception {
    	RestTemplate restTemplate = new RestTemplate();
    	ArrayList defaultConverters = new ArrayList();
    	defaultConverters.add(new MappingJackson2HttpMessageConverter());
    	defaultConverters.add(new ByteArrayHttpMessageConverter());
    	defaultConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    	restTemplate.setMessageConverters(defaultConverters);
    	return restTemplate;
    	
    }


}