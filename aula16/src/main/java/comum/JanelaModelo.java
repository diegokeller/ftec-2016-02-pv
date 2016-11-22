package comum;

import javax.swing.JFrame;

public abstract class JanelaModelo extends JFrame {
	
	public JanelaModelo(String titulo, int altura, int largura) {
		setTitle(titulo);
		setSize(largura, altura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
