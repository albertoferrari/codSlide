/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Nodo di una lista parametrica
 */
public class Nodo <T>{
	
	/** Informazione */
	private T info;
	/** riferimento al nodo successivo */
	private Nodo<T> succ;
	
	/**
	 * Nodo vuoto
	 */
	public Nodo(){
		info = null;
		succ = null;
	}
	
	/**
	 * Nodo senza riferimento al successivo
	 * @param info Informazione da inserire nel nodo
	 */
	public Nodo(T info) {
		this.info = info;
		this.succ = null;
	}

	/**
	 * Nodo con informazione e riferimento al successivo
	 * @param info Informazione da inserire nel nodo
	 * @param succ Riferimento al nodo successivo
	 */
	public Nodo(T info, Nodo<T> succ) {
		this.info = info;
		this.succ = succ;
	}
   
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Nodo <T> getSucc() {
		return succ;
	}

	public void setSucc(Nodo<T> succ) {
		this.succ = succ;
	}
	
}
