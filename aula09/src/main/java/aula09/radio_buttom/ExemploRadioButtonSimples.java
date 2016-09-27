package aula09.radio_buttom;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class ExemploRadioButtonSimples extends JFrame {

	public ExemploRadioButtonSimples() {

		// Cria a janela
		setTitle("Exemplo Simples Radio Button");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

		// Cria as botões
		JRadioButton opcaoAdministrador = new JRadioButton(
				"Administrador");
		JRadioButton opcaoCliente = new JRadioButton("Cliente");
		JRadioButton opcaoVendedor = new JRadioButton("Vendedor");

		// Indica quais delas fazem parte do mesmo grupo
		// Faz com que haja uma seleção 
		// exclusiva entre as opções do mesmo grupo
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(opcaoVendedor);
		grupo.add(opcaoCliente);
		grupo.add(opcaoAdministrador);
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(opcaoAdministrador);
		getContentPane().add(opcaoCliente);
		getContentPane().add(opcaoVendedor);
	}

	public static void main(String[] args) {
		new ExemploRadioButtonSimples().setVisible(true);
	}

}
