package com.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

    private List<String> lista;
    private List<String> numeros;

    public StreamsApp() {
        lista = new ArrayList<>();
        lista.add("Rick");
        lista.add("Homer");
        lista.add("Donald");
        lista.add("Peter");

        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
    }

    public static void main(String[] args) {
        StreamsApp app = new StreamsApp();
        // app.filtrar();
        // app.ordenar();
        // app.transformar();
        // app.limitar();
        app.contar();
    }

    public void filtrar() {
        lista.stream().filter(x -> x.startsWith("H")).forEach(System.out::println);
    }

    public void ordenar() {
        // Ascendente
        // lista.stream().sorted().forEach(System.out::println);

        // Descendente
        lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }

    public void transformar() {
        // Función Mapper: Transformar los elementos de la colección a traves de la expresión que indiquemos com parametro
        // lista.stream().map(String::toUpperCase).forEach(System.out::println);

        /*
        for (String x : numeros) {
            int num = Integer.parseInt(x) + 1;
            System.out.println(num);
        }
        */

        numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    public void limitar() {
        lista.stream().limit(2).forEach(System.out::println);
    }

    public void contar() {
        long x = lista.stream().count();
        System.out.println(x);
    }
}
