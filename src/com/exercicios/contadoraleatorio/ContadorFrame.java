package com.exercicios.contadoraleatorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class ContadoresFrame extends JFrame {
    private JButton incrementarBtn, decrementarBtn;
    private JLabel label;
    private int contador;

    public ContadoresFrame() {
        setTitle("Contador Compartilhado");
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        incrementarBtn = new JButton("Incrementar +");
        decrementarBtn = new JButton("Decrementar -");

        label = new JLabel("Contador: 0");

        add(incrementarBtn);
        add(decrementarBtn);
        add(label);

        contador = 0;

        incrementarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = gerarNumeroAleatorio();
                incrementarContador(valor);
            }
        });

        decrementarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = gerarNumeroAleatorio();
                decrementarContador(valor);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int gerarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private synchronized void incrementarContador(int valor) {
        contador += valor;
        atualizarLabel();
    }

    private synchronized void decrementarContador(int valor) {
        contador -= valor;
        atualizarLabel();
    }

    private void atualizarLabel() {
        label.setText("Contador: " + contador);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContadoresFrame::new);
    }
}
