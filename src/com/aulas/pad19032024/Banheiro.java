package com.aulas.pad19032024;

public class Banheiro {

    public int tempoAtividade(int atividade) {
        if (atividade == 1) {
            return 1000;
        } else {
            return 5000;
        }
    }

    public synchronized void irAoBanheiro(Pessoa pessoa, Pessoa.Atividade atividade) {
        try {
            System.out.println("O " + pessoa.getNome() + " entrou no banheiro");
            System.out.println("Iniciando atividade " + atividade.getValue());
            Thread.sleep(tempoAtividade(atividade.getValue()));

            System.out.println("O " + pessoa.getNome() + " saiu do banheiro");
        } catch (InterruptedException e) {
            System.out.println("O " + pessoa.getNome() + " ficou triste");
        }
    }
}
