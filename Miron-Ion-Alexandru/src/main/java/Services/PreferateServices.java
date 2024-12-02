package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Preferate;
import Clase.Produs;
import Clase.Utilizator;
import Repositories.PreferateRepository;

@Service
public class PreferateServices {

	@Autowired
	private PreferateRepository preferateRepository;
	
	public List<Preferate> getAllPreferate(){
		List<Preferate> preferate = new ArrayList<>();
		preferateRepository.findAll().forEach(preferate::add);
		return preferate;
	}
	
	public void addPreferate(Preferate pref) {
		preferateRepository.save(pref);
	}

	public PreferateRepository getPreferateRepository() {
		return preferateRepository;
	}
}
