package com.methodReferences;


import java.util.Arrays;

public class MethodReferenceApp {

    public static void referenciarMetodoStatic() {
        System.out.println("Método referido static");
    }

    public static void main(String[] args) {

        MethodReferenceApp app = new MethodReferenceApp();
        app.operar();
        app.referenciarMetodoInstanciaObjetoArbitrario();

        OperacionRef op = app::referenciarMetodoInstanciaObjetoParticular;
        op.saludar();

        app.referenciarConstructor();
    }

    public void referenciarMetodoInstanciaObjetoArbitrario() {

        String[] nombres = {"Rick", "Homer", "Donald"};

        // JDK 1.7
        /*
        Arrays.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        */

        // Expresión Lambda
        /*
        Arrays.sort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(Arrays.toString(nombres));
        */

        // Referencia a método de instancia
        Arrays.sort(nombres, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(nombres));
    }

    public void referenciarMetodoInstanciaObjetoParticular() {
        System.out.println("Método Referido Instancia de Objeto en Particular");
    }

    public void referenciarConstructor() {

        // JDK 1.7
        /*
        IPersona iper = new IPersona() {
            @Override
            public Persona crear(int id, String nombre) {
                return new Persona(id, nombre);
            }
        };

        Persona per = iper.crear(1, "Peter");
        System.out.println(per.getId() + " - " + per.getNombre());
        */

        // Expresión Lambda
        /*
        IPersona iper2 = (x, y) -> (new Persona(x,y));
        Persona per2 = iper2.crear(1, "Peter");
        System.out.println(per2.getId() + " - " + per2.getNombre());
        */

        // Referencia a Método Constructor
        IPersona iper3 = Persona::new;
        Persona per3 = iper3.crear(1, "Peter");
        System.out.println(per3.getId() + " - " + per3.getNombre());
    }

    public void operar() {

        // Expresión Lambda
        /*
        OperacionRef op = () -> MethodReferenceApp.referenciarMetodoStatic();
        op.saludar();
        */

        // Referencia a Método Estático
        OperacionRef op2 = MethodReferenceApp::referenciarMetodoStatic;
        op2.saludar();
    }
}
