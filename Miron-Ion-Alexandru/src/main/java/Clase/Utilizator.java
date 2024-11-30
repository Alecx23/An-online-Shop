package Clase;



public class Utilizator {
	
	private String nume;
	private Integer nrTel;
	private String email;
	private Integer varsta;
	private String parola;
	private Cos cos = new Cos();
	private Preferate pref = new Preferate();
	private istComenzi istCom = new istComenzi();
	
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

	public Cos getCos() {
		return cos;
	}

	public void setCos(Cos cos) {
		this.cos = cos;
	}

	public Preferate getPref() {
		return pref;
	}

	public void setPref(Preferate pref) {
		this.pref = pref;
	}

	public istComenzi getIstCom() {
		return istCom;
	}

	public void setIstCom(istComenzi istCom) {
		this.istCom = istCom;
	}
	
	
}
