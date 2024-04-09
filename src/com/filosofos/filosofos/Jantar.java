package com.filosofos.filosofos;

public class Jantar {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();

        new Filosofo("Socrates", mesa, 1).start();
        new Filosofo("Platão", mesa, 2).start();
        new Filosofo("Thales", mesa, 3).start();
        new Filosofo("Maquiavel", mesa, 4).start();
        new Filosofo("Hobbes", mesa, 5).start();
    }
}
