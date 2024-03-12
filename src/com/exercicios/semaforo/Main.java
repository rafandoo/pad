package com.exercicios.semaforo;

public class Main {
    public static void main(String[] args) {
        Semaforo semaforos = new Semaforo();

        for (int i = 0; i < Semaforo.VIAS; i++) {
            Thread thread = new SemaforoThread(semaforos, i);
            thread.start();
        }
    }
}