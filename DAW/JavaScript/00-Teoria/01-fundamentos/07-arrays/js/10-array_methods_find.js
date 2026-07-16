const carrito = [
  { nombre: "Monitor 20 Pulgadas", precio: 500 },
  { nombre: "Televisión 50 Pulgadas", precio: 700 },
  { nombre: "Tablet", precio: 300 },
  { nombre: "Audífonos", precio: 200 },
  { nombre: "Teclado", precio: 50 },
  { nombre: "Celular", precio: 500 },
  { nombre: "Bocinas", precio: 300 },
  { nombre: "Bocinas", precio: 400 },
  { nombre: "Laptop", precio: 800 },
];

// Find crea un nuevo array en base al primer resultado true
const resultadoFind = carrito.find((producto) => producto.nombre === "Bocinas");
console.log(resultadoFind);

// con un foreach seria algo asi...
let resultado = "";
carrito.forEach((producto, index) => {
  if (producto.nombre === "Bocinas") {
    resultado = carrito[index];
  }
});
console.log(resultado);
