package pad27022024;

public class CaraCoroa {
	
	boolean flag;
	
	synchronized void cara (boolean running) {
		if(!running) {
			this.flag = true;
			notify();
			return;
		}
		System.out.print("Cara ");
		this.flag = true;
		notify();
		try {
			while (this.flag) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void coroa (boolean running) {
		if(!running) {
			this.flag = false;
			notify();
			return;
		}
		System.out.println("Coroa");
		this.flag = false;
		notify();
		try {
			while (!this.flag) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
