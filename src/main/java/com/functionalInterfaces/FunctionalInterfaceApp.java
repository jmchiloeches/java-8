package com.functionalInterfaces;

import com.lambda.Operacion;

public class FunctionalInterfaceApp {

    public static void main(String[] args) {
        FunctionalInterfaceApp app = new FunctionalInterfaceApp();
        double rpta = app.operar(2, 3);
        System.out.println(rpta);
    }

    public double operar(double x, double y) {
        Operacion op = (n1, n2) -> n1 + n2;
        return op.calcular(x, y);
    }
}
