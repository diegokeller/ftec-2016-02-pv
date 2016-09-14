package aula07.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class ExemploAdapter extends JFrame {

	public ExemploAdapter() {
		setTitle("Exemplo Adapter");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);
		
		// Adicionar um tratamento de evento usando Listener
		// Obrigatório tratar todos os eventos / métodos
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		
		// Usando padrão adapter
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				System.out.println("Tecla pressionada: " + e.getKeyChar());
			}
		});
		
		// Mouse
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicou X: " + e.getX());
				System.out.println("Clicou Y: " + e.getY());
				System.out.println("=======================");
			}
		});
	}
	
	public static void main(String[] args) {
		new ExemploAdapter();
	}
	
}
