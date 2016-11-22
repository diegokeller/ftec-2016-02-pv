package persistencia.postgres;

import persistencia.DAOFactory;
import persistencia.ProdutoDAO;
import persistencia.UsuarioDAO;

/**
 * Fábrica concreta de DAOs para Postgres.
 * @author Diego
 *
 */
public class PostgresDAOFactory extends DAOFactory {

	@Override
	public ProdutoDAO getProdutoDAO() {
		return new ProdutoPostgresDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioPostgresDAO();
	}

}
