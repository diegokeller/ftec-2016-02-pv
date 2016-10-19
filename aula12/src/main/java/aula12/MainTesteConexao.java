package aula12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTesteConexao {

	public static void main(String[] args) {

		// Monta a string de conexão do banco
		String stringConexao = "jdbc:postgresql://localhost:5432/pedidos";

		// Usuário e senha de conexão ao banco
		String usuario = "postgres";
		String senha = "postgres";

		// Carrega o driver JDBC
		// Esse passo é opcional depois do JDBC4
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Classe do driver não encontrada.");
		}

		Connection conexao = null;

		// Conecta no banco
		try {
			conexao = DriverManager.getConnection(stringConexao,
					usuario, senha);
			System.out.println("Conectou");
//			incluirUsuario(conexao);
			buscarUsuario(conexao);
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void buscarUsuario(Connection conexao) {
		String sql = "select * from usuario where login = ?";
		try(PreparedStatement ps = conexao.prepareStatement(sql)){
			
			// Parâmetros da consulta
			ps.setString(1, "joao");

			// Try with resources - fecha sozinho
			try(ResultSet resultado = ps.executeQuery()){
				// Enquanto houver resultados
				while(resultado.next()){
					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					System.out.println(id + " " + nome);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void incluirUsuario(Connection conexao) {
		
		// Monta o comandos SQL
		String sql = 
				"insert into usuario("
				+ "	nome, login, email, senha, ativo, perfil) " + 
				" values (?, ?, ?, ?, ?, ?)";

		// Try with resources - PS será automaticamente fechado
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			
			// Passar os parâmetros
			ps.setString(1, "João 2");
			ps.setString(2, "joao");
			ps.setString(3, "joao@email.com");
			ps.setString(4, "123");
			ps.setBoolean(5, true);
			ps.setString(6, "Administrador");
			
			// Executa
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
