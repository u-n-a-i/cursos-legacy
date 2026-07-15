package ampliando_conceptos.estaticos;

class Contador {
    static int cuenta = 0; // Variable estática compartida por todos los objetos
    String nombre;

    public Contador(String nombre) {
        this.nombre = nombre;
        Contador.cuenta++; // Incrementamos la variable estática cada vez que se crea un objeto
        System.out.println("Se creó el contador para: " + nombre + ". Cuenta actual: " + Contador.cuenta);
    }

    public static int obtenerCuenta() { // Método estático para acceder a la variable estática
        return cuenta;
    }
}
