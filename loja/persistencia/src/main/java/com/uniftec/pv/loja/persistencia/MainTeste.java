package com.uniftec.pv.loja.persistencia;

import java.util.List;

import com.uniftec.pv.loja.modelo.Usuario;

public class MainTeste {

	public static void main(String[] args) {

		try {

			// Testa a inclusão
			DAOFactory.getDAOFactory().getUsuarioDAO()
					.inserir(new Usuario(null, "TESTE 25/10", "teste",
							"teste@email.com", "teste", true, "Cliente"));

			// Testa buscar todos
			List<Usuario> todos = DAOFactory.getDAOFactory()
					.getUsuarioDAO().buscarTodos();
			todos.forEach(usuario -> {
				System.out.println(usuario);
			});

		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		System.out.println("OK");

	}

}
