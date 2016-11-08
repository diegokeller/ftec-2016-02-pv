package aula15.janelas_mdi;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// Herdar de JMenuBar para criar uma barra de menus
public class MenuDeOpcoes extends JMenuBar {

	public MenuDeOpcoes() {

		// Cria o menu arquivo
		JMenu arquivo = new JMenu("Arquivo");

		// Tecla de atalho com ALT
		arquivo.setMnemonic(KeyEvent.VK_A);

		// Adiciona o menu na barra
		this.add(arquivo);

		// Cria a opção sair dentro do menu arquivo
		JMenuItem arquivoSair = new JMenuItem("Sair");
		arquivoSair.addActionListener(e -> {
			System.exit(0);
		});
		arquivo.add(arquivoSair);
	}

}
