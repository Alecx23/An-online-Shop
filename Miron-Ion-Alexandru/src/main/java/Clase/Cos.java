package Clase;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
			
	@OneToOne
	@JoinColumn(name = "utilizator_id", referencedColumnName="utilizator_id")
	private Utilizator utilizator;
	
	@ElementCollection
    @CollectionTable(name = "cos_produse", joinColumns = @JoinColumn(name = "cos_id"))
    @MapKeyJoinColumn(name = "produs_id")
    @Column(name = "quantity")
	private Map<Produs, Integer> cos = new HashMap<>();
	
	

	
	public Map<Produs, Integer> getCos() {
		return cos;
	}

	public void setCos(HashMap<Produs, Integer> cos) {
		this.cos = cos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilizator getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}
	
	
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
	
	public void stergereCos(Produs p) {
		if(cos.containsKey(p)) {
			if(cos.get(p)>1)
				cos.replace(p, cos.get(p)-1);
			else
				cos.remove(p);
		}
    }
}
