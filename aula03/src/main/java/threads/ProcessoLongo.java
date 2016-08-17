package threads;

public class ProcessoLongo extends Thread {

	@Override
	public void run() {
		int quantidade = (int)(Math.random() * 10) + 1;
		System.out.println(this.toString() + 
				" vai processar " + quantidade);
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Processando " + this.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
