package aula15.janelas_mdi;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class BarraFerramentas extends JToolBar {

	public BarraFerramentas() {

		JButton alerta = new JButton("Alerta");
		alerta.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Cuidado!!!!",
					"Alerta", JOptionPane.WARNING_MESSAGE, null);
		});
		this.add(alerta);

		JButton usuario = new JButton(
				new ImageIcon("src/main/resources/user.png"));
		usuario.addActionListener(e -> {
			System.out.println("Usuários");
		});
		this.add(usuario);

		JButton sair = new JButton("Sair");
		sair.addActionListener(e -> {
			System.exit(0);
		});
		this.add(sair);
	}

}
