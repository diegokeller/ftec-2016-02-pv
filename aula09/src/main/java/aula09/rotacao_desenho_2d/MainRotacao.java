package aula09.rotacao_desenho_2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;

public class MainRotacao extends JFrame {
	
	private Integer graus = 0;
	private JFrame janela = this;

	public MainRotacao() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Rotação de objetos");
		
		Thread rotacionar = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					graus += 3;
					janela.repaint();
				}
			}
		});
		rotacionar.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		Rectangle rect1 = new Rectangle(200, 200, 50, 50);
		g2d.setColor(Color.BLUE);
		g2d.draw(rect1);

		Shape rect2 = rotacionarForma(rect1, graus, 225, 225);
		g2d.setColor(Color.RED);
		g2d.fill(rect2);
		
	}

	public static Shape rotacionarForma(final Shape base,
			final double angle, final float ancoraRotacaoX,
			final float ancoraRotacaoY) {
		if (base == null) {
			return null;
		}
		final AffineTransform rotate = AffineTransform
				.getRotateInstance((angle * Math.PI) / 180, ancoraRotacaoX,
						ancoraRotacaoY);
		final Shape result = rotate.createTransformedShape(base);
		return result;
	}

	public static void main(String[] args) {
		new MainRotacao().setVisible(true);
	}
}
