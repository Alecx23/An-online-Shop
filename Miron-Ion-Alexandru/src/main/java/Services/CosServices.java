package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clase.Cos;
import Repositories.CosRepository;

@Service
public class CosServices {

	@Autowired
	private CosRepository cosRepository;
	
	public void addCos(Cos cos) {
		cosRepository.save(cos);
	}
	
	public void removeCos(Cos cos) {
		cosRepository.delete(cos);
	}
	
	public CosRepository getCosRepository(){
		return cosRepository;
	}
}
