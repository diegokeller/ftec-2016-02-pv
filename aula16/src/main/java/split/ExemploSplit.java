package split;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import comum.JanelaModelo;

public class ExemploSplit extends JanelaModelo {


	public ExemploSplit(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JTextArea campo1 = new JTextArea("TESTE");
		campo1.setBorder(BorderFactory.createRaisedBevelBorder());

		JTextArea campo2 = new JTextArea("TESTE 2");
		campo1.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane scroll = new  JScrollPane(campo2);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, campo1, scroll);
		this.add(split);
	}

	public static void main(String[] args) {
		new ExemploSplit("Scroll", 300, 500).setVisible(true);
	}

}
