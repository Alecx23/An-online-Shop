package Clase;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Preferate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	@ManyToOne
	@JoinColumn(name = "utilizator_id")
	private Utilizator utilizator;
	
	@OneToMany
	private Set<Produs> pref = new HashSet<>();
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Utilizator getUtilizator() {
		return utilizator;
	}


	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}


	public Set<Produs> getPref() {
		return pref;
	}


	public void setPref(Set<Produs> pref) {
		this.pref = pref;
	}


	
	
	
	
	
	
	/*public void Prefer(Produs p) {
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
	}*/
}
