package com.smartcontactmnager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@RequestMapping(value="/index")
	public String userIndex() {
		
		return "index";
		
		
	}

}
