package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import Clase.Logica;
import Clase.Utilizator;
import Services.UtilizatorService;


@Controller
public class logIn_SigIn_Controller {
	
	protected static Utilizator account=new Utilizator("user","user");
	
	
	@Autowired
	UtilizatorService utilizatorService;
	
	// the log in form
	@GetMapping("/login")
	public String LogInForm(Model model) {
		model.addAttribute("utilizator", new Utilizator("",""));
		return "Login_Page";
	}
	
	// the verification of the form
	@PostMapping("/login")
	public String login(@ModelAttribute Utilizator utilizator, Model model) {
		String username = utilizator.getNume();
		String password = utilizator.getParola();
		
		if(utilizatorService.LogIn(username, password)!=null) {
				account= new Utilizator(username,password);
				System.out.println(utilizatorService.getUtilizatorRepository().findByNume(username).getId());
				account.setId(utilizatorService.getUtilizatorRepository().findByNume(username).getId());
				return "redirect:/";
		}
		
		model.addAttribute("invalidCredentials", true);
		return "Login_Page";
			
	}
	
	// the sign in form
	@GetMapping("/signIn")
	public String signInForm(Model model) {
		model.addAttribute("utilizator", new Utilizator("",""));
		return "signIn";
	}
	
	// verification of the sign in form
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute Utilizator utilizator, Model model) {
		
		//Preferate preferate = new Preferate();
		//preferate.setUtilizator(utilizator);
		//utilizator.setPref(preferate);
		
		//Cos cos = new Cos();
		//cos.setUtilizator(utilizator);
		//utilizator.setCos(cos);
		
		//it checks if the user has put a strong password and if the username is original
		if(utilizatorService.verificareNume(utilizator.getNume())!=null&&utilizator.getNume().equals("admin")) {
			model.addAttribute("invalidUsername", true);
			return "signIn";
		}
		
		if(Logica.verifyPass(utilizator.getParola())==false) {
			model.addAttribute("invalidPassword", true);
			return "signIn";
		}
		
		utilizatorService.addUtilizator(utilizator);
		//System.out.println(utilizator);
		return "redirect:login";
	}
	
	//if the user wants to log out of their account
	@GetMapping("/logOut")
	public String logOut() {
		account.setParola("user");
		account.setNume("user");
		account.setId(utilizatorService.getUtilizatorRepository().findByNume("user").getId());
		return "redirect:/";
	}
	
}