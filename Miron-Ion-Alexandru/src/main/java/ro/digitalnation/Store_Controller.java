package ro.digitalnation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import Services.ProductServices;


@Controller
public class Store_Controller {

	@Autowired
	ProductServices productServices;
	//HomePage :0
	@GetMapping("/")
	public String home(Model model) {
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
