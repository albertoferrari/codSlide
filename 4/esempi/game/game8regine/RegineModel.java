/**
 * @author AF
 * dati e gestione operazioni
 * problema 8 regine
 */

public class RegineModel {
	
	/* 
	 * scacchiera di gioco
	 * in ogni cella il valore ha il seguente significato:
	 *  0 vuota
	 *  1 presente regina
	 * -n minacciata da n regine
	 */
	private int[][] scacchiera;

	/**
	 * scacchiera inizializzata con celle vuote
	 */
	public RegineModel() {
		super();
		scacchiera = new int[8][8];
		for (int r=0;r<8;r++) 
			for (int c=0;c<8;c++) 
				scacchiera[r][c] = 0;
	}

	/**
	 * @return scacchiera di gioco
	 */
	public int[][] getScacchiera() {
		return scacchiera;
	}

	/**
	 * inserisce o elimina una regina dalla cella
	 * @param r riga
	 * @param c colonna
	 * @return true se inserimento o eminazione effettuato
	 */
	public boolean inserisciElimina(int r, int c) {
		if (scacchiera[r][c]<0)		// cella sotto minaccia
			return false;
		if (scacchiera[r][c]==0) {	// inserimento regina
			scacchiera[r][c] = 1;
			minacciaRiga(r);
			minacciaColonna(c);
			minacciaDiagonaleNoSe(r-c);
			minacciaDiagonaleSoNe(r+c);
			return true;
		}
		if (scacchiera[r][c]==1) {	// eliminazione regina
			scacchiera[r][c] = 0;
			eliminaMinacciaRiga(r);
			eliminaMinacciaColonna(c);
			eliminaMinacciaDiagonaleNoSe(r-c);
			eliminaMinacciaDiagonaleSoNe(r+c);
			return true;
		}
		return true;
	}

	/**
	 * mette sotto minaccia le caselle di una diagonale NordEst-SudOvest
	 * @param d diagonale
	 */
	private void minacciaDiagonaleSoNe(int d) {
		for (int r=0;r<8;r++)
			if (ammesso(r,d-r))
				if (scacchiera[r][d-r] <= 0)
					scacchiera[r][d-r] -= 1;
	}

	/**
	 * libera da minaccia le caselle di una diagonale NordEst-SudOvest
	 * @param d diagonale
	 */
	private void eliminaMinacciaDiagonaleSoNe(int d) {
		for (int r=0;r<8;r++)
			if (ammesso(r,d-r))
				if (scacchiera[r][d-r] < 0)
					scacchiera[r][d-r] += 1;
	}	
	
	/**
	 * mette sotto minaccia le caselle di una diagonale NordOvest-SudEst
	 * @param d diagonale
	 */
	private void minacciaDiagonaleNoSe(int d) {
		for (int r=0;r<8;r++)
			if (ammesso(r,r-d))
				if (scacchiera[r][r-d] <= 0)
					scacchiera[r][r-d] -= 1;
	}

	/** libera da minaccia le caselle di una diagonale NordOvest-SudEst
	 * @param d diagonale
	 */
	private void eliminaMinacciaDiagonaleNoSe(int d) {
		for (int r=0;r<8;r++)
			if (ammesso(r,r-d))
				if (scacchiera[r][r-d] < 0)
					scacchiera[r][r-d] += 1;
	}	
	
	/**
	 * mette sotto minaccia le caselle di una colonna
	 * @param c colonna
	 */
	private void minacciaColonna(int c) {
		for (int r=0;r<8;r++)
			if (scacchiera[r][c] <= 0)
				scacchiera[r][c] -= 1;
	}
	
	/**
	 * libera da minaccia le caselle di una colonna
	 * @param c colonna
	 */
	private void eliminaMinacciaColonna(int c) {
		for (int r=0;r<8;r++)
			if (scacchiera[r][c] < 0)
				scacchiera[r][c] += 1;
	}	

	/**
	 * mette sotto minaccia le caselle di una riga
	 * @param r riga
	 */
	private void minacciaRiga(int r) {
		for (int c=0;c<8;c++)
			if (scacchiera[r][c] <= 0)
				scacchiera[r][c] -= 1;
	}

	/**
	 * libera da minaccia le caselle di una riga
	 * @param r riga
	 */
	private void eliminaMinacciaRiga(int r) {
		for (int c=0;c<8;c++)
			if (scacchiera[r][c] < 0)
				scacchiera[r][c] += 1;
	}	
	
	/**
	 * controlla se il problema è stato risolto
	 * @return true se le 8 regine sono posizionate correttamente
	 */
	public boolean risolto() {
		for (int r=0;r<8;r++) {
			boolean presente = false;
			for (int c=0;c<8;c++) {
				if (scacchiera[r][c] == 1)
					presente = true;
			}
			if (!presente)
				return false;
		}
		return true;
	}
	
	/**
	 * valori di riga e colonna interni alla scacchiera
	 * @return true se interni
	 */
	private boolean ammesso(int r, int c) {
		if (r>=0 && r<8 && c>=0 && c<8)
			return true;
		return false;
	}
	
}
