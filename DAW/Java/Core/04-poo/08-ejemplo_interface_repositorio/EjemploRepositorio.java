import modelo.Cliente;
import repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repositorio = new ClienteListRepositorio();

        repositorio.crear(new Cliente("Jano", "Pérez"));
        repositorio.crear(new Cliente("Bea", "González"));
        repositorio.crear(new Cliente("Luci", "Martínez"));
        repositorio.crear(new Cliente("Andrés", "Guzman"));

        System.out.println("===== Listar =======");
        List<Cliente> clientes = repositorio.listar();
//        clientes.forEach(cliente -> {
//            System.out.println("Nombre: " + cliente.getNombre());
//            System.out.println("Apellido: " + cliente.getApellido());
//        });
        clientes.forEach(System.out::println);

        System.out.println("===== Paginación =======");
        List<Cliente> paginable = ((PaginableRepositorio) repositorio).listar(0, 3); // el indice 3 no se incluye
        paginable.forEach(System.out::println);

        System.out.println("===== Ordenar =======");
        List<Cliente> ordenar = ((OrdenableRepositorio) repositorio).listar("id", Direccion.DESC);
        ordenar.forEach(System.out::println);

        System.out.println("===== Editar =======");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repositorio.editar(beaActualizar);
        Cliente bea = repositorio.porId(2);
        System.out.println(bea);

        System.out.println("===== Eliminar(id=2) =======");
        repositorio.eliminar(2);
        ordenar.forEach(System.out::println);
    }
}
