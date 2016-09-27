package aula09.combo_box;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExemploComboBox2 extends JFrame {

	private JComboBox<String> petList;

	public ExemploComboBox2() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

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
		new ExemploComboBox2().setVisible(true);
	}

}
