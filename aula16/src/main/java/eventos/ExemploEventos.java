package eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTextField;

import comum.JanelaModelo;

public class ExemploEventos extends JanelaModelo {


	public ExemploEventos(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JTextField campoNome = new JTextField("João");
		campoNome.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.getX());
				System.out.println(e.getY());
			}
		});
		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Teclou 2");
			}
		});
		this.add(campoNome);
	}

	public static void main(String[] args) {
		new ExemploEventos("Eventos", 200, 200).setVisible(true);
	}

}
