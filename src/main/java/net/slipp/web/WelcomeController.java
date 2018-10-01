package net.slipp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
	int netSalesReportListSize ;
	
	@RequestMapping("/")
	public String index(){
		log.info("root  index" );
		return "index";
	}
	
	//mustache
	@GetMapping(value="/helloworld/{name}", produces="text/html")
	public String welcome(@PathVariable("name") String name, int age, Model model, HttpSession session, HttpServletRequest request ) {
		request.getServletContext().getRealPath("/");	
		log.info("helloWorld - log");	
		model.addAttribute("name", name);//uri 로 값 가져오기
		model.addAttribute("age", age); // age 로 값 가져오기
		return "welcome";		
	}
	
	
	@RequestMapping("/greet")
	public String greet() {
		return "greet";
	}
	

	@RequestMapping("/helloworld2")
	public String welcome2() {
		log.info("hellowrold - log2");
		return "안녕 Spring Boot!";
	}



}
