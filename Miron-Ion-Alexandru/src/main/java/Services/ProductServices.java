package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Produs;
import Repositories.ProductRepository;


@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Produs> getAllProducts(){
		List<Produs> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	
	public void addProduct(Produs produs) {
		productRepository.save(produs);
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}
}
