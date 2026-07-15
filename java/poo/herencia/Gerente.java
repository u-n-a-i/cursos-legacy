package poo.herencia;

public class Gerente extends Empleado {
    private double bono;

    public Gerente(String nombre, double salario, double bono) {
        super(nombre, salario);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return salario + bono;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Bono: " + bono);
        System.out.println("Salario total: $" + calcularSalario());
    }
}
