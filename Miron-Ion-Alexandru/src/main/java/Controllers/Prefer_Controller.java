package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Clase.Preferate;
import Clase.Produs;
import Clase.Utilizator;
import Services.PreferateServices;
import Services.ProductServices;
import Services.UtilizatorService;

@Controller
public class Prefer_Controller {

	@Autowired
    private PreferateServices preferateServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private UtilizatorService userServices;
    
    //it puts the product in the user favorite list, if they don't have it already
    @PostMapping("/preferate/add")
    public String addToPreferate(@RequestParam Long productId) {
    	Produs product = productServices.getProductRepository().findById(productId).orElse(null);
    	
    	if(product==null) {
    		return "redirect:/";
    	}
    	
    	Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
    	
    	if(currentUser==null) {
    		return "redirect:/";
    	}
    	
    	
    	Preferate userFavorite = currentUser.getPref();
    	
    	if(!userFavorite.getProduse().contains(product)) {
    		userFavorite.getProduse().add(product);
    		preferateServices.addPreferate(userFavorite);
    	}
    	
    	return "redirect:/product/" +productId.toString();
    }
    
    // it removes the product from the user favorite list
    @PostMapping("/preferate/remove")
    public String removeToPreferate(@RequestParam Long productId) {
    	Produs product = productServices.getProductRepository().findById(productId).orElse(null);
    	if(product==null) {
    		return "redirect:/";
    	}
    	//System.out.println(product.toString());
    	Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
    	
    	if(currentUser==null) {
    		return "redirect:/";
    	}
    	
    	
    	Preferate userFavorite = currentUser.getPref();
    	
    	
    	if(userFavorite.getProduse().contains(product)) {
    		userFavorite.getProduse().remove(product);
    		preferateServices.addPreferate(userFavorite);
    	}
    	//System.out.println(product.getId().toString());
    	return "redirect:/product/" +productId.toString();
    }
    
    //it gets all the user favorite and shows it
    @GetMapping("/preferate")
    public String preferate(Model model) {
    	
    	Utilizator currentUser = userServices.getUtilizatorRepository().findById(logIn_SigIn_Controller.account.getId()).orElse(null);
    	Preferate userFavorite = currentUser.getPref();
    	model.addAttribute("Preferate",userFavorite.getProduse());
    	return "preferatePage";
    }
}
