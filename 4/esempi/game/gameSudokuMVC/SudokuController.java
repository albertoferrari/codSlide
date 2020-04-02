import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @author AF
 * Sudoku modulo Controller - gestione interazione View e Model
 *
 */
public class SudokuController implements ActionListener {

	/* (model) dati su cui operare */
	private SudokuModel model;
	/* (view) parte dell'interfaccia */
	private SudokuView view;	
	
	/**
	 * @param model dati e logica di gioco
	 * @param view interfaccia grafica
	 */
	public SudokuController(SudokuModel model, SudokuView view) {
		this.model = model;
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		// * posizione cella (recupero informazione del nome del bottone) *
		int coord = Integer.parseInt(b.getName());
		int r = coord / 10;
		int c = coord % 10;
		// ****************************************************************
		
		// ********** scelta fra uno dei valori ammissibili ***************
		int nVal = model.valoriAmmissibili(r,c).size();
		String[] selezione = new String[nVal+1];
		for (int i=0; i<nVal; i++)
			selezione[i] = model.valoriAmmissibili(r,c).get(i).toString();
		selezione[nVal] = "elimina";
		Object sNewVal = JOptionPane.showInputDialog(null,
		"valori ammissibili", "Inserimento",
		JOptionPane.INFORMATION_MESSAGE, null,
		selezione, selezione[0]);
		// ****************************************************************
		
		if (sNewVal == null) 
			return;
		try {
			int newVal = Integer.parseInt((String)(sNewVal));
			// scelta di un nuovo valore per la cella
			model.inserisci(r,c,newVal);
			b.setText((String)sNewVal);
		} catch (Exception exc) {
			// scelta di cancellare il contenuto della cella
			model.inserisci(r,c,0);
			b.setText("");
		} 
		
		// aggiornamento informazioni tooltip
		view.aggiornaTooltip();
		
		if (model.risolto()) {
			view.risolto();			//soluzione del sudoku
		}
			
	}


}
