package pad27022024;

public class Main {

	public static void main(String[] args) {
//		AltaPrioridade ap = new AltaPrioridade();
//		BaixaPrioridade bp = new BaixaPrioridade();
//		System.out.println("Iniciando threads...");
//		bp.start();
//		ap.start();
//		Thread.currentThread();
//		Thread.yield();
//		System.out.println("F for Main");
		
		int[] lista = {1,2,3};
		CalcNotSync c1 = new CalcNotSync("T1", lista);
		CalcNotSync c2 = new CalcNotSync("T2", lista);
 
	}

}
