package com.aulas.pad;

public class Thread2 extends Thread {
	
	@Override
	public void run() {
		for(int x=0;x<5;x++) {
			System.out.print("T2 | ");
			Thread.currentThread();
			Thread.yield();
		}
	}

}
