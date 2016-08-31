package aula05.tratamento_eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TratarEventoJanela implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Janela aberta");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Janela fechando");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Janela fechada");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Minimizada");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Maximiza");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Ganhou foco");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Perdeu foco");
	}

}
