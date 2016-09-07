package aula06.corrida;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CorridaCarro extends JFrame {

	private JFrame self = this;

	private List<Carro> carros = new LinkedList<>();
	
	private Carro meuCarro = new Carro("");

	public CorridaCarro() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 600);
		setTitle("Jogo");

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					
					for (Carro carro : carros) {
						carro.deslocar();
					}
					
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					self.repaint();
				}

			}
		});
		t.start();

		Thread tCarros = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Carro novo = new Carro("src/main/resources/carro.png");
					carros.add(novo);
					
					List<Carro> remover = new LinkedList<>();
					for (Carro carro : carros) {
						if(carro.getPosicaoY() >= 700){
							remover.add(carro);
						}
					}
					carros.removeAll(remover);
				}

			}
		});
		tCarros.start();
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				meuCarro.setPosicaoX(e.getX());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Image imagem;
		try {
			File arquivo = new File("src/main/resources/carro.png");
			imagem = ImageIO.read(arquivo);
			
			for (Carro carro : carros) {
				g.drawImage(imagem, carro.getPosicaoX(), carro.getPosicaoY(), null);
			}
			
			g.fillRect(meuCarro.getPosicaoX(), 530, 50, 50);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CorridaCarro();
	}

}
