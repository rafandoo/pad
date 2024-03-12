package com.exercicios.semaforo;

class Semaforo {
    public static final int VIAS = 4;

    private enum CorSemaforo {
        VERMELHO, AMARELO, VERDE
    }

    private CorSemaforo[] semaforos;

    public Semaforo() {
        semaforos = new CorSemaforo[VIAS];
        for (int i = 0; i < VIAS; i++) {
            semaforos[i] = CorSemaforo.VERMELHO;
        }
    }

    public synchronized void abrirVia(int via) {
        for (int i = 0; i < VIAS; i++) {
            semaforos[i] = CorSemaforo.VERMELHO;
        }

        semaforos[via] = CorSemaforo.VERDE;

        mostrarSituacao();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaforos[via] = CorSemaforo.AMARELO;
        mostrarSituacao();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaforos[via] = CorSemaforo.VERMELHO;
        mostrarSituacao();
    }

    private void mostrarSituacao() {
        for (int i = 0; i < VIAS; i++) {
            System.out.println("Via " + (i + 1) + ": " + semaforos[i]);
        }
        System.out.println("--------------");
    }
}