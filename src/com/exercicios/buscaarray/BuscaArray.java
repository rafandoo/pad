package com.exercicios.buscaarray;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BuscaArray {

    public static int buscar(int[] array, int x, int numThreads) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        int tamanhoTrecho = array.length / numThreads;
        AtomicBoolean encontrado = new AtomicBoolean(false);

        try {
            for (int i = 0; i < numThreads; i++) {
                final int inicio = i * tamanhoTrecho;
                final int fim = (i == numThreads - 1) ? array.length : (i + 1) * tamanhoTrecho;

                Callable<Integer> buscaCallable = () -> {
                    for (int j = inicio; j < fim && !encontrado.get(); j++) {
                        if (array[j] == x) {
                            encontrado.set(true);
                            return j;
                        }
                    }
                    return -1;
                };

                Future<Integer> resultado = executorService.submit(buscaCallable);

                int indiceEncontrado = resultado.get();
                if (indiceEncontrado != -1) {
                    return indiceEncontrado;
                }
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

        return -1;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int x = 50;
        int numThreads = 4;

        int resultado = buscar(array, x, numThreads);

        if (resultado != -1) {
            System.out.println("Encontrado " + x + " no índice " + resultado);
        } else {
            System.out.println("Não foi encontrado " + x);
        }
    }
}
