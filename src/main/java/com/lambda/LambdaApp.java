package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaApp {

    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.ordenar();
        app.calcular();
    }

    public void ordenar() {

        List<String> lista = new ArrayList<>();
        lista.add("Rick");
        lista.add("Homer");
        lista.add("Donald");

        // JDK < 1.7
        /*
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        */

        // Lambda
        Collections.sort(lista, (p1, p2) -> p1.compareTo(p2));

        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    public void calcular() {

        // JDK 1.7
        /*
        Operacion op = new Operacion() {
            @Override
            public double calcular(double n1, double n2) {
                return (n1 + n2) / 2;
            }
        };

        System.out.println(op.calcular(2, 3));
        */

        Operacion op2 = (x, y) -> (x + y) / 2;
        System.out.println(op2.calcular(2, 3));
    }
}
