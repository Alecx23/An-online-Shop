package Clase;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Preferate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	@OneToOne
	@JoinColumn(name = "utilizator_id", referencedColumnName = "utilizator_id")
	private Utilizator utilizator;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Produs> produse = new HashSet<>();
	
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


	public Set<Produs> getProduse() {
		return produse;
	}


	public void setProduse(Set<Produs> pref) {
		this.produse = pref;
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
