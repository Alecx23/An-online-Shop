package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Comanda;
import Repositories.ComandaRepository;
import jakarta.transaction.Transactional;

@Service
public class ComandaServices {

	@Autowired
	private ComandaRepository comandaRepository;
	
	@Transactional
	public void addComanda(Comanda comanda) {
		comandaRepository.save(comanda);
	}
	
	public void removeComanda(Comanda comanda) {
		comandaRepository.delete(comanda);
	}
	
	
}
