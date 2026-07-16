const carrito = [
  { nombre: "Monitor 20 Pulgadas", precio: 500 },
  { nombre: "Televisión 50 Pulgadas", precio: 700 },
  { nombre: "Tablet", precio: 300 },
  { nombre: "Audífonos", precio: 200 },
  { nombre: "Teclado", precio: 50 },
  { nombre: "Celular", precio: 500 },
  { nombre: "Bocinas", precio: 300 },
  { nombre: "Laptop", precio: 800 },
];

// Every todos deben cumplir la condición
const resultado = carrito.every((producto) => producto.precio < 1000); // Mil se cumple, 700 no...
console.log(resultado);

// Con un foreach seria algo asi...
let cumple = true;
carrito.forEach((producto) => {
  if (producto.precio > 700) {
    cumple = false;
    return;
  }
});
console.log(cumple);
