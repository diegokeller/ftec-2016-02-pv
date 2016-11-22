package scroll;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import comum.JanelaModelo;

public class ExemploScroll extends JanelaModelo {


	public ExemploScroll(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(1, 2));
		this.add(conteudo);

		JTextArea campo1 = new JTextArea();
		campo1.setBorder(BorderFactory.createRaisedBevelBorder());
		conteudo.add(campo1);

		JTextArea campo2 = new JTextArea();
		campo1.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane scroll = new  JScrollPane(campo2);
		conteudo.add(scroll);
	}

	public static void main(String[] args) {
		new ExemploScroll("Scroll", 300, 500).setVisible(true);
	}

}
