package com.defaultMethods;

public interface PersonaA {
    default void hablar() {
        System.out.println("Saludos - PersonaA");
    }
}
