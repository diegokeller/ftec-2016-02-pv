package popup;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import comum.JanelaModelo;

public class ExemploPopup extends JanelaModelo {

	private JPopupMenu pop;

	public ExemploPopup(String titulo, int altura, int largura) {
		super(titulo, altura, largura);

		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(7, 1));
		this.add(conteudo);
		
		pop = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Salvar");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TESTE");
			}
		});
		pop.add(menuItem);
		pop.add(new JMenuItem("Sair"));
		
		this.addMouseListener(new PopupListener());
		
	}

	public static void main(String[] args) {
		new ExemploPopup("Popup", 300, 500).setVisible(true);
	}

	class PopupListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	        deveMostrar(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        deveMostrar(e);
	    }

	    private void deveMostrar(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	            pop.show(e.getComponent(),
	                       e.getX(), e.getY());
	        }
	    }
	}
}
