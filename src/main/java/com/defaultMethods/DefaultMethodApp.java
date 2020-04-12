package com.defaultMethods;

public class DefaultMethodApp implements PersonaA, PersonaB {

    public static void main(String[] args) {
        DefaultMethodApp app = new DefaultMethodApp();
        app.hablar();
    }

    @Override
    public void hablar() {
        PersonaB.super.hablar();

        // Ej. Sobrescribir
        // System.out.println("Ejemplo Sobrescribir");
    }
}
