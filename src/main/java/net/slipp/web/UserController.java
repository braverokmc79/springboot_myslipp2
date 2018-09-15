package net.slipp.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	//private List<User> users=new ArrayList<User>();
	
	@Autowired
	private UserRepository UserRepository;
	
	@PostMapping("/create")
	public String create(User user) {
		log.info("userId : " +user.toString());
		//users.add(user);
		UserRepository.save(user);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("users", UserRepository.findAll());
		return "list";
	}

	
	
}
