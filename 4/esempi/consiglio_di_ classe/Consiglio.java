import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * @author AF
 * Consiglio di classe
 */
public class Consiglio {
	
	/** classe */
	private String classe;
	/** orario di inizio */
	private LocalTime inizio;
	/** orario di fine */
	private LocalTime fine;	
	/** docente coordinatore */
	private Docente coordinatore;
	/** docente segretario */
	private Docente segretario;	
	/** elenco docenti */
	private ArrayList<Docente> docenti;
	
	/**
	 * @param classe classe
	 */
	public Consiglio(String classe) {
		super();
		this.classe = classe;
		this.inizio = LocalTime.of(0, 0);
		this.fine = LocalTime.of(0, 0);
		this.coordinatore = null;
		this.segretario = null;
		this.docenti = new ArrayList<Docente>();
	}

	/**
	 * @return classe
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * @param classe classe
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * @return orario di inizio
	 */
	public LocalTime getInizio() {
		return inizio;
	}

	/**
	 * @param inizio orario di inizio
	 */
	public void setInizio(LocalTime inizio) {
		this.inizio = inizio;
	}

	/**
	 * @return orario di fine
	 */
	public LocalTime getFine() {
		return fine;
	}

	/**
	 * @param fine oriario di fine
	 */
	public void setFine(LocalTime fine) {
		this.fine = fine;
	}

	/**
	 * @return docente coordinatore
	 */
	public Docente getCoordinatore() {
		return coordinatore;
	}

	/**
	 * @param coordinatore docente coordinatore
	 */
	public void setCoordinatore(Docente coordinatore) {
		this.coordinatore = coordinatore;
	}

	/**
	 * @return docente segretario
	 */
	public Docente getSegretario() {
		return segretario;
	}

	/**
	 * @param segretario docente segretario
	 */
	public void setSegretario(Docente segretario) {
		this.segretario = segretario;
	}
	
	/**
	 * aggiunge un docente al consiglio di classe
	 * @param d docente
	 */
	public void aggiungi(Docente d) {
		this.docenti.add(d);
	}
	
	/**
	 * numero di docenti del consiglio
	 * @return numero di docenti
	 */
	public int numeroDocenti() {
		return this.docenti.size() + 2;
	}

	/**
	 * durata del consiglio
	 * @return durata in minuti
	 */
	public int durata() {
		return (int) ChronoUnit.MINUTES.between(inizio,fine);
	}
	
	@Override
	public String toString() {
		String str = "consiglio di " + classe 
		        + " inizio ore " + inizio 
		        + " fine ore " + fine 
				+ " durata " + this.durata() + " minuti"
				+ "\ncoordinatore " + coordinatore 
				+ "\nsegretario " + segretario 
				+ "\ndocenti: \n";
		for (Docente d : docenti) {
		      str += d + "\n";
		    }
		return str;	
	}
	
}
