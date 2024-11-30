package ro.digitalnation;

import org.springframework.stereotype.Controller;
import java.util.HashMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Clase.Logica;
import Clase.Utilizator;

@Controller
public class logIn_SigIn_Controller {

	private HashMap<String, Utilizator> listaPersoane = new HashMap<>();
	protected static Utilizator account;
	
	@GetMapping("/login")
	public String LogInForm(Model model) {
		model.addAttribute("utilizator", new Utilizator("",""));
		return "Login_Page";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Utilizator utilizator, Model model) {
		String username = utilizator.getNume();
		String password = utilizator.getParola();
		
		if("admin".equals(username) && "admin".equals(password)) {
			account = new Utilizator("admin","admin");
			return "index";
		}
			
		
		else if(listaPersoane.containsKey(username)&&listaPersoane.get(username).getParola().equals(password)) {
			account=new Utilizator(username, password);
			return "index";
		}
		
		else {
			model.addAttribute("invalidCredentials", true);
			return "Login_Page";
		}
			
	}
	
	@GetMapping("/signIn")
	public String signInForm(Model model) {
		model.addAttribute("utilizator", new Utilizator("",""));
		return "signIn";
	}
	
	@PostMapping("/signIn")
	public String signIn(@ModelAttribute Utilizator utilizator, Model model) {
		if(listaPersoane.containsKey(utilizator.getNume())) {
			model.addAttribute("invalidUsername", true);
			return "signIn";
		}
		if(Logica.verifyPass(utilizator.getParola())==false) {
			model.addAttribute("invalidPassword", true);
			return "signIn";
		}
		System.out.println(utilizator);
		listaPersoane.put(utilizator.getNume(), utilizator);
		return "redirect:login";
	}
}
