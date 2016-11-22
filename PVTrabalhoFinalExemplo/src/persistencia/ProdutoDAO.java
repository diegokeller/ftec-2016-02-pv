package persistencia;

import java.sql.SQLException;
import java.util.List;

import modelo.Produto;
import excecoes.ErroDeBancoException;

/**
 * Interface do DAO de produtos.
 * Tem todas as operações que podem ser feitas com a tabela de produto.
 * @author Diego
 *
 */
public interface ProdutoDAO {

	/**
	 * Insere o produto.
	 * @param p
	 * @throws SQLException
	 */
	public void inserir(Produto p) throws ErroDeBancoException;
	
	/**
	 * Atualiza as informações do produto.
	 * Já deve ter um id.
	 * @param p
	 */
	public void atualizar(Produto p) throws ErroDeBancoException;

	/**
	 * Exclui o produto com o id informado.
	 * @param id
	 */
	public void excluir(Integer id) throws ErroDeBancoException;

	/**
	 * Busca um produto pelo seu id.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Produto buscarPorId(Integer id) throws ErroDeBancoException;
	
	/**
	 * Busca produtos de acordo com os critérios de pesquisa.
	 * @return
	 * @throws SQLException
	 */
	public List<Produto> buscar(String nome, Boolean disponivelEmEstoque) throws ErroDeBancoException;
	
}
