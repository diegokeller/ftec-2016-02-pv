package aula15.janelas_mdi;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class ExemploMDI extends JFrame {

	// Desktop onde as janelas internas serão adicionadas
	private JDesktopPane desktop;

	public ExemploMDI() {

		// Obter a lista de Look and Feel instalados
		LookAndFeelInfo[] instalados = UIManager
				.getInstalledLookAndFeels();
		for (LookAndFeelInfo laf : instalados) {
			System.out.println(laf);
		}

		// Trocar o look and feel
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		setTitle("Exemplo MDI");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desktop = new JDesktopPane();

		// Define o menu de opções
		this.setJMenuBar(new MenuDeOpcoes());

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(desktop, BorderLayout.CENTER);

		JButton novaJanela = new JButton("Nova Janela");
		novaJanela.addActionListener(e -> {
			JanelaInterna j = new JanelaInterna("Janela Interna");
			desktop.add(j);
			j.setVisible(true);
		});
//		getContentPane().add(novaJanela, BorderLayout.NORTH);

		getContentPane().add(new BarraFerramentas(),
				BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ExemploMDI().setVisible(true);
	}

}
