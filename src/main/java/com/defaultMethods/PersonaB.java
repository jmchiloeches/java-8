package com.defaultMethods;

public interface PersonaB {
    default void hablar() {
        System.out.println("Saludos - PersonaB");
    }
}