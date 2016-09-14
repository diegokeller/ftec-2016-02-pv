package aula07.componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class AcaoTrocarCorDeFundo implements ActionListener {

	private JFrame janela;
	
	public AcaoTrocarCorDeFundo(JFrame janela) {
		this.janela = janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox opcao = (JCheckBox) e.getSource();
		if (!opcao.isSelected()) {
			return;
		}
		Color color = null;
		try {
			Field field = Class.forName("java.awt.Color")
					.getField(e.getActionCommand());
			color = (Color) field.get(null);
		} catch (Exception erro) {
			erro.printStackTrace();
		}
		System.out.println("Clicou " + color);
		this.janela.getContentPane().setBackground(color);
	}

}
