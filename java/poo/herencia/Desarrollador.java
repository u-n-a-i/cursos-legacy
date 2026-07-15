package poo.herencia;

public class Desarrollador extends Empleado {
    private int horasExtras;

    public Desarrollador(String nombre, double salario, int horasExtras) {
        super(nombre, salario);
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        return salario + horasExtras * 20;  // 20 por hora extra
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Salario total: $" + calcularSalario());
    }
}

