package Clase;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Preferate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	//@OneToOne
	//@JoinColumn(name = "utilizator_id", referencedColumnName = "utilizator_id")
	//private Utilizator utilizator;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Produs> produse = new HashSet<>();
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	/*public Utilizator getUtilizator() {
		return utilizator;
	}


	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}*/


	public Set<Produs> getProduse() {
		return produse;
	}


	public void setProduse(Set<Produs> pref) {
		this.produse = pref;
	}
}
