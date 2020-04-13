/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Pila di stringhe eredita da una lista di stringhe
 */
public class Pila extends Lista{

	/** Pila vuota */
	public Pila() {
		super();
	}
	
	/**
	 * push
	 * @param s Stringa da inserire
	 */
	public void push(String s){
		super.inserisciTesta(s);
	}
	
	/**
	 * pop
	 * @return elemento in testa alla lista (null se vuota)
	 */
	public String pop(){
		return super.eliminaInTesta();
	}
	
	/**
	 * Controlla se la pila e' vuota
	 * @return true pila vuota
	 */
	public boolean vuota(){
		return super.vuota();
	}
	
}
