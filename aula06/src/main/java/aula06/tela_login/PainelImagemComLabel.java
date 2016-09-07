package aula06.tela_login;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelImagemComLabel extends JPanel {

	public PainelImagemComLabel(String caminhoImagem) {
		super();

		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		ImageIcon icone = new ImageIcon(caminhoImagem);
		JLabel imagem = new JLabel(icone, JLabel.CENTER);
		add(imagem);
	}

}
