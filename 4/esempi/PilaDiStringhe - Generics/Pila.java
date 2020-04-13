
/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Pila di stringhe utilizza una lista di stringhe
 */
public class Pila <T>{
	/** Gli elementi della Pila sono nella Lista */
	private Lista <T> l;

	/** Pila vuota */
	public Pila() {
		l = new Lista <T>();
	}
	
	/**
	 * push
	 * @param info informazione da inserire
	 */
	public void push(T inf){
		l.inserisciTesta(inf);
	}
	
	/**
	 * pop
	 * @return elemento in testa alla lista (null se vuota)
	 */
	public T pop(){
		T temp;
		temp = l.eliminaInTesta();
		return temp;
	}
	
	/**
	 * Controlla se la pila e' vuota
	 * @return true pila vuota
	 */
	public boolean vuota(){
		return l.vuota();
	}
	
}
