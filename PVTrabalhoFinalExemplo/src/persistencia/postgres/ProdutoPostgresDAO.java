package persistencia.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Produto;
import persistencia.ConnectionFactory;
import persistencia.ProdutoDAO;
import excecoes.ErroDeBancoException;

public class ProdutoPostgresDAO implements ProdutoDAO {

	@Override
	public void inserir(Produto p) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "insert into produto(nome, descricao, " + "preco, quantidade_estoque, ativo) " + "values (?,?,?,?,?)";
		PreparedStatement ps = null;
		try {

			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Define os parâmetros
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setFloat(3, p.getPreco());
			ps.setInt(4, p.getQuantidadeEstoque());
			ps.setBoolean(5, p.getAtivo());

			// Executa
			ps.execute();

		} catch (SQLException e) {
			throw new ErroDeBancoException(
					"Erro ao inserir o produto no banco de dados.", e);
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
	public void atualizar(Produto p) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "update produto set nome = ?, descricao = ?, preco = ?, quantidade_estoque = ?, ativo = ? where id = ?";
		PreparedStatement ps = null;
		try {

			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Define os parâmetros
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setFloat(3, p.getPreco());
			ps.setInt(4, p.getQuantidadeEstoque());
			ps.setBoolean(5, p.getAtivo());
			ps.setInt(6, p.getId());

			// Executa
			ps.execute();

		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao atualizar o produto no banco de dados.", e);
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
	public void excluir(Integer id) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "delete from produto where id = ?";
		PreparedStatement ps = null;
		try {

			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Define os parâmetros
			ps.setInt(1, id);

			// Executa
			ps.execute();

		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao excluir o produto no banco de dados.", e);
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
	public Produto buscarPorId(Integer id) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Monta o SQL
		String sql = "select * from produto where id = ?";

		PreparedStatement ps = null;
		Produto produto = null;
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
				produto = montarModelo(resultado);

			}
		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao buscar o produto por id.", e);
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

		// Retorna o produto
		return produto;
	}

	@Override
	public List<Produto> buscar(String nome, Boolean disponivelEmEstoque) throws ErroDeBancoException {

		// Pega a conexão
		Connection conexao = ConnectionFactory.getPostgresConnection();

		// Atribui valor padrão se estiver nulo
		if (nome == null) {
			nome = "";
		}

		// Monta o SQL
		String sql = "select * from produto where nome like ? ";
		if (Boolean.TRUE.equals(disponivelEmEstoque)) {
			sql += " and quantidade_estoque > 0";
		}
		if (Boolean.FALSE.equals(disponivelEmEstoque)) {
			sql += " and quantidade_estoque = 0";
		}

		PreparedStatement ps = null;
		List<Produto> produtos = new LinkedList<Produto>();
		ResultSet resultado = null;
		try {
			// Cria um comando
			ps = conexao.prepareStatement(sql);

			// Passa os parâmetros
			ps.setString(1, "%" + nome + "%");
			
			// Executa a consulta
			resultado = ps.executeQuery();

			// Enquando houver resultados
			while (resultado.next()) {

				// Monta o modelo e adiciona na lista
				Produto produto = montarModelo(resultado);
				produtos.add(produto);

			}
		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao buscar os produtos.", e);
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

		// Retorna a lista de produtos encontrados
		return produtos;
	}

	/**
	 * Monta um modelo a partir de um resultado de uma consulta.
	 * 
	 * @param resultado
	 * @return
	 * @throws SQLException
	 */
	private Produto montarModelo(ResultSet resultado) throws SQLException {

		Integer idProduto = resultado.getInt("id");
		String nome = resultado.getString("nome");
		String descricao = resultado.getString("descricao");
		Float preco = resultado.getFloat("preco");
		Integer quantidadeEstoque = resultado.getInt("quantidade_estoque");
		Boolean ativo = resultado.getBoolean("ativo");

		return new Produto(idProduto, nome, descricao, preco, quantidadeEstoque, ativo);
	}

}
