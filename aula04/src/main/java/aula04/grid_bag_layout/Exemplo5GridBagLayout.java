package aula04.grid_bag_layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exemplo5GridBagLayout extends JFrame {
	
	public Exemplo5GridBagLayout() {
		setSize(400, 400);
		setTitle("Exemplo 5 Grid Bag");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Define o gerenciador de layout
		getContentPane().setLayout(new GridBagLayout());

		// Cria os componentes
		JLabel labelEmail = new JLabel("E-mail");
		JTextField campoEmail = new JTextField("", 10);
		JButton botao = new JButton("OK");

		// Adiciona
		GridBagConstraints r = new GridBagConstraints();
		r.gridx = 0;
		r.gridy = 0;
		getContentPane().add(labelEmail, r);
		
		r.gridx = 0;
		r.gridy = 1;
		r.insets = new Insets(50, 5, 5, 5);
		getContentPane().add(campoEmail, r);
		
		r.gridx = 1;
		r.gridy = 1;
		r.insets = new Insets(5, 30, 5, 5);
		getContentPane().add(botao, r);

		setVisible(true);
	}
	public static void main(String[] args) {
		new Exemplo5GridBagLayout();
	}
}
