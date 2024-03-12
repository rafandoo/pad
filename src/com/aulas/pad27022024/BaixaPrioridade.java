package pad27022024;

public class BaixaPrioridade extends Thread {
	
	@Override
	public void run() {
		setPriority(1);
		for(int i = 0; i < 10; i++) {
			System.out.println("Baixa prioridade...");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

}
