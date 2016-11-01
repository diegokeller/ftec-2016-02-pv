package com.uniftec.pv.loja.persistencia.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.uniftec.pv.loja.modelo.Usuario;
import com.uniftec.pv.loja.persistencia.ConnectionFactory;
import com.uniftec.pv.loja.persistencia.PersistenceException;
import com.uniftec.pv.loja.persistencia.UsuarioDAO;

public class UsuarioPostgresDAO implements UsuarioDAO {

	@Override
	public void inserir(Usuario usuario)
			throws PersistenceException {

		// Monta o comandos SQL
		String sql = "insert into usuario("
				+ "	nome, login, email, senha, ativo, perfil) "
				+ " values (?, ?, ?, ?, ?, ?)";

		// Pega a conexão
		Connection conexao = ConnectionFactory
				.getPostgresConnection();

		// Try with resources - PS será automaticamente fechado
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {

			// Passar os parâmetros
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			ps.setBoolean(5, usuario.getAtivo());
			ps.setString(6, usuario.getPerfil());

			// Executa
			ps.execute();

		} catch (SQLException e) {
			throw new PersistenceException(
					"Erro ao inserir o usuário.", e);
		}

	}

	@Override
	public void atualizar(Usuario usuario) {
	}

	@Override
	public void excluir(Integer id) {
	}

	@Override
	public Usuario buscar(Integer id) {
		return null;
	}

	@Override
	public List<Usuario> buscarTodos()
			throws PersistenceException {

		// Lista de usuarios
		List<Usuario> retorno = new LinkedList<Usuario>();

		// Pega a conexão
		Connection conexao = ConnectionFactory
				.getPostgresConnection();

		String sql = "select * from usuario";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {

			// Try with resources - fecha sozinho
			try (ResultSet resultado = ps.executeQuery()) {

				// Enquanto houver resultados
				while (resultado.next()) {

					Usuario usuario = montarUsuario(resultado);

					// Adiciona na lista de retorno
					retorno.add(usuario);
				}
			}
		} catch (SQLException e) {
			throw new PersistenceException(
					"Erro ao buscar os usuários.", e);
		}

		return retorno;
	}

	private Usuario montarUsuario(ResultSet resultado)
			throws SQLException {
		// Pega os campos
		int id = resultado.getInt("id");
		String nome = resultado.getString("nome");
		String email = resultado.getString("email");
		String login = resultado.getString("login");
		String senha = resultado.getString("senha");
		Boolean ativo = resultado.getBoolean("ativo");
		String perfil = resultado.getString("perfil");

		// Cria o usuário
		Usuario usuario = new Usuario(id, nome, login, email,
				senha, ativo, perfil);
		return usuario;
	}

	@Override
	public Usuario buscarPorLogin(String login)
			throws PersistenceException {

		// Usuário de retorno
		Usuario retorno = null;

		// Pega a conexão
		Connection conexao = ConnectionFactory
				.getPostgresConnection();

		String sql = "select * from usuario where login = ?";
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {

			// Passar o login por parâmetro
			ps.setString(1, login);
			
			// Try with resources - fecha sozinho
			try (ResultSet resultado = ps.executeQuery()) {

				// Se houver resultados
				if (resultado.next()) {
					retorno = montarUsuario(resultado);
				}
			}
		} catch (SQLException e) {
			throw new PersistenceException(
					"Erro ao buscar o usuário.", e);
		}

		return retorno;

	}

}
