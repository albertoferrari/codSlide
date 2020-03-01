/**
 * ricerca un elemento in un array
 */
public class Ricerca extends java.lang.Thread {
	
	/** indice minimo di ricerca */
	private int imin;	
	
	/** indice massimo di ricerca */
	private int imax;
	
	/** array che contiene gli elementi da analizzare */
	private int v[];
	
	/** valore da ricercare */
	private int val;

	/**
	 * Imposta tutti i parametri per effettuare la ricerca
	 * @param imin indice minimo
	 * @param imax indice massimo
	 * @param v vettore (contiene gli elementi)
	 * @param val valore da cercare
	 */
	public Ricerca(int imin, int imax, int[] v, int val) {
		super();
		this.imin = imin;
		this.imax = imax;
		this.v = v;
		this.val = val;
	}
	
	/**
	 * visualizza gli indici degli elementi presenti in v con valore val
	 */
	public void run() {	
		Thread t = Thread.currentThread();			// accesso al thread attuale
		t.setName("Ricerca da "+imin+" a "+imax);	// imposto il nome del thread
		for(int i=imin;i<=imax;i++)					// ricerca sequenziale
			if (v[i]==val) {
				System.out.println(t.getName()+" indice "+i);
				// attesa casuale (per rallentare l'esecuzione)
				try {
					sleep((long)(Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
		System.out.println(t.getName()+" Finito");
	}
}
