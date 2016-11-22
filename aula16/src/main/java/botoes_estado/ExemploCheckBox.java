package botoes_estado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comum.JanelaModelo;

public class ExemploCheckBox extends JanelaModelo {

	private static final String ALFACE = "alface";
	private static final String TOMATE = "tomate";
	private static final String CEBOLA = "cebola";

	JCheckBox opcaoAlface;
	JCheckBox opcaoTomate;
	JCheckBox opcaoCebola;

	public ExemploCheckBox(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(7, 1));
		this.add(conteudo);

		opcaoAlface = new JCheckBox("Alface");
		opcaoAlface.setSelected(true);
		opcaoAlface.setMnemonic(KeyEvent.VK_A);
		opcaoAlface.setActionCommand(ALFACE);
		conteudo.add(opcaoAlface);

		opcaoTomate = new JCheckBox("Tomate");
		opcaoTomate.setSelected(true);
		opcaoTomate.setMnemonic(KeyEvent.VK_T);
		opcaoTomate.setActionCommand(TOMATE);
		conteudo.add(opcaoTomate);

		opcaoCebola = new JCheckBox("Cebola");
		opcaoCebola.setSelected(true);
		opcaoCebola.setMnemonic(KeyEvent.VK_T);
		opcaoCebola.setActionCommand(CEBOLA);
		opcaoCebola.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox source = (JCheckBox) e.getSource();
				System.out.println(source.getActionCommand());
			}
		});
		conteudo.add(opcaoCebola);

		JButton selecionarTodos = new JButton("Selecionar todos");
		selecionarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoAlface.setSelected(true);
				opcaoTomate.setSelected(true);
				opcaoCebola.setSelected(true);
			}
		});
		conteudo.add(selecionarTodos);

		JButton deselecionarTodos = new JButton("Deselecionar todos");
		deselecionarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoAlface.setSelected(false);
				opcaoTomate.setSelected(false);
				opcaoCebola.setSelected(false);
			}
		});
		conteudo.add(deselecionarTodos);

		JButton habilitarDesabilitarTodos = new JButton("Habilitar/Desabilitar todos");
		habilitarDesabilitarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoAlface.setEnabled(!opcaoAlface.isEnabled());
				opcaoTomate.setEnabled(!opcaoTomate.isEnabled());
				opcaoCebola.setEnabled(!opcaoCebola.isEnabled());
			}
		});
		conteudo.add(habilitarDesabilitarTodos);

		JButton mostrarSelecionados = new JButton("Mostrar selecionados");
		mostrarSelecionados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> selecionados = new LinkedList<String>();
				if (opcaoAlface.isSelected()) {
					selecionados.add(opcaoAlface.getActionCommand());
				}
				if (opcaoTomate.isSelected()) {
					selecionados.add(opcaoTomate.getActionCommand());
				}
				if (opcaoCebola.isSelected()) {
					selecionados.add(opcaoCebola.getActionCommand());
				}
				JOptionPane.showMessageDialog(null, selecionados.toString());
			}
		});
		conteudo.add(mostrarSelecionados);
	}

	public static void main(String[] args) {
		new ExemploCheckBox("Checkbox", 300, 500).setVisible(true);
	}

}
