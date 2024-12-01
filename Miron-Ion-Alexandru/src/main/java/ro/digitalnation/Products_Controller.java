package ro.digitalnation;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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

@Controller
public class Products_Controller {

	private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir")+"//src//main//resources//static//uploads";
	
	@GetMapping("/product/{id}")
	public String productDetails(@PathVariable String id, Model model) {
		Produs prod=null;
		for(Produs p : Logica.getProduse()) {
			if(p.getId().equals(id)) {
				prod=p;
				break;
			}
				
		}
		if(prod!=null) {
			model.addAttribute("produs", prod);
			return "productPage";
		}else
			return "redirect:/";
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
		    
		    
		    Logica.getProduse().add(produs);

		    
		    model.addAttribute("produs", produs);

		    
		    return "redirect:/";
	}
}
