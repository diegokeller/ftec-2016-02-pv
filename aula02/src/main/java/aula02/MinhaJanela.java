package aula02;

import javax.swing.JFrame;

public class MinhaJanela extends JFrame { // Herança
	// Construtor
	public MinhaJanela(String titulo, Integer altura, Integer largura) {
		this.setSize(altura, largura);
		this.setTitle(titulo);
		this.setLocation(250, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
