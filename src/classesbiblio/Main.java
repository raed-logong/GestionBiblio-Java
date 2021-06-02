package classesbiblio;




import java.io.IOException;


import static classesbiblio.Base.*;


public class Main {


	
	public static void main(String[] args) throws InterruptedException, IOException {
		AdherantVector A;
		new AdherantVector();

		DocumentVector doc;
		new DocumentVector();
		charger();
		A=getA();
		doc=getDoc();
		Menu.intro();
		Menu.mainmenu(A, doc);

	
		//todo add document with same title(maybe add number);
		//todo confirmation d'ajout modifier supprimer;
		//todo choix menu pas encore controller;
		
		
		
		
	}

}
