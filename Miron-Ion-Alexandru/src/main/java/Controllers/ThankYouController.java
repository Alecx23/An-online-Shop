package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Clase.Form;

@Controller
public class ThankYouController {

	
	//creates a form where u have to put a secret password
	@GetMapping("/Why_u_here")
	public String whyUHere(Model model) {
		model.addAttribute("form", new Form());
		return "ThankYouForm";
	}
	
	//takes the data from the form and verifies if the password is correct
	@PostMapping("/Why_u_here")
	public String uStillHere(@ModelAttribute Form form,RedirectAttributes redirectAttributes) {
		if(form.getParola().equals("Va_multumesc"))
			return "ThankYou";
		else {
			redirectAttributes.addFlashAttribute("gresit", true);
			return "redirect:/Why_u_here";
		}
			
	}
}
