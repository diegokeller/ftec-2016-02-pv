package aula05.tratamento_eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TratarEventosMouse implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked " + e.getButton());
		System.out.println(e.getX() + " | " + e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

}
