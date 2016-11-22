package persistencia;

import persistencia.postgres.PostgresDAOFactory;

/**
 * Fábrica abstrata de DAO's.
 * @author Diego
 *
 */
public abstract class DAOFactory {
	
	/**
	 * Obtém a fábrica de DAO's concreta.
	 * @return
	 */
	public static DAOFactory getDAOFactory(){
		return new PostgresDAOFactory();
	}

	/*
	 * ========================================================================
	 * Tabelas do banco
	 * ========================================================================
	 */
	
	/**
	 * Obtém o DAO que acessa a tabela de produtos.
	 * @return
	 */
	public abstract ProdutoDAO getProdutoDAO();

	
	/**
	 * Obtém o DAO que acessa a tabela de usuarios.
	 * @return
	 */
	public abstract UsuarioDAO getUsuarioDAO();
	

}
