package com.exercicios.corrida;

import java.util.Random;

public class Corredor implements Runnable {

    private final int CHEGADA = 100;
    private final int TEMPO_SLEEP = 1000;
    private String nome;
    private int posicao;

    public Corredor(String nome) {
        this.nome = nome;
        this.posicao = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (this.posicao < this.CHEGADA) {
            try {
                Thread.sleep(this.TEMPO_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.posicao += random.nextInt(10);
            System.out.println(this.nome + " está na posição: " + this.posicao);
        }
        System.out.println(this.nome + " chegou no final!");
        System.exit(0);
    }
}