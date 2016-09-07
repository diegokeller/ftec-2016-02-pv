package aula06.tela_login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Componente de Painel para exibir uma imagem qualquer.
 */
public class PainelImagem extends JPanel {

	private String caminhoImagem;
	private Integer posicaoX;
	private Integer posicaoY;
	private Integer largura;

	public PainelImagem(String caminhoImagem, Integer posicaoX,
			Integer posicaoY, Integer largura) {
		super();
		this.caminhoImagem = caminhoImagem;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.largura = largura;
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Image imagem;
		try {
			File arquivo = new File(caminhoImagem);
			imagem = ImageIO.read(arquivo);
			Image imagemAlterada = imagem.getScaledInstance(
					largura, -1, Image.SCALE_SMOOTH);
			g.drawImage(
					imagemAlterada,
					posicaoX, posicaoY, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
