/*package Clase;

import java.util.HashMap;
import java.util.Random;

public class Comanda {

	private Integer id;
	private Integer pretT;
	private HashMap<Produs, Integer> comanda = new HashMap<>();
	
	public void comand(Utilizator e) {
		 if(e.getCos().getCos().isEmpty()) {
			 System.out.println("Nu ai niciun produs in cos");
		 }
		 else {
			 comanda=e.getCos().getCos();
			 id = new Random().nextInt(1000);
			 for(Produs p : comanda.keySet()) {
				 pretT = p.getPret()*comanda.get(p);
			 }
			 e.getCos().getCos().clear();
		 }
	}
	
	public String arataComanda() {
		if(comanda.isEmpty())
			return null;
		else {
			String n = null;
			for(Produs p : comanda.keySet()) {
				n=n.concat(p.getNume()+" X "+p.getPret()+"\n");
			}
			return n;
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPretT() {
		return pretT;
	}

	public void setPretT(Integer pretT) {
		this.pretT = pretT;
	}

	public HashMap<Produs, Integer> getComanda() {
		return comanda;
	}

	public void setComanda(HashMap<Produs, Integer> comanda) {
		this.comanda = comanda;
	}
	
	
}*/
