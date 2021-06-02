package classesbiblio;

import java.util.Date;

public class Livre extends Document{

	private String auteur;
	private String editeur;
	private Date dateedition;
	public Livre(int code, String title, int nbexmp, Localisation loc,
			String auteur,String editeur,Date dateedition) {
		super(code, title, nbexmp, loc);
		this.auteur=auteur;
		this.editeur=editeur;
		this.dateedition=dateedition;

	}
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Date getDateedition() {
		return dateedition;
	}
	public void setDateedition(Date dateedition) {
		this.dateedition = dateedition;
	}
	public String toString() {
		
		return "[code="+this.getCode()+"|type=Livre"+"|titre="+this.getTitle()+
		"|localisation:"+this.getLoc()+"|nbrexmp="+this.getNbexmp()+
		"|nbrempr="+this.getNbempr()+"|auteur="+this.getAuteur()+"|editeur="+this.getEditeur()+
		"|date edition="+this.getDateedition()+"]\n";
	}
}
