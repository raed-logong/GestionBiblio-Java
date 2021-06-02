package classesbiblio;

import java.util.ArrayList;



public class AdherantVector {
	private ArrayList<Adherant> A;
	public ArrayList<Adherant> getA() {
		return A;
	}
	public void setA(ArrayList<Adherant> a) {
		A = a;
	}
	int nbrad=0;
	public int getnbrad() {
		return nbrad;
	}
	public void setNnrad(int nbrad) {
		this.nbrad = nbrad;
	}
	public AdherantVector() {
		this.A=new ArrayList<Adherant>();
	}
	public int size() {
		return A.size();
	}
	public void add(Adherant P) {
		A.add(P);
		this.nbrad++;
	}
	public int indice(int id) {
		int indice = -1;
		for(int i=0;i<=A.size();i++) {
			if(A.get(i).getId()==id) {
				indice=i;
				break;
		
			}
		}
		return indice;
	}
	public void remove(int id) {
		int indice=this.indice(id);
		A.remove(indice);
	}
	
	public void afficheall() {
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
			return;
		}
		for(int i=0;i<A.size();i++) {
			System.out.print(A.get(i));
		}
	}
	public Adherant getAdByid(int id) {
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getId()==id) {
				return  A.get(i);
			}
		}
		return null;
	}
	public void affichetype(int type) {
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getType()==type) {
				System.out.print(A.get(i));
				A.get(i).afficheempradh3();
			}
		}	
	}
	public void checkretard() {
		for(int i=0;i<A.size();i++) {
			A.get(i).checkretard();
		}
	}
	public void afficheretard() {
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
			return;
		}
		boolean p=true;
		System.out.print("|id |nom\n");
		for(int i=0;i<A.size();i++) {
			if(A.get(i).isRetard()) {
				System.out.print("|"+A.get(i).getId()+"  |"+A.get(i).getName()+" "+
			A.get(i).getLastname()+"\n");p=false;
			}
		}
		if(p==true) {
			System.out.print("aucun adherant est en retard");
		}
	}
	public void ajouter() {
		 String name;
		 String lastname;
		 String address;
		 int type;
		 name=Saisie.stringname("le nom");
		 lastname=Saisie.stringname("le prenom");
		 address=Saisie.string("l'adresse");
		 type=Saisie.type();
		 Adherant P = new Adherant(this.getnbrad(),name,lastname,address,type) ;
		 this.add(P);
		System.out.println(ConsoleColors.GREEN_BOLD+"Adherant ajouter avec succes"+ConsoleColors.RESET);
		Animation.pause();
	}
	public void modifier() {
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		int id1;
		while(true) {
			id1=Saisie.id();
			if(id1==-1){
				return;
			}
			if(this.checkid(id1)==false) {
				System.out.println(ConsoleColors.RED_BOLD+"id non existant"+
						ConsoleColors.RESET);
				continue;
			} 
			break;
		}
		int id=indice(id1);
		String name;
		 String lastname;
		 String address;
		 int type;
		 name = Saisie.stringname("le nom");
		 lastname=Saisie.stringname("le prenom");
		 address=Saisie.string("l'addresse");
		 type=Saisie.type();
		 	A.get(id).setName(name);
		 	A.get(id).setLastname(lastname);
		 	A.get(id).setAddress(address);
		 	A.get(id).setType(type);
		System.out.println(ConsoleColors.GREEN_BOLD+"Adhernt modifier avec succes"+ConsoleColors.RESET);
		Animation.pause();
	}
	public boolean checkid(int id) {
		boolean p=false;
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getId()==id)
				p=true;
		}
		return p;
	}
	public void supprimer() {
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
				Animation.pause();
				return;
		}
		int id1;
		while(true) {
			id1 = Saisie.id();
			if(id1==-1){
				return;
			}
			if (this.checkid(id1) == false) {
				System.out.println(ConsoleColors.RED_BOLD + "id non existant" +
						ConsoleColors.RESET);
				continue;
			}
		int id=indice(id1);
		if(A.get(id).isRetard()){
			System.out.println(ConsoleColors.RED_BOLD+"impossible de supprimer un adherant en retard"+
					ConsoleColors.RESET);
			continue;
		}
		this.remove(id1);
			System.out.println(ConsoleColors.GREEN_BOLD+"Adhernt supprimer avec succes"+ConsoleColors.RESET);
			Animation.pause();

		break;

		}

	}
	public void afficheallemprunts() {
		boolean p=true;
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getListeemprunt().size()!=0) {
				p=false;
				A.get(i).afficheemprunts();
			}
		}
		if(p==true)
			System.out.println(ConsoleColors.RED+"il n'ya aucune emprunt en cours"+ConsoleColors.BLACK);
	}
	public void afficheemprparadh(int id) {
		int indice=this.indice(id);
		A.get(indice).afficheempradh();
	}
	public void afficheemprparadh2(int id) {
		int indice=this.indice(id);
		A.get(indice).afficheempradh2();
	}
	public void ajouterempr(int id,DocumentVector doc) throws InterruptedException {

		int indice=this.indice(id);
		if(A.get(indice).isRetard()) {
			System.out.println(ConsoleColors.RED+"L'Adherant est en retard"+ConsoleColors.RESET);
			Animation.pause();;
			return;
		}
		if(A.get(indice).getNbrmax()<=A.get(indice).getNbremprencours()) {
			System.out.println(ConsoleColors.RED+"Le nombre maximal de document a emprunter("+
					A.get(indice).getNbrmax()+")est atteint"+ConsoleColors.RESET);
			Animation.pause();;
			return;
		}
		A.get(indice).ajouterempr(doc);
		this.checkretard();
	}
	public void suppempr(int id) throws InterruptedException {
		int indice=this.indice(id);
		A.get(indice).suppempr();
		this.checkretard();
	}
	public void rechercheid() {
		int id;
		id=Saisie.id();
			if(this.checkid(id)==false) {
				System.out.println(ConsoleColors.RED_BOLD+"id non existant"+
				ConsoleColors.RESET);
				return;
			}
			System.out.print(this.getAdByid(id));
			this.getAdByid(id).afficheempradh3();
	}
	public void recherchetype() {
		int type=Saisie.type();
		affichetype(type);

	}
	public void recherchenom() {
		String nom=Saisie.string("le nom a rechercher");
		for(int i=0;i<A.size();i++) {
			if((A.get(i).getName().toLowerCase().matches("(.*)"+nom.toLowerCase()+"(.*)"))
				||(A.get(i).getLastname().toLowerCase().matches("(.*)"+nom.toLowerCase()+"(.*)"))) {
				System.out.print(A.get(i));
				A.get(i).afficheempradh3();
				System.out.println();

			}
		}
	}
	/*public void recherchprenom() {
		String nom=Saisie.string("le prenom a rechercher");
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getLastname().toLowerCase().matches("(.*)"+nom.toLowerCase()+"(.*)"))
				System.out.print(A.get(i));
			
		}
	}*/
	public void recherchaddress() {
		String nom=Saisie.string("l'addresse a rechercher");
		for(int i=0;i<A.size();i++) {
			if(A.get(i).getAddress().toLowerCase().matches("(.*)"+nom.toLowerCase()+"(.*)")) {
				System.out.print(A.get(i));
				A.get(i).afficheempradh3();
			}

		}
	}
	
}
