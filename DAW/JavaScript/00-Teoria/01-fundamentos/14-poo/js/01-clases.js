// Las classes se crean con la palabra reservada class...

class Cliente {
  // El Nombre debe ser en mayúsculas... Y esta forma se le conoce como CLASS DECLARATION

  constructor(nombre, saldo) {
    this.nombre = nombre;
    this.saldo = saldo;
  }
}

//Si recuerdas previamente instanciabamos nuestro objecto con... para pasar esos valores las classes introduccieron lo que se conoce como constructores... en algunos lenguajes el constructor es el mismo nombre de la clase pero en javascript es constructaor
const juan = new Cliente("Juan", 400);

console.log(juan);

// Existe una segunda forma de crear classes, se le conoce como class Expression

const Cliente2 = class {
  constructor(nombre, saldo) {
    this.nombre = nombre;
    this.saldo = saldo;
  }
};

const juan2 = new Cliente2("Juan", 400);
console.log(juan2);
