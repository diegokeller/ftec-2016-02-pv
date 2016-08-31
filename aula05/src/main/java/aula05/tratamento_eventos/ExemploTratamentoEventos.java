package aula05.tratamento_eventos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploTratamentoEventos extends JFrame {

	public ExemploTratamentoEventos() {
		setSize(400, 400);
		setTitle("Exemplo de Tratamento de Eventos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new FlowLayout());

		JButton ok = new JButton("OK");
		ok.addActionListener(new AcaoExibirMensagem());
		getContentPane().add(ok);

		JFrame janela = this;
		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(janela,
						"Excluído com sucesso!");
			}
		});
		getContentPane().add(excluir);
		
		// Java 8 Lambda Expressions
		JButton fechar = new JButton("Fechar");
		fechar.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Saindo...");
		});
		getContentPane().add(fechar);

		getContentPane().add(new JButton("Cancelar"));
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new ExemploTratamentoEventos();
	}

}
