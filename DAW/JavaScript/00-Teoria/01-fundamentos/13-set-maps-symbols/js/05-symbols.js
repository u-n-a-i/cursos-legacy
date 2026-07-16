// Symbol

// Los símbolos son nuevos en ES6, te permiten crear propiedad única

// Symbol es creado y se agrega a una propiedad del objeto.
// new Symbol enviaría un error.

const sym = Symbol("symbol");
const sym2 = Symbol("symbol");

// Los symbols siempre son diferentes

// console.log( Symbol() === Symbol() );

// Llaves de objetos únicas
let nombre = Symbol();
let apellido = Symbol();

// Crear un objeto vació
let persona = {};
// Esto no va a servir

persona.datos;

// debe tener corchetes
persona[nombre] = "Juan";
persona[apellido] = "De la torre";
persona.tipoCliente = "Premium";
persona.saldo = 500;
console.log(persona);
console.log(persona[nombre]);

// No se puede acceder al SYMBOL con un for.
for (let i in persona) {
  console.log(`${i} : ${persona[i]}`);
}

// También se puede crear UNA DESCRIPCIÓN DEL SYMBOL
/*
let nombreCliente = Symbol('Nombre del cliente');
let cliente = {};

cliente[nombreCliente] = 'Pedro';


// Probar
console.log(cliente);
console.log(cliente[nombreCliente]);
console.log(nombreCliente);

*/
