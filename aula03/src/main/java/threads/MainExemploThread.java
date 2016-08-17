package threads;

public class MainExemploThread {

	public static void main(String[] args) {

		ThreadComHeranca t1 = new ThreadComHeranca("Thread 1");
		ThreadComHeranca t2 = new ThreadComHeranca("Thread 2");
		ThreadComHeranca t3 = new ThreadComHeranca("Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
