package com.aulas.pad26032024;

public class Main {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro(1);
        Thread t1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread t2 = new Thread(new TarefaNumero2(banheiro), "Maria");
        Thread t3 = new Thread(new TarefaNumero1(banheiro), "Pedro");
        Thread t4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
