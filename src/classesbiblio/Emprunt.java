package classesbiblio;

import java.util.Date;

public class Emprunt  {
	private int num;
	private Adherant emprunteur;
	private Document doc;
	private Date dateempr;
	private  Date datelim;
	
	
	public Emprunt(int num,Adherant emprunteur,Document doc,Date dateempr) {
		this.setNum(num);
		this.emprunteur=emprunteur;
		this.dateempr = dateempr;
		this.doc=doc;
		switch(emprunteur.getType()) { 
			case 1: this.datelim=new Date(dateempr.getTime()+259200000);break;//3jours
			case 2: this.datelim=new Date(dateempr.getTime()+604800000);break;//7jours
			case 3: this.datelim=new Date(dateempr.getTime()+1209600000);break;//14jours
	}
	
	}
	public Date getDateempr() {
		return dateempr;
	}
	public void setDateempr(Date dateempr) {
		this.dateempr = dateempr;
	}
	public Date getDatelim() {
		return datelim;
	}

	public Adherant getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Adherant emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	public String toString() {
		if(this.datelim.before(new Date(System.currentTimeMillis())))
		return ConsoleColors.RED_BOLD+"[Document= "+doc.getTitle()+",emprunte par:"+emprunteur.getName()+
				" "+emprunteur.getLastname()+" le="+this.dateempr+" et a retourner avant le="+
				this.datelim+"]\n"+ConsoleColors.RESET;
		else
			return "[Document= "+doc.getTitle()+",emprunte par:"+emprunteur.getName()+
					" "+emprunteur.getLastname()+" le="+this.dateempr+" et a retourner avant le="+
					this.datelim+"]\n";

		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void afficheparadh() {
		if(this.datelim.before(new Date(System.currentTimeMillis())))
			System.out.print(ConsoleColors.RED_BOLD+"[num="+this.num+"|Document= "+doc.getTitle()+" emprunter le="+this.dateempr+" et a retourner avant le="+
					this.datelim+"]\n"+ConsoleColors.RESET);
		else
			System.out.print("[num="+this.num+"|Document= "+doc.getTitle()+" emprunter le="+this.dateempr+" et a retourner avant le="+
					this.datelim+"]\n");
	}
}
