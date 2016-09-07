package aula06.tela_login;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Herda de JPanel, é como se fosse uma DIV do HTML
 */
public class PainelCabecalho extends JPanel {

	private String texto;
	private Color corDoTexto;
	private Color corDeFundo;
	private Integer tamanhoTexto;
	private Integer alinhamento;

	public PainelCabecalho(String texto, Color corDoTexto,
			Color corDeFundo, Integer tamanhoTexto,
			Integer alinhamento) {
		super();
		this.texto = texto;
		this.corDoTexto = corDoTexto;
		this.corDeFundo = corDeFundo;
		this.tamanhoTexto = tamanhoTexto;
		this.alinhamento = alinhamento;
		desenhar();
	}
	
	private void desenhar(){
		
		// Define o gerenciador de layout com o alinhamento
		setLayout(new FlowLayout(alinhamento));
		
		// Cria o texto
		JLabel labelTexto = new JLabel(texto);
		labelTexto.setFont(new Font("Arial", Font.BOLD, tamanhoTexto));
		labelTexto.setForeground(corDoTexto);
		add(labelTexto);
		
		// Cor de fundo
		setBackground(corDeFundo);
	}
	
}
