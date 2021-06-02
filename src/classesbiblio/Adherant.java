package classesbiblio;

import java.util.ArrayList;
import java.util.Date;

public class Adherant {
	/*Date myDate = new Date();
System.out.println(myDate);
System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));
System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
System.out.println(myDate);*/
	private int id;
	private String name;
	private String lastname;
	private String address;
	private int type;
	private int nbrmax;

	private int nbempreff;
	private int nbemprdep;
	private ArrayList<Emprunt> listeemprunt=new ArrayList<>();
	///private int nbremprencours=this.listeemprunt.size();
	private boolean retard=false;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
	}
	public Adherant() {
		
	}
	public Adherant(int id,String name,String lastname,String adress,int type) {
		this.id=id;
		this.name=name;
		this.lastname=lastname;
		this.address=adress;
		this.type=type;
		switch(this.type) {
			case 1: this.nbrmax=1;break;
			case 2: this.nbrmax=2;break;
			case 3: this.nbrmax=3;break;
		}
		
		
	}


	public int getNbrmax() {
		return nbrmax;
	}

	public void setNbrmax(int nbrmax) {
		this.nbrmax = nbrmax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNbempreff() {
		return nbempreff;
	}
	public void setNbempreff(int nbempreff) {
		this.nbempreff = nbempreff;
	}
	public int getNbemprdep() {
		return nbemprdep;
	}
	public void setNbemprdep(int nbemprdep) {
		this.nbemprdep = nbemprdep;
	}
	public int getNbremprencours() {
		return this.listeemprunt.size();
	}
	/*public void setNbremprencours(int nbremprencours) {
		this.nbremprencours = nbremprencours;
	}*/

	public ArrayList<Emprunt> getListeemprunt() {
		return listeemprunt;
	}

	public void setListeemprunt(ArrayList<Emprunt> listeemprunt) {
		this.listeemprunt = listeemprunt;
	}

	public boolean isRetard() {
		return retard;
	}

	public void setRetard(boolean retard) {
		this.retard = retard;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public String toString() {
		if(this.name==null) {
			return"";
		}
		
		String ch = null;
		switch(this.type) {
			case 1: ch="Visiteur";break;
			case 2: ch="Etudiant";break;
			case 3: ch="Enseignant";break;
		}
		if(this.isRetard())
			return ConsoleColors.RED_BOLD+"[id="+this.getId()+"|nom="+this.getName()+"|prenom="+this.getLastname()+
				"|address= "+this.getAddress()+"|type="+ch+"|nbr emprunt eff="+this.getNbempreff()+
				"|nbr emprunt en cours="+this.getNbremprencours()+
				"|nbr emprunt depasse="+this.getNbemprdep()+"]\n"+ConsoleColors.RESET;
		if(this.listeemprunt.size()!=0){
			return ConsoleColors.BLUE_BOLD+"[id="+this.getId()+"|nom="+this.getName()+"|prenom="+this.getLastname()+
					"|address= "+this.getAddress()+"|type="+ch+"|nbr emprunt eff="+this.getNbempreff()+
					"|nbr emprunt en cours="+this.getNbremprencours()+
					"|nbr emprunt depasse="+this.getNbemprdep()+"]\n"+ConsoleColors.RESET;
		}
			return "[id="+this.getId()+"|nom="+this.getName()+"|prenom="+this.getLastname()+
					"|address= "+this.getAddress()+"|type="+ch+"|nbr emprunt eff="+this.getNbempreff()+
					"|nbr emprunt en cours="+this.getNbremprencours()+
					"|nbr emprunt depasse="+this.getNbemprdep()+"]\n";
		
	}
	public void checkretard() {
		this.nbemprdep=0;
		this.setRetard(false);
		Date d1=new Date(System.currentTimeMillis());
		for(int i=0;i<this.listeemprunt.size();i++) {
			if(this.listeemprunt.get(i).getDatelim().before(d1)) {
				this.setRetard(true);
				this.nbemprdep++;
			}
		}
	}
	/*public void emprunter(Document d,Date d1) {
		Adherant p=new Adherant(this.id, this.name, this.lastname, this.address, this.type);
		Emprunt e=new Emprunt(p,d,d1);
		this.listeemprunt.add(e);
		this.nbempreff++;
	}*/
	public boolean checkdoc(Document d){
		boolean p=false;
		for(int i=0;i<this.listeemprunt.size();i++) {
			if(d.getCode()==this.listeemprunt.get(i).getDoc().getCode()) {
				p=true;
				break;
			}
		}return p;
	}
	public void emprunter(Emprunt e) throws InterruptedException {


		if(e.getDoc().getNbempr()>=e.getDoc().getNbexmp()) {
			System.out.println(ConsoleColors.RED+"il n ya plus d'exemplaires disponible pour ce document"+
								ConsoleColors.RESET);
			Animation.pause();;
			return;
		}
		if(checkdoc(e.getDoc())==true) {
			System.out.println(ConsoleColors.RED+"L'adherant a deja emprunte ce document"+
					ConsoleColors.RESET);
			Animation.pause();;
			return;
		}
		this.listeemprunt.add(e);
		this.nbempreff++;
		e.getDoc().setNbempr(e.getDoc().getNbempr()+1);
		e.getDoc().setTotal(e.getDoc().getTotal()+1);
	}
	public void afficheemprunts() {
			System.out.println(ConsoleColors.BLUE+"Adherant:"+this.getName()+" "+this.getLastname()+ConsoleColors.RESET);
			for(int i=0;i<this.getListeemprunt().size();i++) {
				this.getListeemprunt().get(i).afficheparadh();
			}
		

	}
	public void afficheempradh() {
		checkretard();
		if(this.getListeemprunt().size()==0) {
			System.out.println(ConsoleColors.RED+"l'adherant n'a pas d'emprunt en cours"+ConsoleColors.BLACK);
			return;
		}
		System.out.println(ConsoleColors.BLUE+"Adherant:"+this.getName()+" "+this.getLastname()+ConsoleColors.RESET);
		for(int i=0;i<this.getListeemprunt().size();i++) {
			this.getListeemprunt().get(i).afficheparadh();
		}
	}
	public void afficheempradh2() {
		checkretard();
		if(this.getListeemprunt().size()==0) {
			return;
		}
		System.out.println(ConsoleColors.BLUE+"Adherant:"+this.getName()+" "+this.getLastname()+ConsoleColors.RESET);
		for(int i=0;i<this.getListeemprunt().size();i++) {
			this.getListeemprunt().get(i).afficheparadh();
		}
	}
	public void afficheempradh3() {
		checkretard();
		if(this.getListeemprunt().size()==0) {
			System.out.println(ConsoleColors.RED+"l'adherant n'a pas d'emprunt en cours"+ConsoleColors.BLACK);
			return;
		}
		System.out.println(ConsoleColors.BLUE+"List emprunts de "+this.getName()+" "+this.getLastname()+":"+ConsoleColors.RESET);
		for(int i=0;i<this.getListeemprunt().size();i++) {
			this.getListeemprunt().get(i).afficheparadh();
		}
	}
	public void ajouterempr(DocumentVector doc) throws InterruptedException {
		int code;
		while(true) {
			code=Saisie.code();
			if(code==-1){
				return;
			}
			if(doc.checkcode(code)==false) {
				System.out.println(ConsoleColors.RED_BOLD+"code non existant"+
				ConsoleColors.RESET);
				continue;
			}
			break;
			}
		int indice =doc.indice(code);
		Date d=new Date(System.currentTimeMillis());
		Emprunt e=new Emprunt(this.listeemprunt.size(),this,doc.getD().get(indice),d);
		this.emprunter(e);
		checkretard();
		System.out.println(ConsoleColors.GREEN_BOLD+"Emprunt ajouter avec succes"+ConsoleColors.RESET);
		Animation.pause();
	}
	public void resetindex() {
		for(int i=0;i<this.listeemprunt.size();i++) {
			this.listeemprunt.get(i).setNum(i);
		}
	}
	public void suppempr() throws InterruptedException {
		int num;
		if(this.getListeemprunt().size()==0) {
			System.out.println(ConsoleColors.RED+"l'adherant n'a pas d'emprunt en cours"+ConsoleColors.BLACK);
			Thread.sleep(2000);
			return;
		}
		while(true) {
			num=Saisie.nbr("le numero");
			if(num==-1){
				return;
			}
			if(num>=this.listeemprunt.size()) {
				System.out.println(ConsoleColors.RED_BOLD+" num non existant"+
				 		ConsoleColors.RESET);
				Thread.sleep(2000);
				continue;
			}
			break;
		
		}
		this.listeemprunt.get(num).getDoc().setNbempr(this.listeemprunt.get(num).getDoc().getNbempr()-1);
		this.listeemprunt.remove(num);
		this.resetindex();
		checkretard();
		System.out.println(ConsoleColors.GREEN_BOLD+"Emprunt supprimer avec succes"+ConsoleColors.RESET);
		Animation.pause();

	}
}
