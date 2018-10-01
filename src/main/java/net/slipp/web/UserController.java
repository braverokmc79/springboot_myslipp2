package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.HttpSessionUtils;
import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	//private List<User> users=new ArrayList<User>();
	
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/users/login";
	}

	@PostMapping("/login")
	public String login(String userId, String password, HttpSession session){
		User user =UserRepository.findByUserId(userId);
		if(user==null) {
			log.info("아이디가 없습니다.");
			return "redirect:/users/loginForm";
		}
		
		if(!user.matchPassword(password)) {
			log.info("패스워드 불일치");
			return "redirect:/users/loginForm";
		}
		
		
		log.info("Login Success : " +user.toString());
		session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionedUser");
		return "redirect:/";
	}
	
	
	@GetMapping("/form")
	public String registerForm(){
		log.info("registerForm");
		return "/users/form";
	}
	
	
	@PostMapping("")
	public String create(User user) {
		log.info("userId : " +user.toString());
		//users.add(user);
		UserRepository.save(user);
		return "redirect:/users/";
	}

	@GetMapping("")
	public String list(Model model){
		model.addAttribute("users", UserRepository.findAll());
		return "/users/list";
	}

	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model, HttpSession session){		
		if(HttpSessionUtils.isLoginUser(session)) {
			return "redirect:/users/loginForm";
		}
		
		User sessionedUser =(User)session.getAttribute("sessionedUser");
		
		if(!sessionedUser.matchId(id)) {
			throw new IllegalStateException("자신의 정보만 수정할 수 있습니다.");
		}
				
		User user =UserRepository.findOne(sessionedUser.getId());
		log.debug("updateForm : user -  {} " , user.toString());
		model.addAttribute("user", user);
		return "/users/updateForm";
	}
	
	
	
	
	@PutMapping("/update/{userId}")
	public String update(@PathVariable String userId, User newUser) {
		
		User user=UserRepository.findOne(newUser.getId());
		user.update(newUser);
		UserRepository.save(user);
		return "redirect:/users/";
	}
	
	
}
