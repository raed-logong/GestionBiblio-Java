package classesbiblio;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private static Scanner choix;
	public static void intro() throws InterruptedException, IOException {
		  	System.out.println("\n\n\n\n");
		  	System.out.print("\t\t\t"+ConsoleColors.BLUE_BOLD+"Bienvenu de l'application de GestionBibliotheque"+
		  	ConsoleColors.RESET+"\n");
		  	System.out.print("\t\t\t");
		  	Animation.loading();
		  	Thread.sleep(1000);
		  	Animation.clrscr();
		  	
		  }
	public static void rechdocmenu(DocumentVector doc) throws IOException, InterruptedException {
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\tRecherche des documents\n\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Recherche par code\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Recherche par type\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Recherche par titre\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t5-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			case 1:doc.recherchecode();Animation.pause();break;
			case 2:doc.recherchetype();Animation.pause();break;
			case 3:doc.recherchetitre();Animation.pause();break;
			case 4:return;
			case 5:System.exit(1);
			default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
			ConsoleColors.RESET);Thread.sleep(2000);
			}
		}
	}
	public static void documentmenu(DocumentVector doc) throws IOException, InterruptedException {
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\tGestion des documents\n\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Ajouter un Document\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Modifier un Document\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Supprimer un Document\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Recherche des Documents\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t5-Statistic\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t6-Afficher tous les Documents\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t7-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t8-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			case 1:doc.ajouter();break;
			case 2:doc.modifier();break;
			case 3:doc.supprimer();break;
			case 4:		if(doc.size()==0){
					System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
						ConsoleColors.RESET);
					Animation.pause();
					break;
				}rechdocmenu(doc);break;
			case 5:doc.afficheemprunt();Animation.pause();;break;
			case 6:doc.afficheall();Animation.pause();break;
			case 7:return;
			case 8:System.exit(1);
			default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
			ConsoleColors.RESET);Thread.sleep(2000);
			}
		}
	}
	public static void rechadherantmenu(AdherantVector A) throws IOException, InterruptedException {
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\tRecherche des Adherants\n\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Recherche par id\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Recherche par type\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Recherche par nom\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Recherche par addresse\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t5-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t6-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			case 1:A.rechercheid();Animation.pause();break;
			case 2:A.recherchetype();Animation.pause();break;
			case 3:A.recherchenom();Animation.pause();break;
			case 4:A.recherchaddress();Animation.pause();break;
			case 5:return;
			case 6:System.exit(1);
			default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
			ConsoleColors.RESET);Thread.sleep(2000);
			}
		}
	}
	
	public static void adherantmenu(AdherantVector A) throws IOException, InterruptedException {
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\tGestion des Adherants\n\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Ajouter un Adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Modifier un Adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Supprimer un Adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Recherche Retardaires\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t5-Recherche des Adherants \n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t6-Afficher tous les Adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t7-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t8-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			case 1:A.ajouter();;break;
			case 2:A.modifier();;break;
			case 3:A.supprimer();break;
			case 4:A.afficheretard();Animation.pause();break;
			case 5:		if(A.size()==0){
							System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
							ConsoleColors.RESET);
								Animation.pause();
								break;
						}
						rechadherantmenu(A);break;
			case 6:A.afficheall();Animation.pause();break;
			case 7:return;
			case 8:System.exit(1);
			default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
			ConsoleColors.RESET);Thread.sleep(2000);
			}
		}
	}
	public static void empradhmenu(AdherantVector A,DocumentVector doc) throws IOException, InterruptedException{
		int id;
		while(true) {
		id=Saisie.id();
		if(id==-1){
				return;
		}
		if(!A.checkid(id)) {
			System.out.println(ConsoleColors.RED_BOLD+"id non existant"+
			ConsoleColors.RESET);
			continue;
		}
		break;
		}
		
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\t\t"+A.getAdByid(id).getName()
					+" "+A.getAdByid(id).getLastname()+"\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Ajouter un emprunt\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Retourner un emprunt\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Afficher tous les emprunts pour ce adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t5-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			 case 1 :A.ajouterempr(id, doc);;break;
			 case 2 :A.afficheemprparadh2(id);A.suppempr(id);;break;
			 case 3 :A.afficheemprparadh(id);Animation.pause();;break;
			 case 4 :return;
			 case 5 :System.exit(1);break;
			 default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
						ConsoleColors.RESET);Thread.sleep(2000);
			}
		}
			
	}
	public static void emprmenu(AdherantVector A,DocumentVector doc) throws IOException, InterruptedException{
		if(A.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun adherant enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		if(doc.size()==0){
			System.out.println(ConsoleColors.RED_BOLD+"il n'y a aucun document enregistré"+
					ConsoleColors.RESET);
			Animation.pause();
			return;
		}
		while(true) {
			Animation.clrscr();
			System.out.print(ConsoleColors.BLUE_BOLD+"\t\tGestion des Emprunts\n\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Gestion des emprunts par Adherant\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Afficher tous les emprunt\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Retourner au menu precedent\n"+ConsoleColors.RESET);
			System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Quitter\n"+ConsoleColors.RESET);
			int n;
			System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
			choix = new Scanner(System.in);
			n=choix.nextInt();
			System.out.print(ConsoleColors.RESET);
			switch(n) {
			 case 1 :empradhmenu(A,doc);break;
			 case 2 :A.afficheallemprunts();Animation.pause();break;
			 case 3 :return;
			 case 4 :System.exit(1);break;
			 default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
						ConsoleColors.RESET);Thread.sleep(2000);
			}
			}
	}
	public static void mainmenu(AdherantVector A,DocumentVector doc) throws IOException, InterruptedException {
		while (true){
		Animation.clrscr();
		System.out.print(ConsoleColors.BLUE_BOLD+"\t\t   Menu Principal\n\n"+ConsoleColors.RESET);
		System.out.print(ConsoleColors.GREEN_BOLD+"\t\t1-Gestion Des Adherants\n"+ConsoleColors.RESET);
		System.out.print(ConsoleColors.GREEN_BOLD+"\t\t2-Gestion Des Documents\n"+ConsoleColors.RESET);
		System.out.print(ConsoleColors.GREEN_BOLD+"\t\t3-Gestion Des Emprunts\n"+ConsoleColors.RESET);
		System.out.print(ConsoleColors.GREEN_BOLD+"\t\t4-Quitter\n"+ConsoleColors.RESET);
		int n;
		System.out.print("Votre Choix:"+ConsoleColors.CYAN_BOLD);
		choix = new Scanner(System.in);
		n=choix.nextInt();
		System.out.print(ConsoleColors.RESET);
		switch(n) {
		 case 1 :adherantmenu(A);break;
		 case 2 :documentmenu(doc);break;
		 case 3 :emprmenu(A,doc);break;
		 case 4 :System.exit(1);break;
		 default:System.out.println(ConsoleColors.RED_BRIGHT+"choix invalid"+
					ConsoleColors.RESET);Thread.sleep(2000);
		}
		}
	}

}
