package pad27022024;

public class CaraCoroaMain {

	public static void main(String[] args) {
		CaraCoroa cc = new CaraCoroa();
		ThreadCC cara = new ThreadCC("Cara", cc);
		ThreadCC coroa = new ThreadCC("Coroa", cc);
		try {
			cara.t.join();
			coroa.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
