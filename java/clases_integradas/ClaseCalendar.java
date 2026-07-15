package clases_integradas;

import java.util.Calendar;

public class ClaseCalendar {
    public static void main(String[] args) {
     /*
     La clase `Calendar` es una clase abstracta que proporciona métodos para convertir entre un instante en el tiempo
     y un conjunto de campos de calendario (como año, mes, día, hora, etc.).
     La clase más comúnmente utilizada que extiende `Calendar` es `GregorianCalendar`.
      */
        Calendar calendario = Calendar.getInstance();
        System.out.println(calendario.getTime());
        System.out.println(calendario.get(Calendar.YEAR));
        System.out.println(calendario.get(Calendar.MONTH));
        System.out.println(calendario.get(Calendar.DAY_OF_MONTH));
    }
}
