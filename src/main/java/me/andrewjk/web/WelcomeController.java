package me.andrewjk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("name", "javajigi");
		model.addAttribute("age", 30);
		model.addAttribute("company", "<b>github</b>");
		return "welcome";
	}
}
