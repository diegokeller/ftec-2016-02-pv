package aula05.sem_layout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ExemploSemLayout extends JFrame {

	public ExemploSemLayout() {
		setSize(400, 400);
		setTitle("Exemplo sem layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define o gerenciador de layout NULL
		// Sem layout
		getContentPane().setLayout(null);

		JTextField nome = new JTextField();
		nome.setBounds(50, 50, 100, 75); // Define posição e tamanho
		getContentPane().add(nome);

		setVisible(true);
	}

	public static void main(String[] args) {
		new ExemploSemLayout();
	}

}
