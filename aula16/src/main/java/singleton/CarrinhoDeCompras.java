package singleton;

import java.util.Observable;

// Herdar de Observable
// Objeto que está sendo observado
public class CarrinhoDeCompras extends Observable {

	// Um atributo para guardar a instância
	private static CarrinhoDeCompras instancia = new CarrinhoDeCompras();
	
	private Integer contador = 0;

	// Construtor privado, só essa classe acessa
	private CarrinhoDeCompras() {

	}

	// Getter para acessar de fora.
	public static CarrinhoDeCompras getInstancia() {
		return instancia;
	}

	public void adicionarProduto() {
		contador++;
		instancia.notifyObservers();
	}
	
	public Integer getContador() {
		return contador;
	}

}
