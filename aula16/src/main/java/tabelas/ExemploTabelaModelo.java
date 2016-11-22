package tabelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import comum.JanelaModelo;

public class ExemploTabelaModelo extends JanelaModelo {

	public ExemploTabelaModelo(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		// Dados
		List<Usuario> dados = new LinkedList<Usuario>();
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		dados.add(new Usuario("João", true, new Date()));
		dados.add(new Usuario("Maria", false, new Date()));
		dados.add(new Usuario("Carlos", false, new Date()));
		
		final JTable table = new JTable(new UsuarioTableModel(dados));
		
		// Selecionar apenas 1
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(table.getModel().getValueAt(e.getLastIndex(), 0));
			}
		});
		
		// Scroll
		JScrollPane scroll = new JScrollPane(table);
		
		this.setLayout(new BorderLayout());
		this.add(table.getTableHeader(), BorderLayout.NORTH);
		
		JButton selecionado = new JButton("TESTE");
		selecionado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				JOptionPane.showMessageDialog(null, table.getModel().getValueAt(i, 0));
			}
		});
		this.add(selecionado, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo lookAndFeelInfo : installedLookAndFeels) {
			System.out.println(lookAndFeelInfo.getClassName());
		}
//		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new ExemploTabelaModelo("Tabela Com Modelo", 300, 500).setVisible(true);
	}

}
