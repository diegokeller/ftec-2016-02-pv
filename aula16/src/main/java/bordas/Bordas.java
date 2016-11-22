package bordas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Bordas extends JFrame implements ActionListener {
	
	private JButton RBEtched;
	private JButton RBEmpty;
	private JButton RBLine;
	private JButton RBMatte;
	private JButton RBLoweredBevel;
	private JButton RBRaisedBevel;
	private JButton RBCompound;
	private JCheckBox CBTitled;
	private Border BordaCentro = null;

	public Bordas() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(700, 250);
		setTitle("Bordas");
		JPanel PainelBaixo = new JPanel();
		RBEtched = new JButton("Etched");
		RBEmpty = new JButton("Empty");
		RBLine = new JButton("Line");
		RBMatte = new JButton("Matte");
		RBLoweredBevel = new JButton("LoweredBevel");
		RBRaisedBevel = new JButton("RaisedBevel");
		RBCompound = new JButton("Compound");
		CBTitled = new JCheckBox("Titled");
		PainelBaixo.add(RBEtched);
		PainelBaixo.add(RBEmpty);
		PainelBaixo.add(RBLine);
		PainelBaixo.add(RBMatte);
		PainelBaixo.add(RBLoweredBevel);
		PainelBaixo.add(RBRaisedBevel);
		PainelBaixo.add(RBCompound);
		PainelBaixo.add(CBTitled);
		Border borda = BorderFactory.createEtchedBorder();
		Border BordaBaixo = BorderFactory.createTitledBorder(borda, " Tipos de Borda ");
		PainelBaixo.setBorder(BordaBaixo);
		Container P = getContentPane();
		P.setLayout(new BorderLayout());
		P.add(PainelBaixo, "South");
		RBEtched.addActionListener(this);
		RBEmpty.addActionListener(this);
		RBLine.addActionListener(this);
		RBMatte.addActionListener(this);
		RBLoweredBevel.addActionListener(this);
		RBRaisedBevel.addActionListener(this);
		RBCompound.addActionListener(this);
		CBTitled.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		Object origem = evt.getSource();
		JPanel PainelCentro = new JPanel();
		if (origem == RBEtched)
			BordaCentro = BorderFactory.createEtchedBorder();
		else if (origem == RBEmpty)
			BordaCentro = BorderFactory.createEmptyBorder();
		else if (origem == RBLine)
			BordaCentro = BorderFactory.createLineBorder(Color.red);
		else if (origem == RBMatte)
			BordaCentro = BorderFactory.createMatteBorder(8, 8, 8, 8, Color.BLUE);
		else if (origem == RBLoweredBevel)
			BordaCentro = BorderFactory.createLoweredBevelBorder();
		else if (origem == RBRaisedBevel)
			BordaCentro = BorderFactory.createRaisedBevelBorder();
		else if (origem == RBCompound)
			BordaCentro = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
					BorderFactory.createMatteBorder(3, 3, 3, 3, Color.green));
		if (CBTitled.isSelected()) {
			Border BordaTitulo = BorderFactory.createTitledBorder(BordaCentro, " Exemplo de Título ");
			PainelCentro.setBorder(BordaTitulo);
		} else
			PainelCentro.setBorder(BordaCentro);
		Container P = getContentPane();
		P.add(PainelCentro, "Center");
		validate();
	}

	public static void main(String[] args) {
		JFrame fr = new Bordas();
		fr.setVisible(true);
	}
}
