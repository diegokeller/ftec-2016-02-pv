package com.uniftec.pv.loja.persistencia;

import java.sql.Connection;
import java.util.List;

import com.uniftec.pv.loja.modelo.Usuario;

public class MainTeste {

	public static void main(String[] args) {

		try {

			Connection connection = ConnectionFactory.getConnection();
			
			// Testa a inclusão
			DAOFactory.getDAOFactory().getUsuarioDAO(connection)
					.inserir(new Usuario(null, "TESTE 25/10", "teste",
							"teste@email.com", "teste", true, "Cliente"));

			// Testa buscar todos
			List<Usuario> todos = DAOFactory.getDAOFactory()
					.getUsuarioDAO(connection).buscarTodos();
			todos.forEach(usuario -> {
				System.out.println(usuario);
			});

		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		System.out.println("OK");

	}

}
