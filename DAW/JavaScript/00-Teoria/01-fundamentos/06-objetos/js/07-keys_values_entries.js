// Iteradores de Objetos (Keys,Values,Entries)
const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
};

console.log(Object.keys(producto)); // nos devolverá un arreglo con los keys del objeto
console.log(Object.values(producto)); // nos devolverá un arreglo con los valores del objeto
console.log(Object.entries(producto)); // Entries nos va a retornar una matriz de llaves y valores
