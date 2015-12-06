package com.hrustalyov.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String showAdminHomePage() {
        return "admin.home";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin.login";
	}
}
