package aula04.box_layout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaBoxLayout extends JFrame {
	
	public JanelaBoxLayout() {
		
		setTitle("Gerenciador de Layout - Box Layout");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Cria um painel - Pode ser horizontal ou vertical
		Box painelConteudo = Box.createHorizontalBox();

		// Adicona alguns botões
		JButton salvar = new JButton("Salvar");
		painelConteudo.add(salvar);

		JButton excluir = new JButton("Excluir");
		painelConteudo.add(excluir);

		JButton voltar = new JButton("Voltar");
		painelConteudo.add(voltar);

		// Adiciona o painel de conteúdo
		getContentPane().add(painelConteudo);

		// Mostra a janela
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JanelaBoxLayout();
	}

}
