package aula05.tratamento_eventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TratarTeclaPressionada implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Typed: " + e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released: " + e.getKeyCode());
		JTextField campo = (JTextField) e.getSource();
		campo.setText(campo.getText().toUpperCase());
	}

}
