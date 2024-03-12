package pad27022024;

public class ThreadIsAlive extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println(i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
