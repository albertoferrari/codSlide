import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RegineController implements ActionListener {

	/* (model) dati su cui operare */
	private RegineModel model;
	/* (view) parte dell'interfaccia */
	private RegineView view;
	
	
	/**
	 * @param model
	 * @param view
	 */
	public RegineController(RegineModel model, RegineView view) {
		super();
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
		
		if (model.inserisciElimina(r,c)) {
			view.aggiornaCelle();
		}	
		
		if (model.risolto()) {
			view.risolto();			//soluzione del gioco
		}
			
	}

}
