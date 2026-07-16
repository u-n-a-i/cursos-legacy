import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Usuario extends Thread {
    private String nombre;
    private String dia;
    private LocalTime horaIngreso;
    private static final LocalTime HORA_OFICIAL = LocalTime.of(8, 0);
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

    public Usuario(String nombre, String dia, String horaTexto) {
        this.nombre = nombre;
        this.dia = dia;
        this.horaIngreso = LocalTime.parse(horaTexto, formato);
    }

    @Override
    public void run() {
        System.out.println(" Registro de " + nombre);
        System.out.println("Día: " + dia);
        System.out.println("Hora de ingreso: " + horaIngreso.format(formato));

        if (horaIngreso.isBefore(HORA_OFICIAL)) {
            System.out.println(nombre + " llegó temprano.");
        } else if (horaIngreso.equals(HORA_OFICIAL)) {
            System.out.println(nombre + " llegó justo a tiempo.");
        } else {
            System.out.println(nombre + " llegó tarde.");
        }
    }
}
