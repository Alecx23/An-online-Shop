package Clase;

public class Produs {

	private String nume;
	private Integer pret;
	private Integer stoc;
	private String desc = "Este un Produs";
	private String id;
	
	public Produs(String nume, Integer pret, Integer stoc,String id) {
		super();
		this.nume = nume;
		this.pret = pret;
		this.stoc = stoc;
		this.id = id;
	}
	

	public String getNume() {
		return nume;
	}
	

	public void setNume(String nume) {
		this.nume = nume;
	}
	

	public Integer getPret() {
		return pret;
	}
	

	public void setPret(Integer pret) {
		this.pret = pret;
	}
	

	public Integer getStoc() {
		return stoc;
	}
	

	public void setStoc(Integer stoc) {
		this.stoc = stoc;
	}
	

	public String getDesc() {
		return desc;
	}
	

	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Produs [nume=" + nume + ", pret=" + pret + ", stoc=" + stoc + ", desc=" + desc + ", id=" + id + "]";
	}
	
	
	
}
