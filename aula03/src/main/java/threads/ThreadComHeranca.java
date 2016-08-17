package threads;

/**
 * Criando uma thread herdando de "Thread". 
 */
public class ThreadComHeranca extends Thread {

	private String nome;
	
	public ThreadComHeranca(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public void run() {
		while(true){
			System.out.println(nome);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
