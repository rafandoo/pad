package pad27022024;

public class ThreadIsAliveMain extends Thread {
	public static void main(String[] args) {
		ThreadIsAlive t = new ThreadIsAlive();
		t.start();
		while (t.isAlive()) {
			System.out.println("Thread ativa");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Thread inativa");
	}
}
