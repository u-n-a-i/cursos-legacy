package ampliando_conceptos.enumeradores;

public class Test {
    public static void main(String[] args) {
        DiasDeLaSemana hoy = DiasDeLaSemana.LUNES;

        if (hoy == DiasDeLaSemana.MARTES) {
            System.out.println("Hoy es martes");
        } else {
            System.out.println("Hoy no es martes");
        }

        // NivelPrioridad
        NivelPrioridad tareaUrgente = NivelPrioridad.ALTA;
        System.out.println("Prioridad de tarea: " + tareaUrgente);
        System.out.println("Valor numérico de la prioridad: " + tareaUrgente.getValor());
    }
}
