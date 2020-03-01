/**
 * esempio di utilizzo Thread
 */
public class Main {
	public static void main(String[] args) {
		final int dimArray = 1000000;		//dimensione array
		final int dimValori = 10000;		//valori casuali fra 1 e dimValori
		int vett[] = new int[dimArray];
		int valore;
		
		// caricamento array con valori casuali (i valori non sono ordinati)
		for (int i=0;i<dimArray;i++)
			vett[i] = (int) (Math.random() * dimValori);
			
		valore = (int) (Math.random() * dimValori);		//valore da cercare
		System.out.println("Valore da cercare: "+valore);
		
		// imposta la classe (Thread) per la ricerca nella prima metà dell'array
		Ricerca thr1 = new Ricerca(0, dimArray/2-1, vett, valore);
		// imposta la classe (Thread) per la ricerca nella seconda metà dell'array
		Ricerca thr2 = new Ricerca(dimArray/2,dimArray-1, vett, valore);
		
		thr1.start();						// run primo thread
		thr2.start();						// run secondo thread
		System.out.println("Thread partiti");
		
		while(thr1.isAlive()||thr2.isAlive());	// attesa
		System.out.println("Entrambe i Thread sono terminati");		
	}

}
