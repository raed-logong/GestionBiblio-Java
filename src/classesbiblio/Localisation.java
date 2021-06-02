package classesbiblio;

import java.util.ArrayList;

public class Localisation {
	private String salle;
	private int rayon;
    public static ArrayList<String> salles = new ArrayList<String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add("A1");
		add("A2");
		add("A3");
		add("B1");
		add("B2");
		add("B3");
		add("C1");
		add("C2");
		add("C3");
	}};


	public Localisation(String salle, int rayon) {
		this.salle = salle;
		this.rayon = rayon;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	public String toString() {
		return "salle="+this.getSalle()+",rayon="+this.getRayon();
	}

}
