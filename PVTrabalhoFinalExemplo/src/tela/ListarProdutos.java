package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import modelo.Produto;
import negocio.ProdutoNegocio;
import excecoes.ErroDeNegocioException;

public class ListarProdutos extends JFrame {

	/*
	 * ========================================================================
	 * Atributos
	 * ========================================================================
	 */

	private static final long serialVersionUID = 1L;
	
	private JTextField campoNome;
	private JRadioButton opcaoSim;
	private JRadioButton opcaoNao;
	private JRadioButton opcaoTodos;
	private String[] colunas = new String[] { "Nome", "Preço", "Estoque", "Ativo" };
	private JTable tabela;
	private JPanel painelTabela;
	private JLabel labelContador;
	private List<Produto> produtos;

	/*
	 * ========================================================================
	 * Construtor
	 * ========================================================================
	 */

	public ListarProdutos() {

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cadastro de Produtos");
		setResizable(false);

		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		add(painelCabecalho(), BorderLayout.NORTH);
		add(painelPesquisa(), BorderLayout.CENTER);
		
		acaoPesquisar();

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

		JLabel titulo = new JLabel("Produtos");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		painel.add(titulo);

		return painel;

	}

	private JPanel painelPesquisa() {

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());

		painel.add(painelPesquisaCampos(), BorderLayout.NORTH);
		painel.add(painelPesquisaResultado(), BorderLayout.CENTER);

		return painel;

	}

	private JPanel painelPesquisaCampos() {

		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout(FlowLayout.LEFT));

		painel.add(new JLabel("Nome:"));
		campoNome = new JTextField(10);
		painel.add(campoNome);

		painel.add(new JLabel("Disponível em estoque:"));
		opcaoSim = new JRadioButton("Sim");
		opcaoNao = new JRadioButton("Não");
		opcaoTodos = new JRadioButton("Todos");
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(opcaoSim);
		grupo.add(opcaoNao);
		grupo.add(opcaoTodos);
		painel.add(opcaoSim);
		painel.add(opcaoNao);
		painel.add(opcaoTodos);

		return painel;

	}

	private JPanel painelPesquisaResultado() {

		JPanel painel = new JPanel();

		painel.setLayout(new BorderLayout());

		painel.add(painelPesquisaResultadoBotoes(), BorderLayout.NORTH);
		painel.add(painelPesquisaResultadoGrid(), BorderLayout.CENTER);
		painel.add(painelPesquisaResultadoContador(), BorderLayout.SOUTH);

		return painel;

	}

	private JPanel painelPesquisaResultadoBotoes() {

		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acaoPesquisar();
			}

		});
		painel.add(botaoPesquisar);

		JButton botaoDetalhes = new JButton("Detalhes");
		botaoDetalhes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				acaoDetalhes();
			}
		});
		painel.add(botaoDetalhes);

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

	private JPanel painelPesquisaResultadoGrid() {

		painelTabela = new JPanel();

		tabela = new JTable();
		painelTabela.add(tabela);

		return painelTabela;

	}

	private JPanel painelPesquisaResultadoContador() {
		
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelContador = new JLabel();
		painel.add(labelContador);
		return painel;
		
	}

	/*
	 * ========================================================================
	 * Ações
	 * ========================================================================
	 */

	private void acaoPesquisar() {

		// Pega os valores dos campos
		String nome = campoNome.getText();
		Boolean emEstoque = null;
		if (opcaoSim.isSelected()) {
			emEstoque = Boolean.TRUE;
		}
		if (opcaoNao.isSelected()) {
			emEstoque = Boolean.FALSE;
		}

		try {

			produtos = new ProdutoNegocio().buscar(nome, emEstoque);

			// Limpa o painel
			painelTabela.removeAll();

			// Cria tabela
			Object[][] dados = converterVetorObjetos(produtos);
			tabela = new JTable(dados, colunas);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabela.setPreferredScrollableViewportSize(new Dimension(450, 300));
			tabela.setFillsViewportHeight(false);

			// Cria scroll
			JScrollPane scroll = new JScrollPane(tabela);
			
			// Adiciona tabela no painel
			painelTabela.add(scroll);
			
			// Atualiza o contador
			labelContador.setText(produtos.size() + " registros encontrados.");

			// Atualiza a tela
			this.validate();

		} catch (ErroDeNegocioException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private Object[][] converterVetorObjetos(List<Produto> produtos) {
		
		// Número de colunas
		int colunas = 4;
		
		// Número de linhas
		int linhas = produtos.size();
		
		// Vetor de dados
		Object[][] dados = new Object[linhas][colunas];
		
		// Percorre os registros
		for (int i = 0; i < dados.length; i++) {
			
			// Pega o produto
			Produto p = produtos.get(i);
			
			// Nome
			dados[i][0] = p.getNome();
			
			// Preço
			dados[i][1] = p.getPreco();
			
			// Em estoque
			String emEstoque = "";
			if (p.getEmEstoque()) {
				emEstoque = "Sim";
			} else {
				emEstoque = "Não";
			}
			dados[i][2] = emEstoque;
			
			// Ativo
			String ativo = "";
			if (p.getAtivo()) {
				ativo = "Sim";
			} else {
				ativo = "Não";
			}
			dados[i][3] = ativo;
		}

		return dados;
	}

	private void acaoDetalhes(){
		
		// Pega a linha selecionada
		int linha = tabela.getSelectedRow();
		if(linha < 0){
			JOptionPane.showMessageDialog(this, "Selecione um regitro para ver os detalhes");
			return;
		}
		
		// Pega o produto
		Produto p = produtos.get(linha);
		
		// Cria a tela 
		EditarProduto editarProduto = new EditarProduto();
		editarProduto.acaoPreencher(p);
		editarProduto.acaoDesabilitarCampos();
		editarProduto.setVisible(true);
		
	}
	
	private void acaoFechar() {
		this.dispose();
	}
}
