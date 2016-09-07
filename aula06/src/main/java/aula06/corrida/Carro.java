package aula06.corrida;

public class Carro {

	private int posicaoY;
	private int posicaoX;
	private String caminhoImagem;

	public Carro(String caminhoImagem) {
		super();
		this.posicaoY = 0;
		this.posicaoX = (int)(Math.random() * 400);
		if(posicaoX < 50){
			posicaoX = 50;
		}
		this.caminhoImagem = caminhoImagem;
	}

	public int getPosicaoY() {
		return posicaoY;
	}
	
	public int getPosicaoX() {
		return posicaoX;
	}

	public void deslocar() {
		this.posicaoY += 5;
	}
	
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	
	

}
