package Clase;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Utilizator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="utilizator_id")
	private Long id;
	
	private String nume;
	private Integer nrTel;
	private String email;
	private Integer varsta;
	private String parola;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "preferate_id", referencedColumnName = "id")
    private Preferate pref = new Preferate();
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cos_id", referencedColumnName = "id")
	private Cos cos = new Cos();

//	private istComenzi istCom = new istComenzi();
	
	public Utilizator() {
		
	}
	
	public Utilizator(String nume, String parola) {
		this.nume=nume;
		this.parola=parola;
	}
	

	public String getNume() {
		return nume;
	}
	

	public void setNume(String nume) {
		this.nume = nume;
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

	@Override
	public String toString() {
		return "Utilizator [nume=" + nume + ", nrTel=" + nrTel + ", email=" + email
				+ ", varsta=" + varsta + ", parola="+parola+ "]";
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Preferate getPref() {
		return pref;
	}

	public void setPref(Preferate pref) {
		this.pref = pref;
	}

	

	public Cos getCos() {
		return cos;
	}

	public void setCos(Cos cos) {
		this.cos = cos;
	}

	

//	public istComenzi getIstCom() {
//		return istCom;
//	}

//	public void setIstCom(istComenzi istCom) {
//		this.istCom = istCom;
//	}
	
	
}