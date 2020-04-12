package com.lambda;

public class Scopes {

    private static double atributoOne;
    private double atributoTwo;

    public static void main(String[] args) {
        Scopes app = new Scopes();
        System.out.println(app.probarLocalVariable());
        System.out.println(app.probarAtributosStaticVariables());
    }

    public double probarLocalVariable() {

        double n3 = 3;

        /*
        Operacion op = new Operacion() {
            @Override
            public double calcular(double n1, double n2) {
                return n1 + n2 + n3;
            }
        };
        */

        Operacion op = (x, y) -> x + y + n3;

        return op.calcular(1, 1);
    }

    public double probarAtributosStaticVariables() {

        /*
        Operacion op = new Operacion() {
            @Override
            public double calcular(double n1, double n2) {
                atributoOne = n1 + n2;
                atributoTwo = atributoOne;
                return atributoTwo;
            }
        };
        */

        Operacion op2 = (x, y) -> {
            atributoOne = x + y;
            atributoTwo = atributoOne;
            return atributoTwo;
        };

        return op2.calcular(3, 2);
    }
}
