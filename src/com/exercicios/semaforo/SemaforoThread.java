package com.exercicios.semaforo;

class SemaforoThread extends Thread {
    private Semaforo semaforos;
    private int via;

    public SemaforoThread(Semaforo semaforos, int via) {
        this.semaforos = semaforos;
        this.via = via;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            via = (via + 1) % Semaforo.VIAS;
            semaforos.abrirVia(via);
        }
    }
}