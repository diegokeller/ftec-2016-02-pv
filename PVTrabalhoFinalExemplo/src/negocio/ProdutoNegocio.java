package negocio;

import java.util.List;

import modelo.Produto;
import persistencia.DAOFactory;
import persistencia.ProdutoDAO;
import excecoes.ErroDeBancoException;
import excecoes.ErroDeNegocioException;

public class ProdutoNegocio {
	
	/**
	 * Valida os campos do produto e salva.
	 * @param produto
	 * @throws ErroDeNegocioException
	 */
	public void salvar(Produto produto) throws ErroDeNegocioException{
		
		// Campos obrigatórios
		if(produto.getNome() == null){
			throw new ErroDeNegocioException("O campo nome é obrigatório.");
		}
		if(produto.getDescricao() == null){
			throw new ErroDeNegocioException("O campo descrição é obrigatório.");
		}
		if(produto.getPreco() == null){
			throw new ErroDeNegocioException("O campo preço é obrigatório.");
		}
		if(produto.getQuantidadeEstoque() == null){
			throw new ErroDeNegocioException("O campo quantidade em estoque é obrigatório.");
		}
		if(produto.getAtivo() == null){
			throw new ErroDeNegocioException("O campo ativo é obrigatório.");
		}
		
		// Validações de negócio
		if(produto.getQuantidadeEstoque() < 0){
			throw new ErroDeNegocioException("Quantidade em estoque não pode ser negativa.");
		}
		
		// Pega o DAO
		ProdutoDAO dao = DAOFactory.getDAOFactory().getProdutoDAO();
		
		// Salva
		try {
			if(produto.getId() == null){
				dao.inserir(produto);
			} else {
				dao.atualizar(produto);
			}
		} catch (ErroDeBancoException e) {
			throw new ErroDeNegocioException("Erro de banco de dados", e);
		}
		
	}
	
	/**
	 * Exclui o produto.
	 * @param id
	 * @throws ErroDeNegocioException
	 */
	public void excluir(Integer id) throws ErroDeNegocioException {
		try {
			ProdutoDAO dao = DAOFactory.getDAOFactory().getProdutoDAO();
			dao.excluir(id);
		} catch (ErroDeBancoException e) {
			throw new ErroDeNegocioException("Erro de banco de dados", e);
		}
	}
	
	/**
	 * Busca um produto por id.
	 * @param id
	 * @return
	 * @throws ErroDeNegocioException
	 */
	public Produto buscarPorId(Integer id) throws ErroDeNegocioException {
		try {
			ProdutoDAO dao = DAOFactory.getDAOFactory().getProdutoDAO();
			Produto produto = dao.buscarPorId(id);
			return produto;
		} catch (ErroDeBancoException e) {
			throw new ErroDeNegocioException("Erro de banco de dados", e);
		}
	}

	/**
	 * Busca produtos.
	 * @param nome
	 * @param disponivelEmEstoque
	 * @return
	 * @throws ErroDeNegocioException
	 */
	public List<Produto> buscar(String nome, Boolean disponivelEmEstoque) throws ErroDeNegocioException {
		try {
			ProdutoDAO dao = DAOFactory.getDAOFactory().getProdutoDAO();
			List<Produto> produtos = dao.buscar(nome, disponivelEmEstoque);
			return produtos;
		} catch (ErroDeBancoException e) {
			throw new ErroDeNegocioException("Erro de banco de dados", e);
		}
	}

}
