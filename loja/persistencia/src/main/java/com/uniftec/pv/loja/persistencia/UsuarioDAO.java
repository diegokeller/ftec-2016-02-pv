package com.uniftec.pv.loja.persistencia;

import java.util.List;

import com.uniftec.pv.loja.modelo.Usuario;

/**
 * Interface que define o padrão de acesso a tabela de 
 * usuário, independente do banco de dados.
 */
public interface UsuarioDAO {
	
	public void inserir(Usuario usuario) throws PersistenceException;
	public void atualizar(Usuario usuario) throws PersistenceException;
	public void excluir(Integer id) throws PersistenceException;
	public Usuario buscar(Integer id) throws PersistenceException;
	public List<Usuario> buscarTodos() throws PersistenceException;

}
