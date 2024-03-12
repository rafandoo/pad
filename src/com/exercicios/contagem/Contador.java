package com.exercicios.contagem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Contador {

    private static final Set<Integer> numerosExibidos = new HashSet<>();
    private static final int NUM_THREADS = 5;

    private static void contar(int limite) {
        for (int i = 1; i <= limite; i++) {
            synchronized (numerosExibidos) {
                if (!numerosExibidos.contains(i)) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    numerosExibidos.add(i);
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Digite um número maior que 5000: ");
            num = sc.nextInt();
        } while (num < 5000);

        int finalNum = num;
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(() -> contar(finalNum));
            thread.start();
        }
    }
}
