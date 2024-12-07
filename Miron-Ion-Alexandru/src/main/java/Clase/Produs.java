package Clase;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produs")
@DynamicInsert
public class Produs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nume;
	private Integer pret;
	private Integer stoc;
	private String desc = "Este un Produs";
	
	private String img;
	
	public Produs() {
		
	}
	
	public Produs(String nume, Integer pret, Integer stoc,String img) {
		super();
		this.nume = nume;
		this.pret = pret;
		this.stoc = stoc;
		this.img=img;
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

	@Override
	public String toString() {
		return "Produs [nume=" + nume + ", pret=" + pret + ", stoc=" + stoc + ", desc=" + desc + ", id=" + id + "]";
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	
	
	
}
