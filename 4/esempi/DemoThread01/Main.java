
public class Main {

	public static void main(String[] args) {
		String nt = "Thread number: ";
		for(int i =0; i<10; i++)
			new ThreadImplementation01(nt+i).start();
	}

}
