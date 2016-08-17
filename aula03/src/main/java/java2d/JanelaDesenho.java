package java2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class JanelaDesenho extends JFrame {

	public JanelaDesenho() {
		setSize(500, 500);
		setTitle("Desenhando com Java 2D");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Cor do objeto a ser desenhado
		g.setColor(Color.BLUE);

		// Quadrado Preenchido
		// posição x e y, altura, e largura)
		g.fillRect(30, 30, 50, 50);

		// Quadrado vazado
		g.setColor(Color.RED);
		g.drawRect(40, 40, 50, 50);

		///////////

		// Círculo Vazado
		g.setColor(new Color(150, 50, 75));
		g.drawOval(130, 30, 50, 50);

		// Círculo PReenchido
		g.fillOval(135, 50, 50, 70);

		// Retângulo 3D
		g.setColor(Color.WHITE);
		g.fill3DRect(230, 40, 100, 100, true);

		////////

		// Retangulos aredondados
		// x, y, largura, altura, largura do arco, altura do arco
		g.drawRoundRect(30, 150, 80, 40, 30, 50);
		g.fillRoundRect(35, 155, 80, 40, 30, 50);

		// Arcos
		g.setColor(Color.darkGray);
		// x, y, largura, altura, angulo inicial, arco angulo
		g.drawArc(150, 150, 80, 40, 90, 270);
		g.fillArc(160, 160, 80, 40, 90, 270);

		///////////////

		// Poligonos
		g.setColor(Color.MAGENTA);
		int ValoresX[] = { 370, 450, 410 };
		int ValoresY[] = { 80, 80, 140 };
		g.drawPolygon(ValoresX, ValoresY, 3);

		int ValoresX2[] = { 370, 450, 410 };
		int ValoresY2[] = { 160, 160, 80 };
		g.fillPolygon(ValoresX2, ValoresY2, 3);

		//////

		// Linhas
		g.setColor(Color.BLACK);
		g.drawLine(0, 250, 250, 250);

		// Textos
		g.setColor(Color.CYAN);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("Isso é um texto", 10, 250);
	}

}
