import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author AF
 * 8 regine modulo View - interfaccia grafica
 */

@SuppressWarnings("serial")
public class RegineView extends JFrame {
	
	/** 
	 * un bottone per ogni cella del gioco 
	 */
	private JButton[][] celleRegine;
	
	/** 
	 * logica del gioco nella classe RegineModel 
	 */
	private RegineModel regine;
	
	private final String queen = "\u265B";
	private final String empty = "";
	private final String forbidden = "-";
	
	/**
	 * @param regine
	 */
	public RegineView() {
		this.regine = new RegineModel();
		creaGUI();
	}

	/** 
	 * problema risolto 
	 */
	void risolto() {
		JOptionPane.showMessageDialog(null, "8 regine posizionate correttamente complimenti!!!");
	}
	
	void aggiornaCelle() {
		int[][] valori = regine.getScacchiera();
		for (int r = 0; r < 8; r++) {			//righe
			for (int c = 0; c < 8; c++){		//colonne
				if (valori[r][c]==1)
					this.celleRegine[r][c].setText(queen);
				if (valori[r][c]==0)
					this.celleRegine[r][c].setText(empty);
				if (valori[r][c]==-1)
					this.celleRegine[r][c].setText(forbidden);
			}				
		}	
		repaint();
	}
	
	/**
	 * Creazione dei bottoni con relative proprietà
	 */
	private void creaGUI() {
		this.celleRegine = new JButton[8][8];
		JPanel pannelloCelle = new JPanel();
		pannelloCelle.setLayout(new GridLayout(8,8));
		this.add(pannelloCelle, BorderLayout.CENTER);

		for (int r = 0; r < 8; r++) {			//righe
			for (int c = 0; c < 8; c++){		//colonne
				this.celleRegine[r][c] = new JButton(empty);
				this.celleRegine[r][c].setName(""+r+c);
				this.celleRegine[r][c].setHorizontalAlignment(JButton.CENTER);
				this.celleRegine[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.celleRegine[r][c].setEnabled(true);
				this.celleRegine[r][c].addActionListener(new RegineController(regine,this)); 
				pannelloCelle.add(this.celleRegine[r][c]);
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("8 regine");
		setSize(400, 450);
		setVisible(true); 
	}
		
}

