package poo.herencia;

public class Test {
    public static void main(String[] args) {
        // polimorfismo: estamos tratando a un objeto Gerente como si fuera un Empleado, porque Gerente hereda de Empleado.
        Empleado e1 = new Gerente("Anna", 3000, 500);
        Empleado e2 = new Desarrollador("Juan", 2500, 10);

        e1.mostrarInfo();
        System.out.println();

        e2.mostrarInfo();

        System.out.println("\n###Polimorfismo###\n");
        /*
        Permite que escribas código más genérico y flexible. Por ejemplo, puedes hacer esto:
         */
        Empleado[] empleados = {
                new Gerente("Laura", 6000, 300),
                new Desarrollador("Carlos", 1500, 90)
        };

        for (Empleado e : empleados) {
            e.mostrarInfo();  // Llama al método correspondiente gracias al polimorfismo
            System.out.println();
        }
    }
}
