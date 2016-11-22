package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import excecoes.ErroDeBancoException;

/**
 * Fábrica de conexões com banco de dados.
 * 
 * @author Diego
 *
 */
public class ConnectionFactory {

	/**
	 * Pega uma conexão com o Postgres
	 * 
	 * @throws ErroDeBancoException
	 * 
	 * @throws SQLException
	 */
	public static Connection getPostgresConnection() throws ErroDeBancoException {

		// Carrega o driver JDBC
		// Esse passo é opcional depois do JDBC4
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new ErroDeBancoException("Classe do driver não encontrada." + "Verifique o caminho.", e);
		}

		// String de conexão com o banco de dados
		String stringConexao = "jdbc:postgresql://localhost:5432/ftec_pedidos";
		String usuario = "postgres";
		String senha = "postgres";

		// Conecta no banco
		Connection conexao;
		try {
			conexao = DriverManager.getConnection(stringConexao, usuario, senha);
		} catch (SQLException e) {
			throw new ErroDeBancoException("Erro ao obter a conexão com o banco de dados. "
					+ "Verifique se o banco está no ar ou se os dados de conexão estão corretos.", e);
		}

		return conexao;
	}

}
