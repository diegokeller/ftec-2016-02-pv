package singleton;

public class MainTesteSingleton {

	public static void main(String[] args) {
		// Com isso considgo acessar o carrinho de qualquer lugar
		CarrinhoDeCompras.getInstancia().adicionarProduto();
	}
	
}
