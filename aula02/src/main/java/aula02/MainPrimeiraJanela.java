package aula02;

import javax.swing.JFrame;

public class MainPrimeiraJanela {

	public static void main(String[] args) {
		
		// Cria a janela
		JFrame janela = new JFrame();

		// Define o seu tamanho
		// Altura e largura em pixel
		janela.setSize(400, 450);

		// Define o título da janela
		janela.setTitle("Janela 1 - Bem Vindo!!!");

		// Define a posição da janela na tela
		janela.setLocation(250, 250);

		// Define a ação padrão ao fechar a janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Mostra a janela
		janela.setVisible(true);
	}

}
