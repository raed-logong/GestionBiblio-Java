package classesbiblio;

import java.util.Date;
import java.util.Scanner;

public class Saisie {
	static Scanner ch;
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			@SuppressWarnings("unused")
			int d = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	public static int nbr(String a) {
		String c;
		int n1=-2;
		do {
			System.out.print("Donner "+a+":");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);

				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if(!((n1>=0)||(n1==-1)))
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);
		}while (!((n1>=0)||(n1==-1)));
		return n1;
	}
	public static int nbrexemp(String a) {
		String c;
		int n1=-2;
		do {
			System.out.print("Donner "+a+":");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if(!((n1>=1)||(n1==-1)))
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);
		}while (!((n1>=1)||(n1==-1)));
		return n1;
	}
	/*public static int nbr1(String a) {
		String c;
		int n1=-2;
		do {
			System.out.print("Donner "+a+":");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if(!(n1>=0))
				System.out.println(ConsoleColors.RED_BOLD+a+" est invalid"+
						ConsoleColors.RESET);
		}while (!((n1>=0)||(n1==-1)));
		return n1;
	}*/

	public static boolean verifdate(int j,int m,int a) {
		/**this is a test**/
		int jmax = 0;
	    switch (m)
	    {
	        case 1:
	        case 3:
	        case 5:
	        case 7:
	        case 8:
	        case 10:
	        case 12: jmax=31; break;
	        case 4:
	        case 6:
	        case 9:
	        case 11: jmax=30; break;
	        case 2: if (a%4==0)
	                    jmax=29;
	                else jmax=28;
				break;

		}
	    return j > 0 && j <= jmax && m > 0 && m<13 && a >= 0;
	}
	@SuppressWarnings("deprecation")
	public static Date date(String c) {

		Date d = null;
		System.out.print("Saisir la date "+c+":\n");
		int j,m,a;
		while(true) {

			j=nbr("le jour");
			m=nbr("le mois");
			a=nbr("l'annee");
			if(verifdate(j,m,a)==true) {
				d=new Date(a-1900,m-1,j);
				if(d.after(new Date(System.currentTimeMillis()))) {
					System.out.println(ConsoleColors.RED_BOLD+"date superieure a la date actuelle\n"+
							ConsoleColors.RESET);
					continue;
				}
				else
					break;
			}
			System.out.println(ConsoleColors.RED_BOLD+"date non valide\n"+
				 		ConsoleColors.RESET);

	}
		return d;
	}
	public static boolean checkstring(String ch){//checks if String not only spaces;
		boolean p=false;
		if(ch==null)
			return false;

		for(int i =0;i<ch.length();i++){
			if(ch.codePointAt(i) != ' ') {
				return true;
			}
		}

		return p;
	}

	public static boolean checkstring2(String ch){//Checks if a string has only letters
		boolean p=false;
		if(ch==null)
			return false;

		for(int i=0;i<ch.length();i++) {
			if (Character.isLetter(ch.charAt(i) )== false) {
				return false;

			}
		}
		for(int i =0;i<ch.length();i++){
			if(ch.codePointAt(i) != ' ') {
				return true;
			}
		}


		return p;
	}
	public static boolean checkstring3(String ch){//checks if String has only numbers and letters;
		boolean p=false;
		if(ch==null)
			return false;
		for(int i =0;i<ch.length();i++){
			if(Character.isLetterOrDigit(ch.charAt(i))==false) {
				return false;
			}
		}
		for(int i =0;i<ch.length();i++){
			if(ch.codePointAt(i) != ' ') {
				return true;
			}
		}

		return p;
	}
	public static boolean checksalle(String c){
		if(Localisation.salles.contains(c.toUpperCase())==true){
			return true;
		}
		return false;
	}
	public static String salle(){
		String ch1=null;
		do{

			System.out.print("Donner la salle :");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			ch1=ch.nextLine();
			ch1=ch1.trim();
			ConsoleColors.reset();
			if((checkstring3(ch1)==false)||(checksalle(ch1)==false)){
				System.out.println(ConsoleColors.RED_BOLD+"salle non existante"+
						ConsoleColors.RESET);
			}
		}while((checkstring3(ch1)==false)||(checksalle(ch1)==false));
		return ch1;
	}
	public static String string(String c) {
		
		String ch1=null;
		do{

			System.out.print("Donner "+c+":");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			ch1=ch.nextLine();
			ch1=ch1.trim();
			ConsoleColors.reset();
		}while(checkstring(ch1)==false);
		return ch1;
	}
	public static String stringname(String c) {

		String ch1=null;
		do{

			System.out.print("Donner "+c+":");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			ch1=ch.nextLine();
			ch1=ch1.trim();
			ConsoleColors.reset();
		}while(checkstring2(ch1)==false);
		return ch1;
	}
	public static int type() {
		String c;//=null;
		int n1=0;
		do {
			System.out.print("Donner le type(1-Visiteur;2-Etudiant;3-Enseignant):");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+"type invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if((!((n1>0)&&(n1<4))))
				System.out.println(ConsoleColors.RED_BOLD+"type invalid"+
				 		ConsoleColors.RESET);
		}while (!((n1>0)&&(n1<4)));
		return n1;
	}
	public static int type2() {
		String c;
		int n1=0;
		do {
			System.out.print("Donner le type(1-Article;2-Livre;3-Magazine):");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+"type invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if((!((n1>0)&&(n1<4))))
				System.out.println(ConsoleColors.RED_BOLD+"type invalid"+
				 		ConsoleColors.RESET);
		}while (!((n1>0)&&(n1<4)));
		return n1;
	}

	public static int id() {
		String c;

		int n1 = -2;
		do {
			System.out.print("Donner l'identifiant:");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+"id invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if (!((n1>=0)||(n1==-1)))
				System.out.println(ConsoleColors.RED_BOLD+"id invalid"+
				 		ConsoleColors.RESET);
		}while (!((n1>=0)||(n1==-1)));
		return n1;
	}
	public static int code() {
		String c;
		int n1=-2;
		do {
			System.out.print("Donner le code de document :");
			System.out.print(ConsoleColors.CYAN_BOLD);
			ch=new Scanner(System.in);
			c=ch.nextLine();
			c=c.trim();
			if(isNumeric(c)==false){
				System.out.println(ConsoleColors.RED_BOLD+"code invalid"+
						ConsoleColors.RESET);
				continue;
			}
			n1=Integer.parseInt(c);
			ConsoleColors.reset();
			if(!((n1>=0)||(n1==-1)))
				System.out.println(ConsoleColors.RED_BOLD+"code invalid"+
				 		ConsoleColors.RESET);
		}while (!((n1>=0)||(n1==-1)));
		return n1;
	}

}
