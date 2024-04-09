package com.aulas.pad02042024;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

    public static void main(String[] args) {
        PrintTask pt1 = new PrintTask("pt1");
        PrintTask pt2 = new PrintTask("pt2");
        PrintTask pt3 = new PrintTask("pt3");
        System.out.println("Starting executor");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(pt1);
        executorService.execute(pt2);
        executorService.execute(pt3);
        executorService.shutdown();

        System.out.println("Tasks started, main ends.../n");
    }
}
