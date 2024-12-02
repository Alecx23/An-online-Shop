package ro.digitalnation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    	
    	if(userFavorite.getPref().isEmpty()) {
    		userFavorite.getPref().add(product);
    		preferateServices.addPreferate(userFavorite);
    	}
    	
    	if(!userFavorite.getPref().contains(product)) {
    		userFavorite.getPref().add(product);
    		preferateServices.addPreferate(userFavorite);
    	}
    	
    	return "redirect:/product/" +productId.toString();
    }
}
