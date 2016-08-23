package aula04.grid_layout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploTabuleiro extends JFrame {
	
	public ExemploTabuleiro() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setTitle("Tabuleiro");
		
		getContentPane().setLayout(new GridLayout(8, 8));
		
		boolean pintar = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JPanel celula = new JPanel();
				if(pintar){
					celula.setBackground(Color.BLACK);
				}
				pintar = !pintar;
				getContentPane().add(celula);
			}	
			pintar = !pintar;
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExemploTabuleiro();
	}

}
