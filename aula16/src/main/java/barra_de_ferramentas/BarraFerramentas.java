package barra_de_ferramentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * Classe de barra e ferramentas. Herda de JToolBar.
 * @author Diego
 *
 */
public class BarraFerramentas extends JToolBar {
	
	public BarraFerramentas() {
		
		// Cria um JButton apenas com texto
		JButton usuarios = new JButton("Usuários");
		usuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Print - apenas para teste
				System.out.println("Cadastro de usuários");
			}
		});
		this.add(usuarios);
		
		// Apenas com ícone
		JButton homens = new JButton(new ImageIcon("src/main/resources/homem.png"));
		homens.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Print - apenas para teste
				System.out.println("Homens");
			}
		});
		this.add(homens);
		
		// Botão com texto e ícones
		JButton mulheres = new JButton("Mulher", new ImageIcon("src/main/resources/mulher.png"));
		mulheres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Print - apenas para teste
				System.out.println("Mulheres");
			}
		});
		this.add(mulheres);
		
	}

}
