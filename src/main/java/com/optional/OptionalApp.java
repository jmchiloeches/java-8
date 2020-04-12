package com.optional;

import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        OptionalApp app = new OptionalApp();
        // app.probar(null);
        // app.orElse("Rick");
        // app.orElseThrow("Rick");
        app.isPresent("Rick");
    }

    public void probar(String valor) {
        // System.out.println(valor.contains("Rick"));

        try {
            Optional op = Optional.empty();
            op.get();
        } catch (Exception e) {
            System.out.println("No hay elemento");
        }
    }

    public void orElse(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        String s = op.orElse("Predeterminado");
        System.out.println(s);
    }

    public void orElseThrow(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        op.orElseThrow(NumberFormatException::new);
    }

    public void isPresent(String valor) {
        Optional<String> op = Optional.ofNullable(valor);
        System.out.println(op.isPresent());
    }
}
