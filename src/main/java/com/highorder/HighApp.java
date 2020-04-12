package com.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

    private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
    private Function<String, String> convertirMinusculas = x -> x.toLowerCase();

    public static void main(String[] args) {
        HighApp app = new HighApp();
        // app.imprimir(app.convertirMayusculas, "homer");
        // app.imprimir(app.convertirMinusculas, "HOMER");

        // String rpta = app.mostrar("Hola ").apply("Homer");
        // System.out.println(rpta);

        List<String> lista = new ArrayList<>();
        lista.add("Rick");
        lista.add("Homer");
        lista.add("Donald");

        // app.filtrar(lista, System.out::println, 5, null);
        app.filtrar(lista, System.out::println, 0, "Homer");
    }

    public void imprimir(Function<String, String> function, String valor) {
        System.out.println(function.apply(valor));
    }

    public Function<String, String> mostrar(String mensaje) {
        return (String x) -> mensaje + x;
    }

    public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
        lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
    }

    public Predicate<String> establecerLogicaFiltro(int longitud) {
        return texto -> texto.length() < longitud;
    }

    public Predicate<String> establecerLogicaFiltro(String cadena) {
        return texto -> texto.contains(cadena);
    }
}
