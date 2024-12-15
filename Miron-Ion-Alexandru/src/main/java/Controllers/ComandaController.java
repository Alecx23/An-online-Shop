package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Clase.Comanda;
import Clase.Cos;
import Clase.Form;
import Clase.Produs;
import Clase.Utilizator;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import Services.ProductServices;
import Services.UtilizatorService;
import jakarta.transaction.Transactional;
import Services.ComandaServices;
import Services.CosServices;

@Controller
public class ComandaController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private UtilizatorService userServices;
	
	@Autowired
	private ComandaServices comandaServices;
	
	@Autowired
	private CosServices cosServices;
	
	//it gets all the items from the user baskets and calculates the total price 
	//then it asks the user if they want to buy the products or modify the order
	@Transactional
	@PostMapping("/Comanda")
	public String addComanda(@RequestParam Long CosId, Model model) {
		Cos userCos = cosServices.getCosRepository().findById(CosId).orElse(null);
		
		Comanda userComanda = new Comanda();
		
		userComanda.setPretT(0);
		userComanda.setComanda(new HashMap<>(userCos.getCos()));
		userComanda.calculeazaPretT();
		
		model.addAttribute("Comanda", userComanda.getComanda());
		model.addAttribute("PretT", userComanda.getPretT());
		
		return "comandPage";
	}
	
	//it shows a form to the user that they have to complete with their address and their phone number
	@GetMapping("/buyComanda")
	public String displayComandaForm(Model model) {
		model.addAttribute("form", new Form());
		return "comandaForm";
	}
	
	//it gets the data from the form and it puts it creates the order for the user
	//then it puts the order in the users list of orders
	@PostMapping("/buyComanda")
	public String buyComanda(@ModelAttribute Form form) {
		
		Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
		Cos userCos = cosServices.getCosRepository().findById(currentUser.getCos().getId()).orElse(null);
		Comanda userComanda = new Comanda();
		
		userComanda.setPretT(0);
		userComanda.setComanda(new HashMap<>(userCos.getCos()));
		userComanda.calculeazaPretT();
		userComanda.setUtilizator(currentUser);
		userComanda.setAddress(form.getAddress());
		userComanda.setNumarDeTf(form.getPhoneNumber());
		
		for(Produs e : userComanda.getComanda().keySet()) {
			Produs produs = productServices.getProductRepository().findById(e.getId()).orElse(null);
			produs.setStoc(produs.getStoc()-userComanda.getComanda().get(e));
			productServices.addProduct(produs);
		}
		
		Cos cos = currentUser.getCos();
		cos.getCos().clear();
		cosServices.addCos(cos);
		currentUser.getComenzi().add(userComanda);
		comandaServices.addComanda(userComanda);
		
		
		return "BoughtProduct";
	}
}
