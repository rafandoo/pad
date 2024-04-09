package com.aulas.pad26032024;

import java.util.concurrent.Semaphore;

public class Banheiro {

    private Semaphore semaphore;

    public Banheiro(int permissoes) {
        this.semaphore = new Semaphore(permissoes);
    }

    public void fazNumero1() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String nome = Thread.currentThread().getName();
        System.out.println(nome + " entrando no banheiro");
        System.out.println(nome + " iniciando atividade rapida");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nome + " terminando atividade rapida");
        System.out.println(nome + " saindo do banheiro");

//        semaphore.release();
    }

    public void fazNumero2() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " entrando no banheiro");
        System.out.println(nome + " iniciando atividade lenta");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nome + " terminando atividade lenta");
        System.out.println(nome + " saindo do banheiro");

//        semaphore.release();
    }
}
