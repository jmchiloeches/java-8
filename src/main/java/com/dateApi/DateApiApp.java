package com.dateApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateApiApp {

    public static void main(String[] args) {
        DateApiApp dateApiApp = new DateApiApp();

        try {
            // dateApiApp.verificar(8);
            // dateApiApp.medirTiempo(8);
            // dateApiApp.periodoEntreFechas(8);
            dateApiApp.convertir(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verificar(int version) {

        if (version == 7) {
            Calendar fecha1 = Calendar.getInstance();
            Calendar fecha2 = Calendar.getInstance();
            fecha1.set(1991, 0, 21);
            System.out.println(fecha1.after(fecha2));

        } else if (version == 8) {
            LocalDate fecha1 = LocalDate.of(1991, 01, 21);
            LocalDate fecha2 = LocalDate.now();

            System.out.println(fecha1.isAfter(fecha2));
            System.out.println(fecha1.isBefore(fecha2));

            LocalTime tiempo1 = LocalTime.of(22, 30, 50);
            LocalTime tiempo2 = LocalTime.now();

            System.out.println(tiempo1.isAfter(tiempo2));
            System.out.println(tiempo1.isBefore(tiempo2));

            LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 01, 21, 22, 30, 50);
            LocalDateTime fechaTiempo2 = LocalDateTime.now();

            System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
            System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
        }
    }

    // CurrentTimeMillis
    public void medirTiempo(int version) throws InterruptedException {
        if (version == 7) {
            long ini = System.currentTimeMillis();
            Thread.sleep(1000);
            long fin = System.currentTimeMillis();
            System.out.println(fin - ini);
        } else if (version == 8) {
            Instant ini = Instant.now();
            Thread.sleep(1000);
            Instant fin = Instant.now();
            System.out.println(Duration.between(ini, fin).toMillis());
        }
    }

    // Calendar
    public void periodoEntreFechas(int version) {
        if (version == 7) {
            Calendar nacimiento = Calendar.getInstance();
            Calendar actual = Calendar.getInstance();

            nacimiento.set(1991, 0, 21);
            actual.set(2017, 1, 04);

            int anyos = 0;

            while (nacimiento.before(actual)) {
                nacimiento.add(Calendar.YEAR, 1);
                if (nacimiento.before(actual)) {
                    anyos++;
                }
            }
            System.out.println(anyos);
        } else if (version == 8) {
            LocalDate nacimiento = LocalDate.of(1982, 11, 19);
            LocalDate actual = LocalDate.now();

            Period period = Period.between(nacimiento, actual);
            System.out.println("Han transcurrido " + period.getYears() + " años, " + period.getMonths() + " meses y "
                    + period.getDays() + " días, desde " + nacimiento + " hasta " + actual + ".");
        }
    }

    // Conversión
    public void convertir(int version) throws ParseException {
        if (version == 7) {
            String fecha = "21/01/1991";
            DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaConvertida = formateador.parse(fecha);
            System.out.println(fechaConvertida);

            Date fechaActual = Calendar.getInstance().getTime();
            formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String fechaCadena = formateador.format(fechaActual);
            System.out.println(fechaCadena);
        } else if (version == 8) {
            String fecha = "21/01/1991";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocal = LocalDate.parse(fecha, formatter);
            System.out.println(fechaLocal);

            formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            System.out.println(formatter.format(fechaLocal));
        }
    }
}
