package clases_integradas;

import java.util.Date;

public class ClaseDate {
    public static void main(String[] args) {
        /* Date
        Antes de la introducción de la API `java.time` en Java 8, el manejo de fechas y
        horas en Java se realizaba principalmente mediante las clases `Date`, `Calendar` y `GregorianCalendar`.
        Aunque estas clases siguen siendo compatibles, se consideran obsoletas en favor de la nueva API.
        Sin embargo, es importante entender su funcionamiento, especialmente si trabajas con código legacy.
         */
        Date fechaActual = new Date();
        System.out.println(fechaActual);

        // Comparar fecha
        Date fechaModificada = new Date(fechaActual.getTime() + 1000);
        System.out.println(fechaActual.before(fechaModificada));
        System.out.println(fechaActual.after(fechaModificada));
    }
}
