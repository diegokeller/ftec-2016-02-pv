package testes;

import java.util.List;

import modelo.Produto;
import persistencia.DAOFactory;
import persistencia.ProdutoDAO;
import excecoes.ErroDeBancoException;

public class MainTesteDAO {

	public static void main(String[] args) {

		try {

			// Pega o DAO
			ProdutoDAO dao = DAOFactory.getDAOFactory().getProdutoDAO();

			// Isere
//			for (int i = 0; i < 50; i++) {
//				System.out.println("Inserindo um produto");
//				Produto produto = new Produto(null, "Abacaxi", "Terra de Areia", 123.45f, 0, true);
//				dao.inserir(produto);
//				System.out.println("OK");
//			}
			
			System.out.println("Inserindo um produto");
			Produto produto = new Produto(null, "Abacaxi", "Terra de Areia", 123.45f, 5, true);
			dao.inserir(produto);
			System.out.println("OK");

			// Busca pelo nome
			System.out.println("Buscando pelo nome");
			List<Produto> produtos = dao.buscar("Abacaxi", true);
			System.out.println(produtos);
			System.out.println("OK");

			// Pega o id do primeiro
			Integer id = produtos.get(0).getId();

			// Busca pelo Id
			System.out.println("Buscando pelo id");
			produto = dao.buscarPorId(id);
			System.out.println(produto);
			System.out.println("OK");

			// Atualiza
			System.out.println("Atualizando um produto");
			produto.setPreco(987.654f);
			dao.atualizar(produto);
			System.out.println("OK");

			// Busca de novo pelo ID para ver a alteração
			produto = dao.buscarPorId(id);
			System.out.println(produto);
			System.out.println("OK");

			System.out.println("FIM");

		} catch (ErroDeBancoException erro) {
			erro.printStackTrace();
		}

	}

}
