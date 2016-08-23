package aula04.componentes_flow_layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaExemploComponentes extends JFrame {

	public JanelaExemploComponentes() {
		
		inicializarTela();

		// Define o gerenciador de layout
		// Desnecessário, o padrão é FlowLayout
		setLayout(new FlowLayout());
		
		criarCamposPrincipais();

		setVisible(true);
	}

	private void criarCamposPrincipais() {
		// Cria um rótulo
		JLabel labelEmail = new JLabel("E-mail");
		
		// Cria um campo de texto
		// Valor do campo e largura
		JTextField campoEmail = new JTextField("Digite seu e-mail", 20);
		
		// Cria um botão
		JButton botaoOk = new JButton("OK");
		
		// Adiciona os componentes na tela
		this.getContentPane().add(labelEmail);
		this.getContentPane().add(campoEmail);
		this.getContentPane().add(botaoOk);
	}

	private void inicializarTela() {
		// Cria a janela
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Exemplos de componentes");
	}
	
}
