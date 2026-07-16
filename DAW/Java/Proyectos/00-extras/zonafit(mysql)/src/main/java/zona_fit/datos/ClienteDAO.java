package zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements IClienteDAO {

    // Métodos Interface
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        PreparedStatement ps; // Preparar sentencia
        ResultSet rs; // Resultado
        //Connection con = Conexion.getConexion(); // Establecer conexión
        Connection con = getConexion(); // Import static
        var sql = "SELECT * FROM cliente ORDER BY id";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // Ejecutar sentencia

            while (rs.next()) {
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConexion();
        var sql = "SELECT * FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        //Connection con = getConexion();
        var con = getConexion();
        var sql = "INSERT INTO cliente(nombre, apellido, membresia)"
                + " VALUES(?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia = ? "
                + "WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar el cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "DELETE FROM cliente WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }

    // Comprobar
    public static void main(String[] args) {
//        System.out.println("***Listar Clientes***");
//        IClienteDAO clienteDao = new ClienteDAO();
//        var clientes = clienteDao.listarClientes();
//        clientes.forEach(System.out::println);

//        System.out.println("*** Buscar por  Id ***");
//        IClienteDAO clienteDao = new ClienteDAO();
//        var cliente = new Cliente(3);
//        System.out.println("Cliente antes de la busqueda: " + cliente);
//        var encontrado = clienteDao.buscarClientePorId(cliente);
//
//        if (encontrado) {
//            System.out.println("Se encontró cliente: " + cliente);
//        } else {
//            System.out.println("No se encontró cliente" + cliente.getId());
//        }

//        System.out.println("*** Agregar Cliente ***");
//        IClienteDAO clienteDao = new ClienteDAO();
//        var nuevoCliente = new Cliente("Daniel", "Ortiz", 400);
//        var agregado = clienteDao.agregarCliente(nuevoCliente);
//
//        if (agregado) {
//            System.out.println("Cliente agregado: " + nuevoCliente);
//        } else {
//            System.out.println("No se agrego el cliente " + nuevoCliente);
//        }
//        System.out.println("***Listar Clientes***");
//        var clientes = clienteDao.listarClientes();
//        clientes.forEach(System.out::println);

//        System.out.println("*** Modificar Cliente ***");
//        IClienteDAO clienteDao = new ClienteDAO();
//        var modificarCliente = new Cliente(5, "Carlos Daniel", "Ortiz", 400);
//        var modificado = clienteDao.modificarCliente(modificarCliente);

//        if (modificado) {
//            System.out.println("Cliente agregado: " + modificarCliente);
//        } else {
//            System.out.println("No se agrego el cliente " + modificarCliente);
//        }
//        System.out.println("***Listar Clientes***");
//        var clientes = clienteDao.listarClientes();
//        clientes.forEach(System.out::println);

        System.out.println("*** Eliminar Cliente ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var eliminarCliente = new Cliente(5, "Carlos Daniel", "Ortiz", 400);
        var eliminado = clienteDao.eliminarCliente(eliminarCliente);

        if (eliminado) {
            System.out.println("Cliente eliminado: " + eliminarCliente);
        } else {
            System.out.println("No se elimino el cliente " + eliminarCliente);
        }
        System.out.println("***Listar Clientes***");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
    }
}
