package net.slipp;

import java.sql.SQLException;

import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
		
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
	    registrationBean.addUrlMappings("/console/*");
	    return registrationBean;
	  }

	
    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsoleServer () throws SQLException {
    	Server webServer = Server.createWebServer("-webAllowOthers","-webPort","5050"); // (4a)     
        return webServer;
    }
    
    

}
