package ro.digitalnation;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Clase.Logica;


@Controller
public class Store_Controller {

	//HomePage :0
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Produse", Logica.getProduse());
		return "index";
	}
	
}
