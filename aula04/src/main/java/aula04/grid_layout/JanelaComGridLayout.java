package aula04.grid_layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaComGridLayout extends JFrame {

	public JanelaComGridLayout() {
		setSize(400,400);
		setTitle("Exemplo com Grid Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Define o gerenciador de layout
		getContentPane().setLayout(new GridLayout(2, 2));
		
		// Cria os componentes
		JLabel labelEmail = new JLabel("E-mail");
		JTextField campoEmail = new JTextField("", 10);
		JButton botao = new JButton("OK");
		
		// Adiciona
		getContentPane().add(labelEmail);
		getContentPane().add(campoEmail);
		getContentPane().add(botao);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JanelaComGridLayout();
	}
	
}
