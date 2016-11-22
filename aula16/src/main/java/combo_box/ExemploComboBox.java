package combo_box;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comum.JanelaModelo;

public class ExemploComboBox extends JanelaModelo {

	private JComboBox<String> petList;

	public ExemploComboBox(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(7, 1));
		this.add(conteudo);

		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

		petList = new JComboBox<String>(petStrings);
		petList.setSelectedIndex(4);
		petList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				JOptionPane.showMessageDialog(null, "Selecionou " + combo.getSelectedItem());
			}
		});
		conteudo.add(petList);
		
		JButton selecionarGato = new JButton("Selecionar gato");
		selecionarGato.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				petList.setSelectedItem("Cat");
			}
		});
		conteudo.add(selecionarGato);
		
		JButton selecionarPrimeiro = new JButton("Selecionar primeiro");
		selecionarPrimeiro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				petList.setSelectedIndex(0);
			}
		});
		conteudo.add(selecionarPrimeiro);

		JButton adicionar = new JButton("Adicionar");
		adicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				petList.addItem(Long.toString(System.currentTimeMillis()));
			}
		});
		conteudo.add(adicionar);
	}

	public static void main(String[] args) {
		new ExemploComboBox("Combobox", 300, 500).setVisible(true);
	}

}
