package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Utilizator;
import Repositories.UtilizatorRepository;

@Service
public class UtilizatorService {

	@Autowired
	private UtilizatorRepository utilizatorRepository;
	
	public List<Utilizator> getAllUtilizatori(){
		List<Utilizator> utilizatori = new ArrayList<>();
		utilizatorRepository.findAll().forEach(utilizatori::add);
		return utilizatori;
	}
	
	public void addUtilizator(Utilizator util) {
		utilizatorRepository.save(util);
	}

	public UtilizatorRepository getUtilizatorRepository() {
		return utilizatorRepository;
	}

	
	
}
