package teste.tocar_som;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploTocarSom extends JFrame {
	
	public ExemploTocarSom() {
		setSize(200,200);
		setTitle("Tocar som");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		JButton tocar = new JButton("Tocar");
		tocar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ThreadTocarSom().start();
			}
		});
		getContentPane().add(tocar);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExemploTocarSom();
	}

}
