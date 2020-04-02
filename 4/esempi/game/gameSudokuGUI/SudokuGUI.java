import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author AF
 * interfaccia grafica per Sudoku
 */

@SuppressWarnings("serial")
public class SudokuGUI extends JFrame implements ActionListener { 
	/** un bottone per ogni cella del gioco */
	private JButton[][] celleSudoku;		
	/** logica del gioco nella classe Sudoku */
	private Sudoku sudoku;

	public SudokuGUI() {
		this.sudoku = new Sudoku(scegliSudoku());
		creaGUI();
	}
  
	/**
	 * Scelta del file contenente la matrice di gioco
	 * @return nome del file ("Sudoku01.txt" se nessuna scelta)
	 */
	private String scegliSudoku() {
		JFileChooser fc = new JFileChooser();
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
				this.celleSudoku[r][c].setName(""+r+c);
				this.celleSudoku[r][c].setHorizontalAlignment(JButton.CENTER);
				this.celleSudoku[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				if (sudoku.isPredefinito(r,c)) {
					this.celleSudoku[r][c].setEnabled(false);
				} else {
					this.celleSudoku[r][c].setEnabled(true);
					this.celleSudoku[r][c].setToolTipText(sudoku.valoriAmmissibili(r,c).toString());
					this.celleSudoku[r][c].addActionListener(this); 
				}
				pannelloCelle.add(this.celleSudoku[r][c]);
			}
		}
		if (!sudoku.ammissibile())
			JOptionPane.showMessageDialog(null, "Sudoku non ammissibile");
		if (sudoku.risolto())
			JOptionPane.showMessageDialog(null, "Sudoku già completato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sudoku");
		setSize(400, 450);
		setVisible(true); 
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		// posizione cella
		int coord = Integer.parseInt(b.getName());
		int r = coord / 10;
		int c = coord % 10;
		
		// scelta fra uno dei valori ammissibili
		int nVal = sudoku.valoriAmmissibili(r,c).size();
		String[] selezione = new String[nVal+1];
		for (int i=0; i<nVal; i++)
			selezione[i] = sudoku.valoriAmmissibili(r,c).get(i).toString();
		selezione[nVal] = "elimina";
		Object sNewVal = JOptionPane.showInputDialog(null,
		"valori ammissibili", "Inserimento",
		JOptionPane.INFORMATION_MESSAGE, null,
		selezione, selezione[0]);
		if (sNewVal == null) 
			return;
		try {
			int newVal = Integer.parseInt((String)(sNewVal));
			sudoku.inserisci(r,c,newVal);
			b.setText((String)sNewVal);
		} catch (Exception exc) {
			sudoku.inserisci(r,c,0);
			b.setText("");
		} 
		// Aggiornamento tooltip di tutti i bottoni non predefiniti
		for (int rr=0; rr<9; rr++)
			for (int cc=0; cc<9; cc++)
				if (!sudoku.isPredefinito(rr,cc))
					celleSudoku[rr][cc].setToolTipText(sudoku.valoriAmmissibili(rr,cc).toString());

		if (sudoku.risolto())
			JOptionPane.showMessageDialog(null, "Sudoku risolto complimenti!!!");

	}

} 
