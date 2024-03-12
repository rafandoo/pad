package com.exercicios.contadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ContadoresFrame extends JFrame {
    private JButton startA, pauseA, stopA, startB, pauseB, stopB;
    private JLabel labelA, labelB;
    private int contadorA, contadorB;
    private volatile boolean pausedA, pausedB;

    public ContadoresFrame() {
        setTitle("Contadores");
        setLayout(new GridLayout(3, 2));

        startA = new JButton("Start A");
        pauseA = new JButton("Pause A");
        stopA = new JButton("Stop A");
        startB = new JButton("Start B");
        pauseB = new JButton("Pause B");
        stopB = new JButton("Stop B");

        labelA = new JLabel("Contador A: 0");
        labelB = new JLabel("Contador B: 0");

        JPanel panelA = new JPanel();
        panelA.setLayout(new FlowLayout());
        panelA.add(startA);
        panelA.add(pauseA);
        panelA.add(stopA);

        JPanel panelB = new JPanel();
        panelB.setLayout(new FlowLayout());
        panelB.add(startB);
        panelB.add(pauseB);
        panelB.add(stopB);

        add(panelA);
        add(labelA);
        add(panelB);
        add(labelB);

        contadorA = 0;
        contadorB = 0;
        pausedA = false;
        pausedB = false;

        startA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedA = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            if (pausedA || !stopA.isEnabled()) {
                                break;
                            }
                            contadorA++;
                            labelA.setText("Contador A: " + contadorA);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        pauseA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedA = true;
            }
        });

        stopA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedA = false;
                contadorA = 0;
                labelA.setText("Contador A: " + contadorA);
            }
        });

        startB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedB = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            if (pausedB || !stopB.isEnabled()) {
                                break;
                            }
                            contadorB++;
                            labelB.setText("Contador B: " + contadorB);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        pauseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedB = true;
            }
        });

        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausedB = false;
                contadorB = 0;
                labelB.setText("Contador B: " + contadorB);
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ContadoresFrame();
    }
}
