package aula09.combo_box;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploComboBox1 extends JFrame {

	public ExemploComboBox1() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

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

		// Combo com opções de objeto
		Animal[] animaisObjeto = { new Animal("Gato", "4"), new Animal("Cachorro", "4"),
				new Animal("Pássaro", "2") };
		JComboBox<Animal> comboAnimaisObjeto = new JComboBox<>(
				animaisObjeto);

		// Adiciona
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(comboAnimais);
		getContentPane().add(comboAnimaisObjeto);

	}

	public static void main(String[] args) {
		new ExemploComboBox1().setVisible(true);
	}

}
