/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Iteratore di una lista Parametrica
 */

public class Iteratore <T>{
	
	/**
	 * Elemento attualmente riferito
	*/
	private Nodo<T> nodo;

	/**
	 * Elemento di partenza
	 * @param nodo elemento di partenza
	*/
	public Iteratore(Nodo<T> nodo) {
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
	public T next() {
		if (nodo==null)
			return null;
		T informazione = nodo.getInfo();
		nodo = nodo.getSucc(); // avanzamento di posizione nella lista
		return informazione;
	}
}
