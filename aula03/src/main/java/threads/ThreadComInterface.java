package threads;

public class ThreadComInterface implements Runnable {

	public void run() {

		while(true){
			System.out.println("Executou " + this.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
