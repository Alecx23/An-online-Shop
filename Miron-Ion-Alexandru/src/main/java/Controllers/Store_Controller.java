package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Clase.Produs;
import Clase.Utilizator;
import Services.ProductServices;
import Services.UtilizatorService;


@Controller
public class Store_Controller {

	boolean q = false;
	
	@Autowired
	ProductServices productServices;
	
	@Autowired
	UtilizatorService utilizatorService;
	
	//HomePage of the site:0
	@GetMapping("/")
	public String home(Model model) {
		if(q==false) {
			productServices.addProduct(new Produs("Ciocolata",15,16,"/ciocolata.avif"));
			productServices.addProduct(new Produs("Ciocolata Neagra",15,3,"/Ciocolata-neagra.jpg"));
			utilizatorService.addUtilizator(new Utilizator("admin","admin"));
			utilizatorService.addUtilizator(new Utilizator("user","user"));
			logIn_SigIn_Controller.account.setId(utilizatorService.getUtilizatorRepository().findByNume("user").getId());
			q=true;
		}
		model.addAttribute("Produse", productServices.getAllProducts());
		model.addAttribute("user",logIn_SigIn_Controller.account);
		
		return "index";
	}
	
}
