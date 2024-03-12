package com.aulas.pad;

public class Main {

	public static void main(String[] args) {
//		new Teste1().start();
//		new Thread(new Teste2()).start();
//		new Thread(new Imprimir1("A")).start();
//		new Thread(new Imprimir1("B")).start();
		
//		new Thread1().start();
//		new Thread2().start();

		ThreadJ1 t1 = new ThreadJ1();
		ThreadJ2 t2 = new ThreadJ2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main morreu");
	}

}
