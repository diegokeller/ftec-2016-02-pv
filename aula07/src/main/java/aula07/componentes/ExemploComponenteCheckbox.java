package aula07.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class ExemploComponenteCheckbox extends JFrame {

	// Declaração das opções
	private JCheckBox opcaoAzul;
	private JCheckBox opcaoVermelho;
	private JCheckBox opcaoAmarelo;

	public ExemploComponenteCheckbox() {
		setTitle("Exemple de componentes: Checkbox");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

		// Cria e adiciona as opções
		Box campos = Box.createVerticalBox();

		opcaoAzul = new JCheckBox("Azul");
		opcaoAzul.setBackground(null);
		opcaoAzul.setActionCommand("BLUE");
		opcaoAzul.setMnemonic(KeyEvent.VK_A);
		opcaoAzul.addActionListener(new AcaoTrocarCorDeFundo(this));
		campos.add(opcaoAzul);

		opcaoVermelho = new JCheckBox("Vermelha", true);
		opcaoVermelho.setBackground(null);
		opcaoVermelho.setActionCommand("RED");
		opcaoVermelho.setMnemonic(KeyEvent.VK_V);
		opcaoVermelho
				.addActionListener(new AcaoTrocarCorDeFundo(this));
		campos.add(opcaoVermelho);

		opcaoAmarelo = new JCheckBox("Amarela");
		opcaoAmarelo.setBackground(null);
		opcaoAmarelo.setEnabled(false);
		opcaoAmarelo.setActionCommand("YELLOW");
		opcaoAmarelo.setMnemonic(KeyEvent.VK_M);
		opcaoAmarelo
				.addActionListener(new AcaoTrocarCorDeFundo(this));
		opcaoAmarelo.setSelected(true);
		campos.add(opcaoAmarelo);

		// Vetor de opções
		JCheckBox[] vetorDeOpcoes = new JCheckBox[] { opcaoAmarelo,
				opcaoAzul, opcaoVermelho };

		// Botões
		Box botoes = Box.createVerticalBox();
		JButton todos = new JButton("Todos");
		todos.addActionListener(e -> {
			for (JCheckBox campo : vetorDeOpcoes) {
				campo.setSelected(true);
			}
		});
		botoes.add(todos);
		JButton nenhum = new JButton("Nenhum");
		nenhum.addActionListener(e -> {
			for (JCheckBox campo : vetorDeOpcoes) {
				campo.setSelected(false);
			}
		});
		botoes.add(nenhum);
		JButton inveter = new JButton("Inverter");
		inveter.addActionListener(e -> {
			for (JCheckBox campo : vetorDeOpcoes) {
				campo.setSelected(!campo.isSelected());
			}
		});
		botoes.add(inveter);

		// Layout em grid, 1 linha, 2 colunas
		getContentPane().setLayout(new GridLayout(1, 2));
		getContentPane().add(campos);
		getContentPane().add(botoes);
	}

	public static void main(String[] args) {
		new ExemploComponenteCheckbox().setVisible(true);
	}

}
