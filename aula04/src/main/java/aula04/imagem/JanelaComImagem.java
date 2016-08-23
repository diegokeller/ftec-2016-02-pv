package aula04.imagem;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JanelaComImagem extends JFrame {

	public JanelaComImagem() {
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Image fabrica;
		try {
			File arquivo = new File("src/main/resources/fabrica.png");
			fabrica = ImageIO.read(arquivo);
			g.drawImage(fabrica, 50, 50, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
