package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionApp {

    private List<String> lista;

    public static void main(String[] args) {

        CollectionApp app = new CollectionApp();
        app.llenarLista();
        app.usarSort();
        app.usarForEach();
        app.usarRemoveIf();
        app.usarForEach();
    }

    public void llenarLista() {

        lista = new ArrayList<>();
        lista.add("Rick");
        lista.add("Homer");
        lista.add("Donald");
    }

    public void usarForEach() {
        /*
        for (String elemento : lista) {
            System.out.println(elemento);
        }
        */

        // Lambda
        // lista.forEach(x -> System.out.println(x));

        // Referencias a métodos
        lista.forEach(System.out::println);
    }

    public void usarRemoveIf() {
        /*
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase("Homer")) {
                it.remove();
            }
        }
        */

        lista.removeIf(x -> x.equalsIgnoreCase("Homer"));
    }

    public void usarSort() {
        Collections.sort(lista);
        lista.sort((x, y) -> x.compareTo(y));
    }
}

