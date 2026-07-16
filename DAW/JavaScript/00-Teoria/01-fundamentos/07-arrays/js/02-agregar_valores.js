// Agregar valores
const carrito = [];

// Añadir al final
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

// Añadir al Inicio

const producto3 = {
  nombre: "Teclado",
  precio: 50,
};
carrito.unshift(producto3);

// Spread Operator o Rest Operator
const carritoSpread = [];

const productoSpread = {
  nombre: "Monitor 20 Pulgadas",
  precio: 500,
};

const producto2Spread = {
  nombre: "Celular",
  precio: 500,
};
const producto3Spread = {
  nombre: "Teclado",
  precio: 50,
};

let resultado = [...carrito, producto];
resultado = [...resultado, producto2];

// Para añadir al inicio...
resultado = [producto3, ...resultado];
