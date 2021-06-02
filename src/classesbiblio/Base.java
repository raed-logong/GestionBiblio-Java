package classesbiblio;

import java.util.Date;

public class Base {
    private static AdherantVector A=new AdherantVector();
    private static DocumentVector doc=new DocumentVector();


    public static AdherantVector getA() {
        return A;
    }

    public void setA(AdherantVector a) {
        A = a;
    }

    public static DocumentVector getDoc() {
        return doc;
    }

    public void setDoc(DocumentVector doc) {
        Base.doc = doc;
    }
    @SuppressWarnings("deprecation")
	public static void charger() throws InterruptedException {
        Date d5=new Date(120,7,22);
        Date d1 = new Date(120, 7, 22);
        Date d2=new Date(120,4,9);
        Date d3=new Date(102,6,25);
        Date d4=new Date(111,4,12);
        Localisation l1=new Localisation("A3",1);
        Localisation l2=new Localisation("A2",3);
        Localisation l3=new Localisation("A1",2);
        Adherant P1=new Adherant(A.getnbrad(),"Attia" ,"Raed","Sidiabdlahmid",1);
        A.add(P1);
         Adherant P2=new Adherant(A.getnbrad(),"Ghnem" ,"Ahmed","monastir",2);
        A.add(P2);
        Adherant P3=new Adherant(A.getnbrad(),"Foulen","Fouleni","Sousse",3);
        A.add(P3);
        Article D1=new Article(doc.getnbrdoc(), "test", 2, l1, "poly", d4);
        doc.add(D1);
        Magazine D2=new Magazine(doc.getnbrdoc(),"magazine1", 1, l2, 4);
        doc.add(D2);
        Livre D3=new Livre(doc.getnbrdoc(), "livre1", 3, l3, "victor", "7arbi", d3);
        doc.add(D3);
        Emprunt e1=new Emprunt(P1.getListeemprunt().size(),P1,D1,d1);
        P1.emprunter(e1);
        Emprunt e2=new Emprunt(P2.getListeemprunt().size(),P2,D2,d2);
        P2.emprunter(e2);
        Emprunt e3=new Emprunt(P3.getListeemprunt().size(),P3,D3,d5);
        P3.emprunter(e3);
        A.checkretard();
    }
}
