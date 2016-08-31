package aula05.tratamento_eventos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ExemploEventos extends JFrame {

	public ExemploEventos() {
		setSize(400, 400);
		setTitle("Exemplo de Eventos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new FlowLayout());
		
		JTextField email = new JTextField(10);
		email.addFocusListener(new TratarFocoCampo());
		email.addKeyListener(new TratarTeclaPressionada());
		getContentPane().add(email);
		
		JTextField nome = new JTextField(10);
		nome.addFocusListener(new TratarFocoCampo());
		nome.addKeyListener(new TratarTeclaPressionada());
		getContentPane().add(nome);
		
		getContentPane().addMouseListener(new TratarEventosMouse());
		getContentPane().addMouseMotionListener(new 
				TratarMovimentoMouse());
		getContentPane().addMouseWheelListener(new 
				TratarEventoScroll());
		
		this.addWindowListener(new TratarEventoJanela());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new ExemploEventos();
	}

}
