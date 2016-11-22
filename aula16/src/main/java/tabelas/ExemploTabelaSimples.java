package tabelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import comum.JanelaModelo;

public class ExemploTabelaSimples extends JanelaModelo {

	public ExemploTabelaSimples(String titulo, int altura,
			int largura) {
		super(titulo, altura, largura);

		// Nomes de colunas
		String[] columnNames = { "First Name", "Last Name",
				"Esporte", "# of Years", "Vegetarian" };

		// Dados
		final Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding", new Integer(5),
						new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3),
						new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2),
						new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10),
						new Boolean(false) } };

		final JTable table = new JTable(data, columnNames);

		// Selecionar apenas 1
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Scroll
		JScrollPane scroll = new JScrollPane(table);

		this.setLayout(new BorderLayout());
		this.add(table.getTableHeader(), BorderLayout.NORTH);

		JButton selecionado = new JButton("TESTE");
		selecionado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				for (int j = 0; j < data[i].length; j++) {
					System.out.println(data[i][j]);
				}
				JOptionPane.showMessageDialog(null, data[i][0]);
			}
		});
		this.add(selecionado, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new ExemploTabelaSimples("Tabela Simples", 300, 500)
				.setVisible(true);
	}

}
