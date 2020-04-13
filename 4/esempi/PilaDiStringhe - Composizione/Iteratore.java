/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Iteratore di una lista di stringhe
 */

public class Iteratore {
	
	/**
	 * Elemento attualmente riferito
	*/
	private Nodo nodo;

	/**
	 * Elemento di partenza
	 * @param nodo elemento di partenza
	*/
	public Iteratore(Nodo nodo) {
		this.nodo = nodo;
	}
	
	/**
	 * @return true se esistono altri elementi nella lista
	*/
	public boolean hasNext() {
		return (!(nodo==null));
	}
	
	/**
	 * Passaggio all'elemento successivo
	 * @return informazione dell'elemento attualmente riferito 
	*/
	public String next() {
		if (nodo==null)
			return null;
		String informazione = nodo.getInfo();
		nodo = nodo.getSucc(); // avanzamento nella lista
		return informazione;
}
}
