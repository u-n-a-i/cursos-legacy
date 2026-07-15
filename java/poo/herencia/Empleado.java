package poo.herencia;

public class Empleado {
    private String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario base: " + salario);
    }

    public double calcularSalario() {
        return salario;
    }
}
