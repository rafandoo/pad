package com.aulas.pad19032024;

public class Pessoa extends Thread {

    enum Atividade {
        RAPIDO(1),
        LENTO(2);

        private int value;

        Atividade(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private String nome;
    private Banheiro banheiro;
    private Atividade atividade;

    public Pessoa(String nome, Banheiro banheiro, int atividade) {
        this.nome = nome;
        this.banheiro = banheiro;
//        this.atividade = new Atividade(atividade);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        banheiro.irAoBanheiro(this, atividade);
    }
}
