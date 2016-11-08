package aula15.janelas_mdi;

import javax.swing.JInternalFrame;

/**
 * Herdar de JInternalFrame, para que seja uma janela interna 
 */
public class JanelaInterna extends JInternalFrame {
	
	public JanelaInterna(String titulo) {
		setTitle(titulo);
		setSize(250,250);
		
		// Pode ser fechda
		setClosable(true);
		// Pode virar ícone
		setIconifiable(true);
		// Redimensionável
		setResizable(true);
		// Maximizável
		setMaximizable(true);
		// Localização
		setLocation(10, 10);
	}

}
