package threads;

public class MainExemploThreadInterface {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadComInterface());
		t1.start();

		// Com classe anônima
		Runnable r1 = new Runnable() {
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
		};
		Thread t2 = new Thread(r1);
		t2.start();
		
		// Usando Java 8 Lambda Expressions
		Thread t3 = new Thread(() -> {
			while(true){
				System.out.println("Executou com Java 8");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t3.start();

	}

}
