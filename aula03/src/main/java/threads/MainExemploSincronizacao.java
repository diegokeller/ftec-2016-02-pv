package threads;

public class MainExemploSincronizacao {

	public static void main(String[] args) throws InterruptedException {
		
		ProcessoLongo p1 = new ProcessoLongo();
		ProcessoLongo p2 = new ProcessoLongo();
		ProcessoLongo p3 = new ProcessoLongo();
		
		p1.start();
		p2.start();
		p3.start();
		
		// Sincronizar threads
		p1.join();
		p2.join();
		p3.join();
		
		System.out.println("FIM");
		
	}

}
