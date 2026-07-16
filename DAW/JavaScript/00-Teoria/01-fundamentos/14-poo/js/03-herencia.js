class Cliente {
  constructor(nombre, saldo) {
    this.nombre = nombre;
    this.saldo = saldo;
  }
  imprimirSaldo() {
    return `Hola ${this.nombre}, tu saldo es: ${this.saldo}`;
  }

  retiraSaldo(retiro) {
    this.saldo -= retiro;
  }
  static bienvenida() {
    return `Bienvenido al cajero`;
  }
}

// NUEVO :
class Empresa extends Cliente {
  constructor(nombre, saldo, telefono, tipo) {
    // Va hacia el constructor del padre
    super(nombre, saldo);
    // otros atributos se declaran fuera
    this.telefono = telefono;
    this.tipo = tipo;
  }

  static bienvenida(mensaje) {
    // Reescribir un método...
    return `Bienvenido al cajero para empresas`;
  }
}

const pedro = new Cliente("Pedro", 3000);
console.log(pedro);
console.log(pedro.imprimirSaldo());

// Heredando y creando una instancia de empresa
const empresa = new Empresa("Empresa1", 10000, 10290193, "Construcción");

// Debido a que heredamos podemos acceder a imprimirSaldo
console.log(empresa.imprimirSaldo());

// Acceder al static sin Instanciar de ambos
console.log(Empresa.bienvenida());
console.log(Cliente.bienvenida());
