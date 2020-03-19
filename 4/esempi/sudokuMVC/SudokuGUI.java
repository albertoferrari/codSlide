import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author AF
 * Sudoku modulo View - interfaccia grafica
 */

@SuppressWarnings("serial")
public class SudokuGUI extends JFrame { 
	
	/** 
	 * un bottone per ogni cella del gioco 
	 *  visibilità package
	 */
	JButton[][] celleSudoku;	
	
	/** 
	 * logica del gioco nella classe Sudoku 
	 */
	private SudokuModel sudoku;

	/** 
	 * associazione del Model e istanziazione della grafica
	 */
	public SudokuGUI() {
		this.sudoku = new SudokuModel(scegliSudoku());
		creaGUI();
	}

	/** 
	 * visualizzazione comunicazione di successo 
	 */
	void risolto() {
		JOptionPane.showMessageDialog(null, "Sudoku risolto complimenti!!!");
	}
	
	/** 
	 * aggiornamento tooltip di tutti i bottoni 
	 */
	void aggiornaTooltip() {
		for (int r = 0; r < 9; r++) {			//righe
			for (int c = 0; c < 9; c++){		//colonne	
				if (!sudoku.isPredefinito(r,c))
					this.celleSudoku[r][c].setToolTipText(sudoku.valoriAmmissibili(r,c).toString());
			}
		}
	}
	
	/**
	 * Scelta del file contenente la matrice di gioco
	 * @return nome del file ("Sudoku01.txt" se nessuna scelta)
	 */
	private String scegliSudoku() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		fc.setCurrentDirectory(new java.io.File("."));
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			return file.getName();
		} 
		return "Sudoku01.txt";		//default
	}	
	
	/**
	 * Creazione dei bottoni con relative proprietà
	 */
	private void creaGUI() {
		int[][] valori = sudoku.stato();
		this.celleSudoku = new JButton[9][9];
		JPanel pannelloCelle = new JPanel();
		pannelloCelle.setLayout(new GridLayout(9,9));
		this.add(pannelloCelle, BorderLayout.CENTER);

		for (int r = 0; r < 9; r++) {			//righe
			for (int c = 0; c < 9; c++){		//colonne
				String testoBottone = "";
				if (valori[r][c]!=0) 
					testoBottone += valori[r][c];
				this.celleSudoku[r][c] = new JButton(testoBottone);
				// il nome servirà per riconoscere la posizione del bottone
				this.celleSudoku[r][c].setName(""+r+c);
				this.celleSudoku[r][c].setHorizontalAlignment(JButton.CENTER);
				this.celleSudoku[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				if (sudoku.isPredefinito(r,c)) {
					this.celleSudoku[r][c].setEnabled(false);
				} else {
					this.celleSudoku[r][c].setEnabled(true);
					this.celleSudoku[r][c].addActionListener(new SudokuController(sudoku,this)); 
				}
				pannelloCelle.add(this.celleSudoku[r][c]);
			}
		}
		if (!sudoku.ammissibile())
			JOptionPane.showMessageDialog(null, "Sudoku non ammissibile");
		if (sudoku.risolto())
			JOptionPane.showMessageDialog(null, "Sudoku già completato");
		aggiornaTooltip();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sudoku");
		setSize(400, 450);
		setVisible(true); 
	}
	
} 
