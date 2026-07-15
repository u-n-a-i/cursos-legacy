package clases_integradas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ClaseTime {
    public static void main(String[] args) {
        /*
        La API `java.time`, introducida en Java 8, revolucionó el manejo de fechas y horas en Java.
        Esta API es más clara, segura y fácil de usar que las clases antiguas (`Date`, `Calendar`, etc.).
         */

        // Fecha sin hora
        LocalDate fecha = LocalDate.now();
        System.out.println(fecha);
        LocalDate fechaEspecifica = LocalDate.of(2021, 1, 1);
        System.out.println("Fecha específica: " + fechaEspecifica);

        // Hora sin fecha
        LocalTime hora = LocalTime.now();
        System.out.println(hora);
        LocalTime horaEspecifica = LocalTime.of(14, 30);
        System.out.println("Hora específica: " + horaEspecifica);

        // Duración entre dos horas
        LocalTime inicio = LocalTime.of(14, 0);
        LocalTime fin = LocalTime.of(16, 30);
        Duration duracion = Duration.between(inicio, fin);
        System.out.println("Duración: " + duracion.toHours() + " horas");

        // Período entre dos fechas
        LocalDate fechaInicio = LocalDate.of(2021, 1, 1);
        LocalDate fechaFin = LocalDate.of(2021, 12, 31);
        Period periodo = Period.between(fechaInicio, fechaFin);
        System.out.println("Período: " + periodo.getMonths() + " meses y " + periodo.getDays() + " días");

        // Formatear
        LocalDate fecha2 = LocalDate.of(2021, 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha2.format(formatter);
        System.out.println("Fecha formateada: " + fechaFormateada);

        LocalDate fechaParseada = LocalDate.parse("01/01/2021", formatter);
        System.out.println("Fecha parseada: " + fechaParseada);
    }
}
