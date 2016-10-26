package com.uniftec.pv.loja.persistencia;

import com.uniftec.pv.loja.persistencia.postgres.PostgresDAOFactory;

/**
 * Fábrica de DAO's. Responsável por criar o DAO certo de 
 * acordo com o banco de dados sendo usado. 
 */
public abstract class DAOFactory {

	// Um get para cada DAO que foi criado
	public abstract UsuarioDAO getUsuarioDAO();
	// public abstract ProdutoDAO getProdutoDAO();

	public static DAOFactory getDAOFactory(){
		return new PostgresDAOFactory();
	}
}
