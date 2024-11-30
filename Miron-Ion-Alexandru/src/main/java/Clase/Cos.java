package Clase;

import java.util.HashMap;

public class Cos {

	private HashMap<Produs, Integer> cos = new HashMap<>();
	
	public void addCos(Produs p) {
		if(cos.isEmpty())
			cos.put(p, 1);
		else if(cos.containsKey(p))
			for(Produs e : cos.keySet()) {
				if(e.getId()==p.getId()) {
					cos.replace(e, cos.get(e)+1);
					break;
				}
			}
		else 
			cos.put(p, 1);
	}
	
	public void ArataCos() {
		if(cos.isEmpty()) {
			System.out.println("Nu ai nimic in cos");
		}else {
			System.out.println("Cosul tau: ");
			for(Produs p : cos.keySet()) {
				System.out.println(p.getNume()+" x " + cos.get(p) + " = "+ (p.getPret()*cos.get(p)));
			}
		}
			
	}
	
	public void stergereCos(Produs p) {
		if(cos.containsKey(p)) {
			if(cos.get(p)>1)
				cos.replace(p, cos.get(p)-1);
			else
				cos.remove(p);
		}
    }

	
	public HashMap<Produs, Integer> getCos() {
		return cos;
	}

	public void setCos(HashMap<Produs, Integer> cos) {
		this.cos = cos;
	}

	
}
