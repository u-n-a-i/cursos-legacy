// Modificar Objetos
const producto = {
  nombre: "Teclado",
  precio: 34,
  disponible: true,
};

/* Seal 
Ni agregar nuevas propiedades ni eliminarlas.
Si permite modificar las existentes.
*/

console.log("---Seal---");
Object.seal(producto);

producto.precio = 40;

console.log(producto);

delete producto.precio;

console.log(producto);

// Verificar si un objeto esta sellado
console.log(Object.isSealed(producto));

/* Freeze
Evita que se puedan agregar, eliminar o modificar propiedades. 
*/

console.log("---Freeze---");
Object.freeze(producto);

producto.precio = 50;

console.log(producto);

delete producto.precio;

console.log(producto);

// Si quieres revisar si un objeto esta congelado puedes usar
console.log(Object.isFrozen(producto));
