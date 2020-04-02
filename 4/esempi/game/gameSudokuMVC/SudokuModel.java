import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author AF
 * Sudoku modulo Model - contiene i dati e la logica del gioco
 */
public class SudokuModel {
	
	/** matrice di gioco celle vuote valore 0 */
	private int[][] matrice;
	
	/** true per i valori predefiniti e non modificabili */
	private boolean[][] predefiniti;

	/**
	 * legge la matrice con valori predefiniti da un file
	 * @param nomeFile nome del file con estensione
	 */
	public SudokuModel(String nomeFile) {
		super();
		matrice = new int[9][9];
		predefiniti = new boolean[9][9];
	    // lettura del file e caricamento in memoria dei dati
		try {
	    	File f = new File(nomeFile);
			Scanner sudokuFile = new Scanner(f);
			int r = 0;		// in realtà sappiamo che ci saranno 9 righe
			while (sudokuFile.hasNextLine()) {
		        // scomposizione dei singoli valori
				String[] riga = sudokuFile.nextLine().split(",");
		        for (int c=0; c<9; c++) {
		        	int val = Integer.parseInt(riga[c]);
		        	matrice[r][c] = val;			// valori in matrice
		        	if (val == 0) 
		        		predefiniti[r][c] = false;	
		        	else
		        		predefiniti[r][c] = true;	// valore predefinito
		        }
		        r++;
		     }
			sudokuFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * controlla il valore di una cella
	 * @param rc 	riga [0,9]
	 * @param cc 	colonna [0,9]
	 * @param val	valore cella
	 * @return		true se la cella ha un valore ammissibile
	 */
	public boolean corretto(int rc, int cc, int val) {    
		if (val == 0)		// non controllo celle vuote
			return true;
	    int regc = 3 * (rc/3) + (cc/3);	// regione della cella analizzata
	    for (int r=0;r<9;r++) {
	    	for (int c=0;c<9;c++) {
	    		// se la cella è diversa da quella da analizzare e il valore è uguale
	    		if ((r!=rc || c!=cc) && matrice[r][c]==val) {
	    			int reg = 3 * (r/3) + (c/3);	// regione
	    			if (rc == r || cc == c || regc == reg)
	    				return false;
	    		}
	    	}
	    }
	    return true;
	}	
	
	/**
	 * controlla se la matrice attuale è ammissibile
	 * @return true se matrice ammissibile
	 */
	public boolean ammissibile() {
		for (int r=0; r<9; r++)
			for (int c=0; c<9; c++)
				if (!corretto(r,c,matrice[r][c]))
					return false;
		return true;
	}
	
	/**
	 * controlla se il sudoku è stato risolto
	 * @return true se gioco risolto
	 */
	public boolean risolto() {
		for (int r=0; r<9; r++)
			for (int c=0; c<9; c++)
				if ( (matrice[r][c] == 0) || (!corretto(r,c,matrice[r][c]) ) )
					return false;
		return true;
	}	
	
	/**
	 * Se l'inserimento rispetta i vincoli modifica il valore di una cella
	 * @param r	riga
	 * @param c colonna
	 * @param v valore
	 * @return true se corretto
	 */
	public boolean inserisci(int r, int c, int v) {
		if (this.predefiniti[r][c])
			return false;
		if (corretto(r,c,v)) {
			this.matrice[r][c] = v;
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina, se possibile, il contenuto di una cella
	 * @param r	riga
	 * @param c colonna
	 * @return true se è possibile eliminare il contenuto della cella
	 */
	public boolean elimina(int r, int c) {
		if (this.predefiniti[r][c]) 
			return false;
		this.matrice[r][c]=0;
		return true;
	}
	
	/**
	 * situazione attuale
	 * @return matrice di gioco
	 */
	public int[][] stato() {
		return this.matrice;
	}
	
	/**
	 * controllo cella senza valore
	 * @param r riga
	 * @param c colonna
	 * @return true se cella vuota
	 */
	public boolean vuota(int r, int c) {
		return matrice[r][c] == 0;
	}

	/**
	 * Verifica se una cella ha un valore predefinito quindi immutabile
	 * @param r indice di riga
	 * @param c indice di colonna
	 * @return true se cella r c ha valore predefinito
	 */
	public boolean isPredefinito(int r, int c) {
		return this.predefiniti[r][c];
	}
	
	/**
	 * Valori ammissibili per una cella
	 * @param r riga
	 * @param c colonna
	 * @return lista ammissibili
	 */
	public ArrayList<Integer> valoriAmmissibili(int r, int c) {
		ArrayList<Integer> ammissibili = new ArrayList<Integer>();
		for (int v=1;v<=9;v++) {
			if (this.corretto(r,c,v)) {
				ammissibili.add(v);
			}
		}
		return ammissibili;
	}

}
