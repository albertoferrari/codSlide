import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		Docente ferrari = new Docente("A. Ferrari","Informatica");
		Docente paganuzzi = new Docente("A. Paganuzzi","Informatica");
		Docente rossi = new Docente("V. Rossi","Storia");
		Docente jack = new Docente("J. Jack","Inglese");
		Docente verdi = new Docente("G. Verdi","Musica");
		Consiglio quarta_a = new Consiglio("4aINF");
		quarta_a.setInizio(LocalTime.of(14, 30));
		quarta_a.setFine(LocalTime.of(16, 15));
		quarta_a.setCoordinatore(rossi);
		quarta_a.setSegretario(jack);
		quarta_a.aggiungi(ferrari);
		quarta_a.aggiungi(paganuzzi);
		quarta_a.aggiungi(verdi);		
		System.out.print("cosiglio di "+quarta_a.getClasse());
		System.out.println(" durata "+quarta_a.durata()+" minuti");
		//System.out.println("numero docenti "+quarta_a.numeroDocenti());
		//System.out.println(quarta_a);
	}

}
