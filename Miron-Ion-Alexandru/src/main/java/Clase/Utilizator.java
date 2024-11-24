package Clase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Utilizator {
	private String nume;
	private String prenume;
	private Integer nrTel;
	private String email;
	private Integer varsta;
	private Map<Produs, Integer> istCom = new HashMap<>();
	private Set<Produs> pref = new HashSet<>();
	private Map<Produs, Integer> cos = new HashMap<>();
	
	public Utilizator(String nume, String prenume, Integer nrTel, String email, Integer varsta) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.nrTel = nrTel;
		this.email = email;
		this.varsta = varsta;
	}
	

	public String getNume() {
		return nume;
	}
	

	public void setNume(String nume) {
		this.nume = nume;
	}
	

	public String getPrenume() {
		return prenume;
	}
	

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	

	public Integer getNrTel() {
		return nrTel;
	}
	

	public void setNrTel(Integer nrTel) {
		this.nrTel = nrTel;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Integer getVarsta() {
		return varsta;
	}
	

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}
	
	
	
	public void punInCos(Produs p) {
		if(cos.containsKey(p)) {
			cos.replace(p, cos.get(p)+1);
		}else
			cos.put(p, 1);
	}
	
	public void Prefer(Produs p) {
		pref.add(p);
	}
	
	public void ArataIstCom() {
		if(istCom.isEmpty()) {
			System.out.println("Nu ai niciun istoric ");
		}
		else {
			System.out.println("Istoricul Comenzilor: ");
			for(Produs p : istCom.keySet()) {
				System.out.println(p.getNume()+" x " + istCom.get(p) + " = "+ (p.getPret()*istCom.get(p)));
			}
		}
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


	public Map<Produs, Integer> getCos() {
		return cos;
	}


	public void setCos(Map<Produs, Integer> cos) {
		this.cos = cos;
	}


	public Map<Produs, Integer> getIstCom() {
		return istCom;
	}


	public void setIstCom(Map<Produs, Integer> istCom) {
		this.istCom = istCom;
	}


	@Override
	public String toString() {
		return "Utilizator [nume=" + nume + ", prenume=" + prenume + ", nrTel=" + nrTel + ", email=" + email
				+ ", varsta=" + varsta + "]";
	}
	
	
	//de regandit sa il fac ca la exercitiul 3! (din cauza variabilei stoc)
}
