/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Esempio uso Stack
 */
public class Main {

	public static void main(String[] args) {
		Pila s;
		String inutile;
		s = new Pila();
		s.push("O");
		s.push("A");
		s.push("X");
		inutile = s.pop();
		s.push("I");
		s.push("C");
		while (!s.vuota())
			System.out.println(s.pop()); 
	}

}
