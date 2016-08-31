package aula05.tratamento_eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TratarMovimentoMouse
		implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out
				.println("mouseMoved: " + e.getX() + " | " + e.getY());
	}

}
