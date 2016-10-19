package aula09.patrick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroProduto extends JFrame {

	private JTextField campoNome;
	private JTextField campoDescricao;
	private JTextField campoPreco;
	private JTextField campoQuantidade;
	private JButton botaoSalvar;
	private JButton botaoFechar;
	private String[] perfilAcesso;
	final JRadioButton radioSim = new JRadioButton("Sim", true);
	final JRadioButton radioNao = new JRadioButton("Nao");

	public CadastroProduto() {

		this.setSize(600, 500);
		this.setTitle("");
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		 getContentPane().setLayout(new BorderLayout());

		// getContentPane().add(new PainelCabecalho("Cadastro de Produto",
		// Color.WHITE, Color.BLUE, 50, FlowLayout.CENTER),
		// BorderLayout.NORTH);

		criarCamposEBotoes();
	}

	public void criarCamposEBotoes() {

		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints r = new GridBagConstraints();
		r.fill = GridBagConstraints.HORIZONTAL;
		r.weightx = 1;

		r.gridx = 0;
		r.gridy = 0;
		JLabel label = new JLabel("Nome*:");
		painel.add(label, r);

		r.gridx = 1;
		r.gridy = 0;
		campoNome = new JTextField("", 10);
		painel.add(campoNome, r);

		r.gridx = 0;
		r.gridy = 1;
		painel.add(new JLabel("Descricao*:"), r);

		r.gridx = 1;
		r.gridy = 1;
		campoDescricao = new JTextField("teste", 10);
		painel.add(campoDescricao, r);

		getContentPane().add(painel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new CadastroProduto().setVisible(true);;

	}

}
