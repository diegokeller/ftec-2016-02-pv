package aula02;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Janela3 extends JFrame {

	public Janela3() {

		this.setTitle("Minha Janela 3");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// Configure se pode ou não redimensionar a janela
		this.setResizable(false);

		// Trocar a cor de fundo da janela - Cores predefinidas ou
		// personalizadas
		this.getContentPane().setBackground(Color.BLUE);
		this.getContentPane().setBackground(new Color(100, 100, 100));

		// Pega o Toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Ícone da janela
		Image icone = toolkit.getImage("src/main/resources/user.png");
		this.setIconImage(icone);

		// Define a posição da janela em pixels
		this.setLocation(250, 250);

		// OU Centraliza a janela na tela
		this.setLocationRelativeTo(null);

	}

}
