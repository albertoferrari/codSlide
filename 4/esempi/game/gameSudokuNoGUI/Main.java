import java.util.Scanner;

/**
 * sudoku senza interfaccia grafica
 * @author AF
 *
 */
public class Main {

	/**
	 * visualizza lo stato del gioco
	 * @param m
	 */
	public static void visualizza(int[][] m) {
		for (int[] riga : m) {
			for (int val: riga)
				System.out.print(val+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.print("nome del file che contiene la griglia iniziale: ");
		String nomeFile = tastiera.nextLine();
		Sudoku s = new Sudoku(nomeFile);
		int r,c,v;		// riga, colonna, valore
		String scelta;	// inserimento o eliminazione
		if (s.ammissibile()) {
			System.out.println("sudoku ammissibile");
			while (!s.risolto()) {
				visualizza(s.stato());
				String foo = tastiera.nextLine();		//pulizia buffer
				System.out.println("scelta: (i)nserisci o (e)limina ");
				scelta = tastiera.nextLine();
				System.out.println("riga   : "); r=tastiera.nextInt();
				System.out.println("colonna: "); c=tastiera.nextInt();
				if (scelta.charAt(0)=='i') {
					System.out.println("valore : "); v=tastiera.nextInt();
					if (s.inserisci(r,c,v)) {
						System.out.println("*** modifica effettuata ***");
					} else {
						System.out.println("*** operazione non ammessa ***");
					}
				} 
				else {
					if (s.elimina(r,c)) {
						System.out.println("*** eliminazione effettuata ***");
					} else {
						System.out.println("*** operazione non ammessa ***");
					}				
				}
			}
			System.out.println("complimenti sudoku risolto!");
		}
		else
			System.out.println("sudoku non ammissibile");
	}

}
