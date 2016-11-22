package barra_de_ferramentas;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {
	
	// Gerenciador de janelas
	private JDesktopPane desktop;
	
	public JanelaPrincipal() {
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Exemplo de janelas MDI com Barra de Ferramentas");
		
		// Centralizar janela
		setLocationRelativeTo(null);
		
		// Instancia o desktop
		desktop = new JDesktopPane();
		
		// Adiciona a barra de menus
		this.setJMenuBar(new MenuDeOpcoes(desktop));
		
		// Adiciona ao frame
		this.setLayout(new BorderLayout());
		this.add(desktop, BorderLayout.CENTER);
		
		// Adiciona a barra de ferramentas
		this.add(new BarraFerramentas(), BorderLayout.NORTH);
		
	}
	
}
