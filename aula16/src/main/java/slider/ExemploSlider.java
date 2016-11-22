package slider;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comum.JanelaModelo;

public class ExemploSlider extends JanelaModelo {

	private JTextField valor;

	public ExemploSlider(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(1, 2));
		this.add(conteudo);

		final JSlider slider = new JSlider();
		slider.setMinimum(10);
		slider.setMaximum(90);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				valor.setText(Integer.toString(slider.getValue()));
			}
		});
		conteudo.add(slider);
		
		valor = new JTextField();
		valor.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					slider.setValue(Integer.parseInt(valor.getText()));
				}
			}
		});
		conteudo.add(valor);
		
		
	}

	public static void main(String[] args) {
		new ExemploSlider("Slider", 300, 500).setVisible(true);
	}

}
