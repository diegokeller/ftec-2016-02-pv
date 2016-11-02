package com.uniftec.pv.loja.persistencia;

import java.sql.Connection;

import com.uniftec.pv.loja.persistencia.postgres.PostgresDAOFactory;

/**
 * Fábrica de DAO's. Responsável por criar o DAO certo de 
 * acordo com o banco de dados sendo usado. 
 */
public abstract class DAOFactory {

	// Um get para cada DAO que foi criado
	public abstract UsuarioDAO getUsuarioDAO(Connection conexao);
	// public abstract ProdutoDAO getProdutoDAO(Connection conexao);

	public static DAOFactory getDAOFactory(){
		return new PostgresDAOFactory();
	}
}
