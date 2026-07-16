const carrito = [];

const producto = {
  nombre: "Monitor 20 Pulgadas",
  precio: 500,
};

const producto2 = {
  nombre: "Celular",
  precio: 500,
};

carrito.push(producto);
carrito.push(producto2);
const producto3 = {
  nombre: "Teclado",
  precio: 50,
};
carrito.unshift(producto3);

// Eliminar el primer elemento...
// carrito.shift();

// // Eliminar el ultimo elemento...
// carrito.pop()
console.log(carrito);

// Ahora supongamos que deseas eliminar del centro...
// el segundo parámetro es que tantos elementos vamos a borrar, 0 significa nada,
// entonces seria igual a no tener nada, si no le pasas un valor va a borrar todos a partir de ahi..
carrito.splice(1, 0);
// carrito.splice(1, 2);

console.log(carrito);
