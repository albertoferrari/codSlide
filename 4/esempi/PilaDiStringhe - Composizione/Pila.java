/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Pila di stringhe utilizza una lista di stringhe
 */
public class Pila {
	/** Gli elementi della Pila sono nella Lista */
	private Lista l;

	/** Pila vuota */
	public Pila() {
		l = new Lista();
	}
	
	/**
	 * push
	 * @param s Stringa da inserire
	 */
	public void push(String s){
		l.inserisciTesta(s);
	}
	
	/**
	 * pop
	 * @return elemento in testa alla lista (null se vuota)
	 */
	public String pop(){
		return l.eliminaInTesta();
	}
	
	/**
	 * Controlla se la pila e' vuota
	 * @return true pila vuota
	 */
	public boolean vuota(){
		return l.vuota();
	}
	
}
