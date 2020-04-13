/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Lista di stringhe
 */
public class Lista {

	/** Riferimento alla testa della lista */
	private Nodo testa;
	
	/** 
	 * Lista vuota
	 */
	public Lista(){
		testa = null;
	}
	
	/**
	 * Controllo lista vuota
	 * @return true se la lista e' vuota
	 */
	public boolean vuota(){
		return testa==null;
	}
	
	/**
	 * Inserisce un nuovo nodo in testa alla lista
	 * @param info Informazione da inserire nel nodo
	 */
	public void inserisciTesta(String info){
		Nodo n = new Nodo(info,testa);
		testa = n;
	} 

	/**
	 * Inserisce un nuovo nodo in coda alla lista
	 * @param info Informazione da inserire nel nodo
	 */
	public void inserisciCoda(String info){
		// gestione lista vuota
		if (vuota()) {
			inserisciTesta(info);
			return;
		}
		Nodo nuovo = new Nodo(info);		// nuovo nodo
		Nodo n;								// per scorrere la lista        
		n = testa;
		while(n.getSucc()!=null){
			n = n.getSucc();				// passaggio all'elemento successivo
		}
		n.setSucc(nuovo);					// collego l'ultimo nodo
	} 
	
	/**
	 * Elimina l'elemento in testa alla lista
	 * @return Informazione dell'elemento eliminato (null se lista vuota)
	 */
	public String eliminaInTesta() {
		if (vuota()) 
			return null;
		String s;
		s = testa.getInfo();
		testa = testa.getSucc(); // la lista inizia al nodo successivo
		return s;		// informazione del nodo eliminato
	}
	
	/**
	 * Elimina l'elemento in coda alla lista
	 * @return Informazione dell'elemento eliminato (null se lista vuota)
	 */	
	public String eliminaInCoda() {
		if (vuota()) 				// lista vuota
			return null;
		if (testa.getSucc()==null)	// lista di un solo nodo
			return eliminaInTesta();
		Nodo ps = testa;			// puntera' all'ultimo nodo
		Nodo pp = testa; 			// puntera' al penultimo nodo
		while(ps.getSucc() != null) { // scorrimento della lista
			pp = ps;
			ps = ps.getSucc();
		}
		String s;
		s = ps.getInfo();
		pp.setSucc(null); 			// il penultimo nodo diviene ultimo
		return s;
	}
	
	
	/**
	 * Visualizzazione di tutti le informazioni
	 */
	public void stampa(){
		Nodo n = testa;
		while(n!=null){
			System.out.println(n.getInfo());
			n = n.getSucc();
		}
	}
	
	public Iteratore getIterator() {
		Iteratore i = new Iteratore(testa);
		return i;
	}
}
