package com.uniftec.pv.loja.testes;

import java.awt.FlowLayout;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.uniftec.pv.loja.negocio.BusinessException;
import com.uniftec.pv.loja.negocio.UsuarioBO;

public class MainTesteLogin extends JFrame {

	private JTextField login;
	private JPasswordField senha;

	private JButton entrar;

	public MainTesteLogin() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);

		getContentPane().setLayout(new FlowLayout());

		login = new JTextField(10);
		senha = new JPasswordField(10);
		entrar = new JButton("Entrar");
		entrar.addActionListener(e -> {
			try {
				new UsuarioBO().login(login.getText(),
						senha.getPassword().toString());
			} catch (BusinessException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		});

		getContentPane().add(login);
		getContentPane().add(senha);
		getContentPane().add(entrar);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		new MainTesteLogin().setVisible(true);
	}

}
