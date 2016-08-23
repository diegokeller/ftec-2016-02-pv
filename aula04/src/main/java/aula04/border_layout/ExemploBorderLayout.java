package aula04.border_layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExemploBorderLayout extends JFrame {

	public ExemploBorderLayout() {
		
		setSize(400, 400);
		setTitle("Exemplo com Border Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define o gerenciador de layout
		getContentPane().setLayout(new BorderLayout());

		// Cria os componentes
		JLabel labelEmail = new JLabel("E-mail");
		JTextField campoEmail = new JTextField("", 10);
		JButton botao = new JButton("OK");

		// Adiciona
		getContentPane().add(labelEmail, BorderLayout.NORTH);
		getContentPane().add(campoEmail, BorderLayout.CENTER);
		getContentPane().add(botao, BorderLayout.SOUTH);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExemploBorderLayout();
	}

}
