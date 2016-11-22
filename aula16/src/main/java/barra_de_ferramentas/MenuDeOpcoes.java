package barra_de_ferramentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuDeOpcoes extends JMenuBar {

	private int contador = 0;
	private int x = 0;
	private int y = 0;
	
	public MenuDeOpcoes(final JDesktopPane desktop) {
		
		// Cria o menu arquivo
		JMenu arquivo = new JMenu("Arquivo");
		
		// Tecla de atalho com ALT
		arquivo.setMnemonic(KeyEvent.VK_A);
		
		// Adiciona o menu na barra
		this.add(arquivo);
		
		// Opção Novo
		JMenuItem arquivoNovo = new JMenuItem("Novo");
		arquivoNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				contador++;
				x += 10;
				y += 10;
				
				JInternalFrame frame = new JInternalFrame("Frame " + contador, 
						false, true, true, true);
				desktop.add(frame);
				frame.setSize(200, 200);
				frame.setLocation(x, y);
				frame.setVisible(true);
				
			}
		});
		arquivo.add(arquivoNovo);
		
		// Separador
		arquivo.addSeparator();

		// Cria a opção sair dentro do menu arquivo
		JMenuItem arquivoSair = new JMenuItem("Sair");
		arquivoSair.setMnemonic(KeyEvent.VK_S);
		arquivoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		arquivo.add(arquivoSair);
		
		
	}
	
}
