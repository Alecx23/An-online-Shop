package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Preferate;
import Repositories.PreferateRepository;

@Service
public class PreferateServices {

	@Autowired
	private PreferateRepository preferateRepository;
	
	
	public void addPreferate(Preferate pref) {
		preferateRepository.save(pref);
	}
	
	public void removePreferate(Preferate pref) {
		preferateRepository.delete(pref);
	}

	public PreferateRepository getPreferateRepository() {
		return preferateRepository;
	}
}
