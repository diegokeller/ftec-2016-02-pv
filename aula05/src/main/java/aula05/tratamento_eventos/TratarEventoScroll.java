package aula05.tratamento_eventos;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class TratarEventoScroll implements MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Scroll: " + e.getWheelRotation());
	}

}
