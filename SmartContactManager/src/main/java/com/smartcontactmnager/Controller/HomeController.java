package com.smartcontactmnager.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontactmnager.Dao.UserRepository;
import com.smartcontactmnager.Entities.User;
import com.smartcontactmnager.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		
		return "home";
		
	}

	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about() {
		
		return "about";
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "signup";
		
	}
	
	@RequestMapping(value="/do_register", method=RequestMethod.POST)
	public String registerUser(@Valid@ModelAttribute("user")User user,BindingResult result1,@RequestParam(value="agreement",defaultValue="false")boolean agreement,Model model, HttpSession session) {
		try {
			
			if(result1.hasErrors()) {
				model.addAttribute("user", user);
				System.out.println(result1.toString());
				return "signup";
			}
			user.setRole("Role_User");
			User result= userrepository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Registered Successfully","alert-success"));
			System.out.println(result.toString());
			System.out.println(user.toString());
			return "signup";
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong "+ e.getMessage(),"alert-danger"));
			return "signup";
		}
		
		
	}
}
