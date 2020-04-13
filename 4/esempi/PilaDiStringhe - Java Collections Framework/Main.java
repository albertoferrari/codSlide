import java.util.Stack;

/**
 * @author Alberto Ferrari - https://albertoferrari.github.io/
 * @license This software is free - http://www.gnu.org/licenses/gpl.html
 * Esempio uso Stack
 */
public class Main {

	public static void main(String[] args) {
		Stack<String> s;
		String inutile;
		s = new Stack<String>();
		s.push("O");
		s.push("A");
		s.push("X");
		inutile = s.pop();
		s.push("I");
		s.push("C");
		while (!s.empty())
			System.out.println(s.pop()); 
	}

}
