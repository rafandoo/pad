package pad27022024;

public class AltaPrioridade extends Thread {
	
	@Override
	public void run() {
		setPriority(10);
		for(int i = 0; i < 10; i++) {
			System.out.println("Alta prioridade...");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
