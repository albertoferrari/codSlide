import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author AF
 * Sudoku
 */
public class Sudoku {
	
	/** matrice di gioco celle vuote valore 0 */
	private int[][] matrice;
	
	/** true per i valori predefiniti e non modificabili */
	private boolean[][] predefiniti;

	/**
	 * legge la matrice con valori predefiniti da un file
	 * @param nomeFile nome del file con estensione
	 */
	public Sudoku(String nomeFile) {
		super();
		matrice = new int[9][9];
		predefiniti = new boolean[9][9];
	    try {
	    	File f = new File(nomeFile);
			Scanner sudokuFile = new Scanner(f);
			int r = 0;
			while (sudokuFile.hasNextLine()) {
		        String[] riga = sudokuFile.nextLine().split(",");
		        for (int c=0; c<9; c++) {
		        	int val = Integer.parseInt(riga[c]);
		        	matrice[r][c] = val;
		        	if (val == 0) 
		        		predefiniti[r][c] = false;
		        	else
		        		predefiniti[r][c] = true;
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
		if (val == 0)
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
	
	/*1 se esiste una soluzione partendo dalla cella cel 
int esisteSoluzione(int cel) {
    if (foundSol)
        return 1;               // gia' trovata altra soluzione
    if (cel==81) {              // soluzione trovata!
        stampaSudoku();
        foundSol = 1;
        return 1;
    }
    if (fix[cel]==1)            // cella con valore prefissato
        return esisteSoluzione(cel+1);
    int val;
    int sol = 0;                // soluzione al momento non trovata
    for (val=1;val<=9;val++) {
        if (possibile(val,cel)) {   // valore accettabile
            grid[cel] = val;        // inserito nella cella
            if (esisteSoluzione(cel+1))
                sol = 1;
        }
    }
    if (!sol) {
       grid[cel] = 0;
       return 0;                // ramo senza soluzioni
    }
    return 1;
}*/

}
