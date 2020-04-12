package com.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamApp {

    private List<Integer> numeros;

    public static void main(String[] args) {
        ParallelStreamApp app = new ParallelStreamApp();
        app.llenar();
        // app.probarStream();
        app.probarParalelo();
    }

    public void llenar() {
        numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numeros.add(i);
        }
    }

    private void probarStream() {
        numeros.stream().forEach(System.out::println);
    }

    private void probarParalelo() {
        numeros.parallelStream().forEach(System.out::println);
    }
}
