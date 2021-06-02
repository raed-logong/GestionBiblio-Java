package classesbiblio;

import java.io.IOException;



public class Animation {
	public static void loading() throws InterruptedException {
		System.out.print(ConsoleColors.BLUE_BOLD_BRIGHT+"                     LOADING \n");
		System.out.printf("\t\t\t\t        ");
		for(int i=0;i<17;i++) {
			System.out.print(ConsoleColors.CYAN_BACKGROUND_BRIGHT+" "+
					ConsoleColors.RESET);
			Thread.sleep(200);
		}
	}
	public static void clrscr() throws IOException {
		for(int i=0;i<200;i++) {
			System.out.printf("\n");
		}
	
	}
	@SuppressWarnings("resource")
	public static void pause() {
	       System.out.println("\nPress Any Key To Continue...");
	          new java.util.Scanner(System.in).nextLine();
	     }

}