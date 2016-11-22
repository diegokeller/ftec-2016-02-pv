package dialogo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AbasRotuladas extends JFrame implements ActionListener {
	private JTabbedPane Abas;
	private JButton CDMensagem1;
	private JButton CDMensagem2;
	private JButton CDMensagem3;
	private JButton CDConfirmacao1;
	private JButton CDConfirmacao2;
	private JButton CDConfirmacao3;
	private JButton CDConfirmacao4;
	private JLabel LabelConfirmacao;
	private JButton CDOpcao1;
	private JLabel LabelOpcao;
	private JButton CDEntrada1;
	private JButton CDEntrada2;
	private JButton CDEntrada3;
	private JLabel LabelEntrada;
	private JButton CDArquivo1;
	private JLabel LabelArquivo1;
	private JLabel LabelArquivo2;
	private JButton CDCor1;
	private JLabel LabelCor;

	public AbasRotuladas() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(450, 150);
		setLocation(300, 200);
		setTitle("Caixas de Diálogo de...");
		Container P = getContentPane();
		Abas = new JTabbedPane();
		JPanel PCxDlgMensagem = new JPanel();
		CDMensagem1 = new JButton("Mensagem 1");
		CDMensagem2 = new JButton("Mensagem 2");
		CDMensagem3 = new JButton("Mensagem 3");
		PCxDlgMensagem.add(CDMensagem1);
		PCxDlgMensagem.add(CDMensagem2);
		PCxDlgMensagem.add(CDMensagem3);
		JPanel PCxDlgConfirmacao = new JPanel();
		CDConfirmacao1 = new JButton("Confirmação 1");
		CDConfirmacao2 = new JButton("Confirmação 2");
		CDConfirmacao3 = new JButton("Confirmação 3");
		CDConfirmacao4 = new JButton("Confirmação 4");
		LabelConfirmacao = new JLabel("Retorno:");
		PCxDlgConfirmacao.add(CDConfirmacao1);
		PCxDlgConfirmacao.add(CDConfirmacao2);
		PCxDlgConfirmacao.add(CDConfirmacao3);
		PCxDlgConfirmacao.add(CDConfirmacao4);
		PCxDlgConfirmacao.add(LabelConfirmacao);
		JPanel PCxDlgOpcao = new JPanel();
		CDOpcao1 = new JButton("Opção 1");
		LabelOpcao = new JLabel("Retorno:");
		PCxDlgOpcao.add(CDOpcao1);
		PCxDlgOpcao.add(LabelOpcao);
		JPanel PCxDlgEntrada = new JPanel();
		CDEntrada1 = new JButton("Entrada 1");
		CDEntrada2 = new JButton("Entrada 2");
		CDEntrada3 = new JButton("Entrada 3");
		LabelEntrada = new JLabel("Retorno:");
		PCxDlgEntrada.add(CDEntrada1);
		PCxDlgEntrada.add(CDEntrada2);
		PCxDlgEntrada.add(CDEntrada3);
		PCxDlgEntrada.add(LabelEntrada);
		JPanel PCxDlgArquivo = new JPanel();
		CDArquivo1 = new JButton("Arquivo 1");
		LabelArquivo1 = new JLabel("Retorno:");
		LabelArquivo2 = new JLabel("Seleção:");
		PCxDlgArquivo.add(CDArquivo1);
		PCxDlgArquivo.add(LabelArquivo1);
		PCxDlgArquivo.add(LabelArquivo2);
		JPanel PCxDlgCor = new JPanel();
		CDCor1 = new JButton("Cor 1");
		LabelCor = new JLabel("Retorno:");
		PCxDlgCor.add(CDCor1);
		PCxDlgCor.add(LabelCor);
		Abas.addTab("Mensagem", PCxDlgMensagem);
		Abas.addTab("Confirmação", PCxDlgConfirmacao);
		Abas.addTab("Opção", PCxDlgOpcao);
		Abas.addTab("Entrada", PCxDlgEntrada);
		Abas.addTab("Arquivo", PCxDlgArquivo);
		Abas.addTab("Cor", PCxDlgCor);
		P.add(Abas);
		CDMensagem1.addActionListener(this);
		CDMensagem2.addActionListener(this);
		CDMensagem3.addActionListener(this);
		CDConfirmacao1.addActionListener(this);
		CDConfirmacao2.addActionListener(this);
		CDConfirmacao3.addActionListener(this);
		CDConfirmacao4.addActionListener(this);
		CDOpcao1.addActionListener(this);
		CDEntrada1.addActionListener(this);
		CDEntrada2.addActionListener(this);
		CDEntrada3.addActionListener(this);
		CDArquivo1.addActionListener(this);
		CDCor1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		Object origem = evt.getSource();
		int retorno = 0;
		String valorRet = null;
		Icon icone = new ImageIcon("LogoSun.gif");
		if (origem == CDMensagem1)
			JOptionPane.showMessageDialog(null, "Esta é uma caixa de diálogo de Mensagem");
		else if (origem == CDMensagem2)
			JOptionPane.showMessageDialog(null, "Esta é uma caixa de diálogo de Mensagem", "Mensagem", JOptionPane.WARNING_MESSAGE);
		else if (origem == CDMensagem3)
			JOptionPane.showMessageDialog(null, "Esta é uma caixa de diálogo de Mensagem", "Mensagem", JOptionPane.WARNING_MESSAGE, icone);
		else if (origem == CDConfirmacao1) {
			retorno = JOptionPane.showConfirmDialog(null, "Confirma Operação?");
			LabelConfirmacao.setText("Retorno: " + retorno);
		} else if (origem == CDConfirmacao2) {
			retorno = JOptionPane.showConfirmDialog(null, "Confirma Operação?", "Confirmação", JOptionPane.YES_NO_OPTION);
			LabelConfirmacao.setText("Retorno: " + retorno);
		} else if (origem == CDConfirmacao3) {
			retorno = JOptionPane
					.showConfirmDialog(null, "Confirma Operação?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			LabelConfirmacao.setText("Retorno: " + retorno);
		} else if (origem == CDConfirmacao4) {
			retorno = JOptionPane.showConfirmDialog(null, "Confirma Operação?", "Confirmação", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, icone);
			LabelConfirmacao.setText("Retorno: " + retorno);
		} else if (origem == CDOpcao1) {
			Object[] opcoes = { "OK", "Cancelar" };
			retorno = JOptionPane.showOptionDialog(null, "Esta é uma caixa de diálogo de Opção", "Opção", JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE, null, opcoes, opcoes[0]);
			LabelOpcao.setText("Retorno: " + retorno);
		} else if (origem == CDEntrada1) {
			valorRet = JOptionPane.showInputDialog(null, "Digite um valor");
			LabelEntrada.setText("Retorno: " + valorRet);
		} else if (origem == CDEntrada2) {
			valorRet = JOptionPane.showInputDialog(null, "Digite um valor", "Entrada", JOptionPane.QUESTION_MESSAGE);
			LabelEntrada.setText("Retorno: " + valorRet);
		} else if (origem == CDEntrada3) {
			Object[] valores = { "Opção Um", "Opção Dois", "Opção Três", "Opção Quatro" };
			Object valorSelec = JOptionPane.showInputDialog(null, "Escolha uma opção", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, valores,
					valores[0]);
			LabelEntrada.setText("Retorno: " + valorSelec.toString());
		} else if (origem == CDArquivo1) {
			JFileChooser abreArquivo = new JFileChooser();
			abreArquivo.setCurrentDirectory(new File("."));
			abreArquivo.setSelectedFile(new File("AbasRotuladas.java"));
			retorno = abreArquivo.showOpenDialog(this);
			LabelArquivo1.setText("Retorno: " + retorno);
			if (retorno == JFileChooser.APPROVE_OPTION) {
				File arquivoSelec = abreArquivo.getSelectedFile();
				LabelArquivo2.setText("Seleção: " + arquivoSelec.getName());
			} else
				LabelArquivo2.setText("Seleção: Nenhum arquivo");
		} else if (origem == CDCor1) {
			JColorChooser abreCor = new JColorChooser();
			Color c = abreCor.showDialog(this, "Escolha uma cor", Color.black);
			LabelCor.setForeground(c);
			LabelCor.setText("Retorno: " + c.toString());
		}
	}

	public static void main(String[] args) {
		AbasRotuladas fr = new AbasRotuladas();
		fr.setVisible(true);
	}
}
