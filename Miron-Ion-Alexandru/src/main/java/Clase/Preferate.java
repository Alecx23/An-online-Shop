package Clase;

import java.util.HashSet;
import java.util.Set;

public class Preferate {

	private Set<Produs> pref = new HashSet<>();
	
	public void Prefer(Produs p) {
		pref.add(p);
	}
	
	public void getPreferate() {
		if(pref.isEmpty()){
			System.out.println("Nu ai nimic la preferate");
		}else {
			System.out.println("Preferatele tale: ");
			for(Produs p : pref)
				System.out.println(p.getNume());
		}
	}
	
	public void stergerePref(Produs p) {
		boolean q = false;
		try {
			if(pref.contains(p)) {
				pref.remove(p);
				q=true;
			}
			if(q==false)
				System.out.println("Acest produs nu este la favorizate");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Nu ati pus nimic in preferate");
		}
	}
}
