package observer;

import java.util.Observable;
import java.util.Observer;

import singleton.CarrinhoDeCompras;

public class MainExemploObserver {

	public static void main(String[] args) {

		CarrinhoDeCompras.getInstancia().addObserver(new Observer() {

			@Override
			public void update(Observable o, Object arg) {
				System.out.println(
						"Mudou a quantidade de intens do carrinho.");
				CarrinhoDeCompras c = (CarrinhoDeCompras) o;
				System.out.println("Quantidade: " + c.getContador());
			}
		});

		CarrinhoDeCompras.getInstancia().adicionarProduto();
		CarrinhoDeCompras.getInstancia().adicionarProduto();
		CarrinhoDeCompras.getInstancia().adicionarProduto();

	}

}
