package classesbiblio;

import java.util.ArrayList;
import java.util.Date;


public class DocumentVector {
	private ArrayList<Document> D;
	int nbrdoc=0;
	public DocumentVector() {
		this.D=new ArrayList<Document>();
	}
	public ArrayList<Document> getD() {
		return D;
	}

	public void setD(ArrayList<Document> d) {
		D = d;
	}

	public void add (Document e) {
		this.D.add(e);
		this.nbrdoc++;

	}
	public void add(Article a) {
		this.D.add(a);
		this.nbrdoc++;
	}
	public void add(Livre a) {
		this.D.add(a);
		this.nbrdoc++;
	}
	public void add(Magazine a) {
		this.D.add(a);
		this.nbrdoc++;
	}
	public int indice(int id) {
		int indice = -1;
		for(int i=0;i<=D.size();i++) {
			if(D.get(i).getCode()==id) {
				indice=i;
				break;
		
			}
		}
		return indice;
	}
	public void remove(int e) {
		int indice=this.indice(e);
		this.D.remove(indice);
	}
	public int getnbrdoc() {
		return this.nbrdoc;
	}
	public void afficheall() {
		if(D.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
					ConsoleColors.RESET);
			return;
		}
		for(int i=0;i<D.size();i++) {
			
				System.out.print(D.get(i));
			
		}	
	}
	public void affichelivre() {
		for(int i=0;i<D.size();i++) {
			if(D.get(i)  instanceof Livre)
			System.out.print(D.get(i));
		}
	}
	public void affichearticle() {
		for(int i=0;i<D.size();i++) {
			if(D.get(i)  instanceof Article)
			System.out.print(D.get(i));
		}
	}
	public void affichemagazine() {
		for(int i=0;i<D.size();i++) {
			if(D.get(i)  instanceof Magazine)
			System.out.print(D.get(i));
		}
	}
	public void afficheemprunt() {
		if(D.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
					ConsoleColors.RESET);
			return;
		}
		for(int i=0;i<D.size();i++) {
			//if(D.get(i).getNbempr()!=0)
			System.out.print("code="+D.get(i).getCode()+"|titre="+D.get(i).getTitle()+"|nbr empr total="+D.get(i).getTotal()+"\n");
		}
	}
	public void ajouter() {
		String title,Salle;
		int nbexmp,ray,type;
		title=Saisie.string("le titre");
		nbexmp=Saisie.nbrexemp("le nombre d'exemplaires");
		if(nbexmp==-1){
			return;
		}
		 Salle=Saisie.salle();
		 ray=Saisie.nbr("le rayon");
		if(ray==-1){
			return;
		}
		 Localisation loc=new Localisation(Salle,ray);
		 type=Saisie.type2();
		 switch(type) {
		 	case 1:	String auth;
		 			auth=Saisie.string("le nom d'auteur");
		 			Date date;
		 			date=Saisie.date("de publication");
		 			Article a=new Article(this.nbrdoc,title,nbexmp,loc,auth,date);
					System.out.println(ConsoleColors.GREEN_BOLD+"Article ajouté avec succes"+ConsoleColors.RESET);
		 			this.add(a);

		 			break;
		 	case 2:String auth1,edit;
		 			auth1=Saisie.string("le nom d'auteur");
		 			edit=Saisie.string("le nom d'editeur");
		 			Date date1;
		 			date1=Saisie.date("d'edition");
		 			Livre l=new Livre(this.nbrdoc,title,nbexmp,loc,auth1,edit,date1);
		 			this.add(l);
					System.out.println(ConsoleColors.GREEN_BOLD+"Livre ajouté avec succes"+ConsoleColors.RESET);
		 			break;
		 	case 3: int freq;
		 			freq=Saisie.nbr("la frequence de parution");
					if(freq==-1){
						return;
					}
		 			Magazine m=new Magazine(this.nbrdoc,title,nbexmp,loc,freq);
		 			this.add(m);
					System.out.println(ConsoleColors.GREEN_BOLD+"Magazine ajouter avec succes"+ConsoleColors.RESET);
		 			break;
		 }
		Animation.pause();
		 
		
		
		
	}

	public void setnbrdoc(int nbrdoc) {
		this.nbrdoc = nbrdoc;
	}
	public int size() {
		return D.size();
	}
	public boolean checkcode(int id) {
		boolean p=false;
		for(int i=0;i<D.size();i++) {
			if(D.get(i).getCode()==id)
				p=true;
		}
		return p;
	}
	public void supprimer() {
		if(D.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}

		int id1;
		while(true) {
		id1=Saisie.code();
			if(id1==-1){
				return;
			}
		if(this.checkcode(id1)==false) {
			System.out.println(ConsoleColors.RED_BOLD+"code non existant"+
			ConsoleColors.RESET);
			continue;
		}
		int indice=indice(id1);
		if(getD().get(indice).getNbempr()!=0){
			System.out.println(ConsoleColors.RED_BOLD+"impossible de supprimer un document qui a un emprunt en cours"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		this.remove(id1);
		System.out.println(ConsoleColors.GREEN_BOLD+"Document supprimé avec succes"+ConsoleColors.RESET);
		break;
		}
		Animation.pause();
	}
	public Document getdocByid(int id) {
		for(int i=0;i<D.size();i++) {
			if(D.get(i).getCode()==id) {
				return  D.get(i);
			}
		}
		return null;
	}
	public void modifier() {
		if(D.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		int id1;
		while(true) {
		id1=Saisie.code();
		if(id1==-1){
				return;
		}
		if(this.checkcode(id1)==false) {
			System.out.println(ConsoleColors.RED_BOLD+"code non existant"+
			ConsoleColors.RESET);
			continue;
		}
			break;
		}
		String title,Salle;
		int nbexmp,ray,type;
		title=Saisie.string("le titre");
		nbexmp=Saisie.nbrexemp("le nombre d'exemplaires");
		if(nbexmp==-1){
			return;
		}
		 Salle=Saisie.salle();
		 ray=Saisie.nbr("le rayon");
		if(ray==-1){
			return;
		}
		 Localisation loc=new Localisation(Salle,ray);
		 type=Saisie.type2();
		 int ind=this.indice(id1);
		 switch(type) {
		 	case 1:	String auth;
		 			auth=Saisie.string("le nom d'auteur");
		 			Date date;
		 			date=Saisie.date("de publication");
		 			Article a=new Article(id1,title,nbexmp,loc,auth,date);
		 			this.remove(id1);
		 			if(ind==D.size())
		 				D.add(a);
		 			else
		 				D.add(ind,a);
					System.out.println(ConsoleColors.GREEN_BOLD+"Article modifié avec succes"+ConsoleColors.RESET);
		 			break;
		 	case 2:String auth1,edit;
		 			auth1=Saisie.string("le nom d'auteur");
		 			edit=Saisie.string("le nom d'editeur");
		 			Date date1;
		 			date1=Saisie.date("d'edition");
		 			Livre l=new Livre(id1,title,nbexmp,loc,auth1,edit,date1);
		 			this.remove(id1);
					if(ind==D.size())
						D.add(l);
					else
						D.add(ind,l);
					System.out.println(ConsoleColors.GREEN_BOLD+"Livre modifié avec succes"+ConsoleColors.RESET);
		 			break;
		 	case 3: int freq;
		 			freq=Saisie.nbr("la frequence de parution");
					if(freq==-1){
						return;
					}
		 			Magazine m=new Magazine(id1,title,nbexmp,loc,freq);
		 			this.remove(id1);
					if(ind==D.size())
						D.add(m);
					else
						D.add(ind,m);
					System.out.println(ConsoleColors.GREEN_BOLD+"Magazine modifié avec succes"+ConsoleColors.RESET);
		 			break;

		 }
		Animation.pause();
	}
	public void recherchecode() {
		int id;
			id=Saisie.code();
			if(id==-1){
				return;
			}
			if(this.checkcode(id)==false) {
				System.out.println(ConsoleColors.RED_BOLD+"code non existant"+
				ConsoleColors.RESET);
				return;
			}
			System.out.print(this.getdocByid(id));
	}
	public void affichetype(int type) {
		switch(type) {
		case 1:this.affichearticle();break;
		case 2:this.affichelivre();break;
		case 3:this.affichemagazine();break;
		}
	}
	public void recherchetype() {
		int type=Saisie.type2();
		affichetype(type);
	}
	public void recherchetitre() {
		String nom=Saisie.string("le titre");
		for(int i=0;i<D.size();i++) {
			if(D.get(i).getTitle().toLowerCase().matches("(.*)"+nom.toLowerCase()+"(.*)"))
				System.out.print(D.get(i));
		}
	}
}

