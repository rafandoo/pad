package pad27022024;

public class CalcNotSync_Calc {

	private int soma;
	public int somaLista(int[] lista) {
		synchronized (this) {			
			soma = 0;
			for (int i = 0; i < lista.length; i++) {
				soma += lista[i];
				System.out.println(Thread.currentThread().getName() + " - somando " + lista[i] + " - total = " + soma);;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return soma;
		}
	}
	
}
