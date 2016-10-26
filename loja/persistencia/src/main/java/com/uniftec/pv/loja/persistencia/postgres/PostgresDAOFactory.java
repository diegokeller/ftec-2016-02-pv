package com.uniftec.pv.loja.persistencia.postgres;

import com.uniftec.pv.loja.persistencia.DAOFactory;
import com.uniftec.pv.loja.persistencia.UsuarioDAO;

public class PostgresDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioPostgresDAO();
	}

}
