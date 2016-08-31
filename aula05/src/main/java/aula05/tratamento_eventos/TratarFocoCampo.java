package aula05.tratamento_eventos;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class TratarFocoCampo implements FocusListener {
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() instanceof JComponent){
			JComponent campo = (JComponent) e.getSource();
			campo.setBackground(Color.WHITE);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField campo = (JTextField) e.getSource();
		System.out.println(campo.getText());
		campo.setBackground(Color.YELLOW);
	}
}
