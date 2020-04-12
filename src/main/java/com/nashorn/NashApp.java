package com.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/* Existe una herramienta que se instala con la JDK para ejecutar JavaScript.
 * - Para ver la si la tenemos instalada lanzaremos: $ jjs -v. A continuación podremos lanzar
 * código JavaScript que se ejecutará desde la consola.
 * - Para salir pulsaremos 'Ctrl + C'.
 * - Para ejecutar el contenido de un fichero JS lo haremos con: $ jjs nombreFich.js
 * NOTA: En Java 11 me avisa de la eliminación de esta herramienta para una futura versión de JDK. */
public class NashApp {

    private ScriptEngineManager m;
    private ScriptEngine e;
    private Invocable invocable;

    public NashApp() {
        m = new ScriptEngineManager();
        e = m.getEngineByName("nashorn");
        invocable = (Invocable) e;
    }

    public static void main(String[] args) throws Exception {
        NashApp app = new NashApp();
        // app.llamarFunciones();
        app.implementarInterfaz();
    }

    public void llamarFunciones() throws Exception {
        // e.eval("print('JS desde Java')");
        e.eval(new FileReader("src/main/java/com/nashorn/archivo.js"));

        String rpta = (String) invocable.invokeFunction("calcular", "2", "3");
        System.out.println(rpta);

        double rpta2 = (double) invocable.invokeFunction("calcular", 2, 3);
        System.out.println(rpta2);
    }

    public void implementarInterfaz() throws Exception {
        e.eval(new FileReader("src/main/java/com/nashorn/archivo.js"));

        Object implementacion = e.get("hiloImpl");
        Runnable r = invocable.getInterface(implementacion, Runnable.class);

        Thread th1 = new Thread(r);
        th1.start();

        Thread th2 = new Thread(r);
        th2.start();
    }
}
