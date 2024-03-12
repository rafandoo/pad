package com.exercicios.corrida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos corredores irão participar? ");
        int numCorredores = sc.nextInt();
        if (numCorredores < 2) {
            System.out.println("Quantidade de corredores inválida. Encerrando...");
            System.exit(0);
        }

        List<Corredor> corredores = new ArrayList<>();
        for (int i = 0; i < numCorredores; i++) {
            System.out.print("Nome do corredor " + (i + 1) + ": ");
            String nome = sc.next();
            corredores.add(new Corredor(nome));
        }

        System.out.println("\n***** Corrida iniciada *****");
        for (Corredor corredor : corredores) {
            new Thread(corredor).start();
        }
    }
}