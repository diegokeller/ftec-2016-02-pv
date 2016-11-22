package list_box;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import comum.JanelaModelo;

public class ExemploListBox extends JanelaModelo {

	private JList<String> petList;
	private DefaultListModel<String> opcoes;

	public ExemploListBox(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(7, 1));
		this.add(conteudo);

		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

		opcoes = new DefaultListModel<String>();
		for (String string : petStrings) {
			opcoes.addElement(string);
		}
		petList = new JList<String>(opcoes);
		petList.setSelectedIndex(4);
		petList.setVisibleRowCount(-1);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		petList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		petList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.getFirstIndex());
			}
		});		
		JScrollPane listScroller = new JScrollPane(petList);
		listScroller.setPreferredSize(new Dimension(250, 200));
		conteudo.add(listScroller);
		
		JButton selecionarGato = new JButton("Selecionar gato");
		selecionarGato.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				petList.setSelectedValue("Cat", true);
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
				opcoes.addElement(Long.toString(System.currentTimeMillis()));
			}
		});
		conteudo.add(adicionar);
		
		JButton selecionados = new JButton("Selecionados");
		selecionados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> selecionados = petList.getSelectedValuesList();
				JOptionPane.showMessageDialog(null, selecionados.toString());
			}
		});
		conteudo.add(selecionados);
	}

	public static void main(String[] args) {
		new ExemploListBox("List", 300, 500).setVisible(true);
	}

}
