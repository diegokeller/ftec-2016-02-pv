package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Produto;

public class EditarProduto extends JFrame {

	/*
	 * ========================================================================
	 * Atributos
	 * ========================================================================
	 */

	private static final long serialVersionUID = 1L;
	
	private JTextField campoNome;
	private JTextArea campoDescricao;
	private JTextField campoPreco;
	private JTextField campoQuantidadeEstoque;
	private JRadioButton opcaoSim;
	private JRadioButton opcaoNao;

	/*
	 * ========================================================================
	 * Construtor
	 * ========================================================================
	 */

	public EditarProduto() {

		setSize(450, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cadastro de Produtos");
		setResizable(false);

		setLocationRelativeTo(null);

		setLayout(new BorderLayout());
		add(painelCabecalho(), BorderLayout.NORTH);
		add(painelFormulario(), BorderLayout.CENTER);
		add(painelBotoes(), BorderLayout.SOUTH);

	}

	/*
	 * ========================================================================
	 * Painéis
	 * ========================================================================
	 */

	private JPanel painelCabecalho() {

		JPanel painel = new JPanel();
		painel.setBackground(Util.COR_FUNDO);
		painel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel titulo = new JLabel("Cadastro de Produto");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		painel.add(titulo);

		return painel;

	}

	private JPanel painelFormulario() {

		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5, 5, 5, 5);

		c.gridx = 0;
		c.gridy = 0;
		painel.add(new JLabel("Nome:"), c);
		campoNome = new JTextField(20);
		c.gridx = 1;
		c.gridy = 0;
		painel.add(campoNome, c);

		c.gridx = 0;
		c.gridy = 1;
		painel.add(new JLabel("Descrição:"), c);
		campoDescricao = new JTextArea(5, 20);
		c.gridx = 1;
		c.gridy = 1;
		painel.add(new JScrollPane(campoDescricao), c);

		c.gridx = 0;
		c.gridy = 2;
		painel.add(new JLabel("Preço:"), c);
		campoPreco = new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		painel.add(campoPreco, c);

		c.gridx = 0;
		c.gridy = 4;
		painel.add(new JLabel("Quantidade em estoque:"), c);
		campoQuantidadeEstoque = new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		painel.add(campoQuantidadeEstoque, c);

		c.gridx = 0;
		c.gridy = 5;
		painel.add(new JLabel("Ativo:"), c);
		opcaoSim = new JRadioButton("Sim");
		opcaoNao = new JRadioButton("Não");
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(opcaoSim);
		grupo.add(opcaoNao);
		JPanel opcoesAtivo = new JPanel();
		opcoesAtivo.add(opcaoSim);
		opcoesAtivo.add(opcaoNao);
		c.gridx = 1;
		c.gridy = 5;
		painel.add(opcoesAtivo, c);

		return painel;

	}

	private JPanel painelBotoes() {

		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton botaoFechar = new JButton("Fechar");
		botaoFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acaoFechar();
			}

		});
		painel.add(botaoFechar);

		return painel;

	}

	/*
	 * ========================================================================
	 * Ações
	 * ========================================================================
	 */

	public void acaoFechar() {
		this.dispose();
	}

	public void acaoPreencher(Produto p) {
		campoNome.setText(p.getNome());
		campoDescricao.setText(p.getDescricao());
		campoPreco.setText(Float.toString(p.getPreco()));
		campoQuantidadeEstoque.setText(Integer.toString(p.getQuantidadeEstoque()));
		if (p.getAtivo()) {
			opcaoSim.setSelected(true);
		} else {
			opcaoNao.setSelected(true);
		}
	}

	public void acaoDesabilitarCampos() {
		campoNome.setEnabled(false);
		campoDescricao.setEnabled(false);
		campoPreco.setEnabled(false);
		campoQuantidadeEstoque.setEnabled(false);
		opcaoSim.setEnabled(false);
		opcaoNao.setEnabled(false);
	}

}
