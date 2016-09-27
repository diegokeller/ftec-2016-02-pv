package aula09.combo_box;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploComboBox extends JFrame {

	public ExemploComboBox() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		
		// Vetor de opções
		String[] animais = { "Pássaro", "Gato", "Cachorro", "Coelho",
				"Porco" };

		
		// Cria a combo
		JComboBox<String> comboAnimais = new JComboBox<String>(
				animais);
		comboAnimais.setSelectedIndex(4);
		
		// Ação ao escolher
		comboAnimais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e
						.getSource();
				JOptionPane.showMessageDialog(null,
						"Selecionou " + combo.getSelectedItem());
			}
		});
		
		// Adiciona
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(comboAnimais);

	}

	public static void main(String[] args) {
		new ExemploComboBox().setVisible(true);
	}

}
