package pad27022024;

public class ThreadCC implements Runnable {
	CaraCoroa cc;
	Thread t;
	final int NUM = 10;
	
	public ThreadCC(String nome, CaraCoroa cc) {
		this.cc = cc;
		t = new Thread(this, nome);
		t.start();
	}
	
	@Override
	public void run() {
		if(t.getName().equalsIgnoreCase("Cara")) {
			for(int i = 0; i < this.NUM; i++) {
				cc.cara(true);
			}
			cc.cara(false);
		} else {
			for(int i = 0; i < this.NUM; i++) {
				cc.coroa(true);
			}
			cc.coroa(false);
		}
		
	}

}
