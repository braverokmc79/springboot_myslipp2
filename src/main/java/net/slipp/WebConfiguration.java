package net.slipp;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebConfiguration {
		
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
	    registrationBean.addUrlMappings("/console/*");
	    return registrationBean;
	  }

	
}