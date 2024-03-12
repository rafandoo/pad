package pad27022024;

public class CalcNotSync implements Runnable {

	private int[] lista;
	private String nome;
	private static CalcNotSync_Calc calc = new CalcNotSync_Calc();
	
	public CalcNotSync(String nome, int[] lista) {
		this.nome = nome;
		this.lista = lista;
		new Thread(this, nome).start();
	}
	
	@Override
	public void run() {
		System.out.println("Inicio de " + this.nome);
		int soma = calc.somaLista(this.lista);
		System.out.println("Fim de " + this.nome + " - soma = " + soma);
	}
	
}
