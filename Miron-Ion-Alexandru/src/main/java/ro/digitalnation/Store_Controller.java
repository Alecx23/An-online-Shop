package ro.digitalnation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Clase.Produs;
import Services.ProductServices;


@Controller
public class Store_Controller {

	boolean q = false;
	
	@Autowired
	ProductServices productServices;
	
	
	//HomePage :0
	@GetMapping("/")
	public String home(Model model) {
		if(q==false) {
			productServices.addProduct(new Produs("Ciocolata",15,16,"/ciocolata.avif"));
			productServices.addProduct(new Produs("Ciocolata Neagra",15,10,"/Ciocolata-neagra.jpg"));
			q=true;
		}
		model.addAttribute("Produse", productServices.getAllProducts());
		model.addAttribute("user",logIn_SigIn_Controller.account);
		
		return "index";
	}
	
	@GetMapping("/logOut")
	public String logOut() {
		logIn_SigIn_Controller.account.setParola("user");
		logIn_SigIn_Controller.account.setNume("user");
		logIn_SigIn_Controller.account.setId(null);
		return "redirect:/";
	}
	
}
