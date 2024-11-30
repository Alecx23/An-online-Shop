package ro.digitalnation;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Clase.Produs;

@Controller
public class Store_Controller {

	//HomePage :0
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Produse", Arrays.asList(
				new Produs("Apa carpatica",100,3,"5033"),
				new Produs("ciocolata",50,2,"1001"),
				new Produs("hamburger",100,2,"1002")
		));
		return "index";
	}
	
}
