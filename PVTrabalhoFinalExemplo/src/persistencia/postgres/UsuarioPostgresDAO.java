package persistencia.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;
import persistencia.ConnectionFactory;
import persistencia.UsuarioDAO;
import excecoes.ErroDeBancoException;

public class UsuarioPostgresDAO implements UsuarioDAO {

	@Override
	public void inserir(Usuario p) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "insert into usuario(nome, login, email, senha, perfil, ativo) values (?,?,?,?,?::perfil_enum,?)";
		PreparedStatement ps = null;
		try {

			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Define os parâmetros
			ps.setString(1, p.getNome());
			ps.setString(2, p.getLogin());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getSenha());
			ps.setString(5, p.getPerfil());
			ps.setBoolean(6, p.getAtivo());
			
			// Executa
			ps.execute();

		} catch (SQLException e) {
			throw new ErroDeBancoException(
					"Erro ao inserir o Usuario no banco de dados.", e);
		} finally {
			// Libera os recursos sendo usados
			try {
				if (ps != null) {
					ps.close();
				}
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar o comando ou conexão com o banco de dados.");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void atualizar(Usuario p) throws ErroDeBancoException {

//		// Pega a conexão
//		Connection conexao = ConnectionFactory.getPostgresConnection();
//
//		// Monta o SQL
//		String sql = "update Usuario set nome = ?, descricao = ?, preco = ?, quantidade_estoque = ?, ativo = ? where id = ?";
//		PreparedStatement ps = null;
//		try {
//
//			// Cria um comando
//			ps = conexao.prepareStatement(sql);
//
//			// Define os parâmetros
//			ps.setString(1, p.getNome());
//			ps.setString(2, p.getDescricao());
//			ps.setFloat(3, p.getPreco());
//			ps.setInt(4, p.getQuantidadeEstoque());
//			ps.setBoolean(5, p.getAtivo());
//			ps.setInt(6, p.getId());
//
//			// Executa
//			ps.execute();
//
//		} catch (SQLException e) {
//			throw new ErroDeBancoException("Erro ao atualizar o Usuario no banco de dados.", e);
//		} finally {
//			// Libera os recursos sendo usados
//			try {
//				if (ps != null) {
//					ps.close();
//				}
//				conexao.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao fechar o comando ou conexão com o banco de dados.");
//				e.printStackTrace();
//			}
//		}

	}

	@Override
	public void excluir(Integer id) throws ErroDeBancoException {

//		// Pega a conexão
//		Connection conexao = ConnectionFactory.getPostgresConnection();
//
//		// Monta o SQL
//		String sql = "delete from Usuario where id = ?";
//		PreparedStatement ps = null;
//		try {
//
//			// Cria um comando
//			ps = conexao.prepareStatement(sql);
//
//			// Define os parâmetros
//			ps.setInt(1, id);
//
//			// Executa
//			ps.execute();
//
//		} catch (SQLException e) {
//			throw new ErroDeBancoException("Erro ao excluir o Usuario no banco de dados.", e);
//		} finally {
//			// Libera os recursos sendo usados
//			try {
//				if (ps != null) {
//					ps.close();
//				}
//				conexao.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao fechar o comando ou conexão com o banco de dados.");
//				e.printStackTrace();
//			}
//		}

	}

	@Override
	public Usuario buscarPorId(Integer id) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "select * from Usuario where id = ?";

		PreparedStatement ps = null;
		Usuario Usuario = null;
		ResultSet resultado = null;
		try {

			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Define os parâmetros
			ps.setInt(1, id);

			// Executa a consulta
			resultado = ps.executeQuery();

			// Verifica se tem resultados
			if (resultado.next()) {

				// Monta o modelo
				Usuario = montarModelo(resultado);

			}
		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao buscar o Usuario por id.", e);
		} finally {
			// Libera os recursos sendo usados
			try {
				if (ps != null) {
					ps.close();
				}
				if (resultado != null) {
					resultado.close();
				}
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar o comando ou conexão com o banco de dados.");
				e.printStackTrace();
			}
		}

		// Retorna o Usuario
		return Usuario;
	}

	@Override
	public List<Usuario> buscar(String nome, Boolean ativo) throws ErroDeBancoException {
		return null;

//		// Pega a conexão
//		Connection conexao = ConnectionFactory.getPostgresConnection();
//
//		// Atribui valor padrão se estiver nulo
//		if (nome == null) {
//			nome = "";
//		}
//
//		// Monta o SQL
//		String sql = "select * from Usuario where nome like ? ";
//		if (Boolean.TRUE.equals(disponivelEmEstoque)) {
//			sql += " and quantidade_estoque > 0";
//		}
//		if (Boolean.FALSE.equals(disponivelEmEstoque)) {
//			sql += " and quantidade_estoque = 0";
//		}
//
//		PreparedStatement ps = null;
//		List<Usuario> Usuarios = new LinkedList<Usuario>();
//		ResultSet resultado = null;
//		try {
//			// Cria um comando
//			ps = conexao.prepareStatement(sql);
//
//			// Passa os parâmetros
//			ps.setString(1, "%" + nome + "%");
//			
//			// Executa a consulta
//			resultado = ps.executeQuery();
//
//			// Enquando houver resultados
//			while (resultado.next()) {
//
//				// Monta o modelo e adiciona na lista
//				Usuario Usuario = montarModelo(resultado);
//				Usuarios.add(Usuario);
//
//			}
//		} catch (SQLException e) {
//			throw new ErroDeBancoException("Erro ao buscar os Usuarios.", e);
//		} finally {
//			// Libera os recursos sendo usados
//			try {
//				if (ps != null) {
//					ps.close();
//				}
//				if (resultado != null) {
//					resultado.close();
//				}
//				conexao.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao fechar o comando ou conexão com o banco de dados.");
//				e.printStackTrace();
//			}
//		}
//
//		// Retorna a lista de Usuarios encontrados
//		return Usuarios;
	}

	/**
	 * Monta um modelo a partir de um resultado de uma consulta.
	 * 
	 * @param resultado
	 * @return
	 * @throws SQLException
	 */
	private Usuario montarModelo(ResultSet resultado) throws SQLException {

		Integer idUsuario = resultado.getInt("id");
		String nome = resultado.getString("nome");
		String login = resultado.getString("login");
		String email = resultado.getString("email");
		String senha = resultado.getString("senha");
		String perfil = resultado.getString("perfil");
		Boolean ativo = resultado.getBoolean("ativo");

		return new Usuario(idUsuario, nome, login, email, senha, perfil, ativo);
	}

}
