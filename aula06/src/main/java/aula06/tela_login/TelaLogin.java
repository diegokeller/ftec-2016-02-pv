package aula06.tela_login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

	private JTextField campoLogin;
	private JTextField campoSenha;
	private JButton botaoEntrar;
	private JButton botaoEsqueciLogin;
	private JButton botaoEsqueciSenha;

	public TelaLogin() {
		setSize(450, 325);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);

		// Não redimensiona a janela
		setResizable(true);

		getContentPane().setLayout(new BorderLayout());

		criarCabecalho();
		criarLogo();
		criarCamposEBotoes();

		setVisible(true);
	}

	private void criarCamposEBotoes() {

		JPanel painel = new JPanel(new GridBagLayout());
		painel.setBackground(Color.WHITE);

		GridBagConstraints r = new GridBagConstraints();
		r.insets = new Insets(5, 5, 5, 5);
		r.gridx = 0;
		r.gridy = 0;
		painel.add(new JLabel("Login*:"), r);

		r.gridx = 0;
		r.gridy = 1;
		painel.add(new JLabel("Senha*:"), r);

		r.gridx = 1;
		r.gridy = 0;
		campoLogin = new JTextField(10);
		painel.add(campoLogin, r);

		r.gridx = 1;
		r.gridy = 1;
		campoSenha = new JPasswordField(10);
		painel.add(campoSenha, r);

		JPanel botoes = new JPanel(new FlowLayout());
		botoes.setBackground(Color.WHITE);
		botaoEntrar = new JButton("Entrar");
		botoes.add(botaoEntrar);
		botaoEsqueciLogin = new JButton("Esqueci meu login");
		botoes.add(botaoEsqueciLogin);
		botaoEsqueciSenha = new JButton("Esqueci minha senha");
		botoes.add(botaoEsqueciSenha);
		
		JPanel painelInferior = new JPanel(new GridLayout(2, 1));
		painelInferior.add(painel);
		painelInferior.add(botoes);

		getContentPane().add(painelInferior, BorderLayout.SOUTH);

	}

	private void criarLogo() {
		// PainelImagem imagem = new PainelImagem(
		// "D:\\Desenvolvimento\\Java\\FTEC\\ftec-2016-02-pv\\aula06\\src\\main\\resources\\logo.png",
		// 130, 10, 150);
		PainelImagemComLabel imagem = new PainelImagemComLabel(
				"D:\\Desenvolvimento\\Java\\FTEC\\ftec-2016-02-pv\\aula06\\src\\main\\resources\\logo.png");
		getContentPane().add(imagem, BorderLayout.CENTER);
	}

	private void criarCabecalho() {
		PainelCabecalho cabecalho = new PainelCabecalho(
				"Sistema de Pedidos", Color.BLACK, null, 22,
				FlowLayout.CENTER);
		getContentPane().add(cabecalho, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new TelaLogin();
	}

}
