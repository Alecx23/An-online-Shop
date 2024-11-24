package Clase;

import java.util.ArrayList;
import java.util.HashMap;

public class Logica {

	private static HashMap<String,Produs> produse = new HashMap<>();
	private static ArrayList<Utilizator> utilizatori = new ArrayList<>();
	
	public static void adaugareProd(Produs p) {
		produse.put(p.getId(),p);
	}
	
	public static void adaugareUtil(Utilizator u) {
		utilizatori.add(u);
	}
	
	public static void cumpara(Utilizator u) {
		Integer pretT = 0;
			if(u.getCos().isEmpty()) {
				System.out.println("cosul tau este gol");
			}else {
				for(Produs p : u.getCos().keySet()) {
					if(produse.get(p.getId()).getStoc()>=u.getCos().get(p)) {
						pretT = pretT + (p.getPret()*u.getCos().get(p));
						System.out.println(p.getNume()+" x "+u.getCos().get(p)+ " = "+(p.getPret()*u.getCos().get(p)));
						produse.get(p.getId()).setStoc(produse.get(p.getId()).getStoc()-u.getCos().get(p));
						if(u.getIstCom().containsKey(p))
							u.getIstCom().replace(p, u.getIstCom().get(p)+u.getCos().get(p));
						else
							u.getIstCom().put(p, u.getCos().get(p));
					}
					else
						System.out.println("Acest produs nu mai este in stoc sau nu mai sunt suficiente bucati");
				}
					System.out.println("---------------------------------------------");
					System.out.println("Plata totala este: "+ pretT+".");
					System.out.println("Cash sau Card");
					u.getCos().clear();
				}
	}
	
	public static void ArataUtilizatori() {
		for(Utilizator u : utilizatori) {
			System.out.println(u.toString());
		}
	}
	
	public static void ArataProdusele() {
		for(String id : produse.keySet()) {
			System.out.println(produse.get(id).toString());
		}
	}
	
	
}
