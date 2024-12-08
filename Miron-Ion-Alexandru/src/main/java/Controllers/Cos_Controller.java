package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Clase.Cos;
import Clase.Produs;
import Clase.Utilizator;
import Services.CosServices;
import Services.ProductServices;
import Services.UtilizatorService;

@Controller
public class Cos_Controller {

	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private UtilizatorService userServices;
	
	@Autowired
	private CosServices cosServices;
	
	@PostMapping("/addCos")
	public String addToCos(@RequestParam Long productId) {
		Produs product = productServices.getProductRepository().findById(productId).orElse(null);
		
		Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
		
		Cos userCos = currentUser.getCos();
		
		userCos.addCos(product);
		cosServices.addCos(userCos);
		
		return "redirect:/product/" +productId.toString();
	}
	
	@PostMapping("/removeCos")
	public String removeToCos(@RequestParam Long productId) {
		Produs product = productServices.getProductRepository().findById(productId).orElse(null);
		
		Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
		
		Cos userCos = currentUser.getCos();
		
		userCos.stergereCos(product);
		cosServices.addCos(userCos);
		
		return "redirect:/Cos";
	}
	
	@GetMapping("/Cos")
	public String Cos(Model model) {
		Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
		Cos userCos = currentUser.getCos();
		model.addAttribute("CosId", userCos.getId());
		model.addAttribute("ProduseCos",userCos.getCos());
		return "cosPage";
	}
	
}
