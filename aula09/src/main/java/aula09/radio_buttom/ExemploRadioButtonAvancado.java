package aula09.radio_buttom;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExemploRadioButtonAvancado extends JFrame {

	private static final String DIARIO = "diario";
	private static final String SEMANAL = "semanal";
	private static final String MENSAL = "mensal";
	
	// Radio
	JRadioButton opcaoMensal;
	JRadioButton opcaoSemanal;
	JRadioButton opcaoDiario;
	
	public ExemploRadioButtonAvancado() {
		
		setTitle("Radio Button");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		
		JPanel conteudo = new JPanel();
		conteudo.setLayout(new GridLayout(6,1));
		this.add(conteudo);
		
		opcaoMensal = new JRadioButton("Mensal");
		opcaoMensal.setMnemonic(KeyEvent.VK_M);
		opcaoMensal.setActionCommand(MENSAL);
		opcaoMensal.setSelected(true);

		opcaoSemanal = new JRadioButton("Semanal");
		opcaoSemanal.setMnemonic(KeyEvent.VK_S);
		opcaoSemanal.setActionCommand(SEMANAL);

		opcaoDiario = new JRadioButton("Diário");
		opcaoDiario.setMnemonic(KeyEvent.VK_D);
		opcaoDiario.setActionCommand(DIARIO);
		
		AcaoRadioButtonSelecionado acao = new AcaoRadioButtonSelecionado();
		opcaoMensal.addActionListener(acao);
		opcaoSemanal.addActionListener(acao);
		opcaoDiario.addActionListener(acao);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(opcaoMensal);
		grupo.add(opcaoSemanal);
		grupo.add(opcaoDiario);
		
		conteudo.add(opcaoDiario);
		conteudo.add(opcaoSemanal);
		conteudo.add(opcaoMensal);
		
		JButton selecionarDiario = new JButton("Selecionar diário");
		selecionarDiario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoDiario.setSelected(true);
			}
		});
		conteudo.add(selecionarDiario);

		JButton desabilitarMensal = new JButton("Desabilitar mensal");
		desabilitarMensal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoMensal.setEnabled(false);
			}
		});
		conteudo.add(desabilitarMensal);
		
		JButton habilitarMensal = new JButton("Habilitar mensal");
		habilitarMensal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				opcaoMensal.setEnabled(true);
			}
		});
		conteudo.add(habilitarMensal);
	}
	
	public static void main(String[] args) {
		new ExemploRadioButtonAvancado().setVisible(true);
	}

}
