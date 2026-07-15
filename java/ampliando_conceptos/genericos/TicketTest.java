package ampliando_conceptos.genericos;

public class TicketTest {
    public static void main(String[] args) {
        Ticket<String> cine = new Ticket<>("Entrada - Memento 20:30");
        Ticket<Integer> tren = new Ticket<>(798432);
        Ticket<Boolean> valido = new Ticket<>(true);

        System.out.println(cine); // llamará automáticamente a toString()
        System.out.println(tren);
        System.out.println(valido.getDetalle() ? "Puede pasar" : "No puede  pasar");
    }
}
