package com.uniftec.pv.loja.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por criar as conexões com os bancos de dados que a aplicação
 * suporta.
 */
public class ConnectionFactory {

	public static Connection getConnection()
			throws PersistenceException {
		return getPostgresConnection();
	}

	/**
	 * Obtém uma conexão com o banco de dados Postgres
	 * 
	 * @throws PersistenceException
	 */
	private static Connection getPostgresConnection()
			throws PersistenceException {

		// Monta a string de conexão do banco
		String stringConexao = "jdbc:postgresql://localhost:5432/pedidos";

		// Usuário e senha de conexão ao banco
		String usuario = "postgres";
		String senha = "postgre";

		// Carrega o driver JDBC
		// Esse passo é opcional depois do JDBC4
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do driver não encontrada.");
		}

		Connection conexao = null;

		// Conecta no banco
		try {
			conexao = DriverManager.getConnection(stringConexao,
					usuario, senha);
			
			// Desabilitar o commit automático
			conexao.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(
					"Erro de conexão com o banco de dados.", e);
		}

		return conexao;

	}

}
