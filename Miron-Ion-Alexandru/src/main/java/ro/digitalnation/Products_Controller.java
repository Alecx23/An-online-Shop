package ro.digitalnation;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Clase.Logica;
import Clase.Produs;
import Clase.Utilizator;
import Services.ProductServices;
import Services.UtilizatorService;

@Controller
public class Products_Controller {

	@Autowired
	ProductServices productServices;
	
	@Autowired
	UtilizatorService utilizatorService;
	
	private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir")+"//src//main//resources//static//uploads";
	
	@GetMapping("/product/{id}")
	public String productDetails(@PathVariable Long id, Model model) {
		if(id==null) {
			System.out.println("id-ul este null");
			return "redirect:/";
		}
		Produs product = productServices.getProductRepository().findById(id).orElse(null);
		System.out.println(product.toString());
		
		//if(product==null) {
			//return "redirect:/";
		//}
		/*System.out.println(logIn_SigIn_Controller.account.toString());
		Utilizator currentUser = utilizatorService.getUtilizatorRepository()
	            .findById(logIn_SigIn_Controller.account.getId())
	            .orElse(null);
		System.out.println(currentUser);
		
		boolean isPreferred = false;
	    if (currentUser != null) {
	        isPreferred = currentUser.getPref().getPref().contains(product);
	    }
	    */
	    model.addAttribute("produs", product);
	    model.addAttribute("isPreferred", true);
	    return "productPage";
	}
	
	@GetMapping("/addProduct")
	public String displayAddProductForm(Model model) {
		model.addAttribute("produs", new Produs());
		return "addProduct";
	}
	
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute Produs produs, @RequestParam("image") MultipartFile file, Model model)
	throws IOException{
		 Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
		    if (!Files.exists(uploadPath)) {
		        Files.createDirectories(uploadPath);
		    }

		    
		    String fileName = file.getOriginalFilename();
		    Path fileNameAndPath = uploadPath.resolve(fileName);
		    file.transferTo(fileNameAndPath.toFile()); 

		   
		    produs.setImg(fileNameAndPath.toString()); 
		    
		    
		    productServices.addProduct(produs);

		    
		    model.addAttribute("produs", produs);

		    
		    return "redirect:/";
	}
}
