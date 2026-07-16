// Recorrer array forma básica
const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];

for (let i = 0; i < meses.length; i++) {
  console.log(meses[i]);
}

// Recorrer array de objetos
const carrito = [
  { nombre: "Monitor 20 Pulgadas", precio: 500 },
  { nombre: "Televisión 50 Pulgadas", precio: 700 },
  { nombre: "Tablet ", precio: 300 },
  { nombre: "Audífonos", precio: 200 },
  { nombre: "Teclado", precio: 50 },
  { nombre: "Celular", precio: 500 },
];

// for
for (let i = 0; i < carrito.length; i++) {
  console.log(`Articulo: ${carrito[i].nombre} Precio: $ ${carrito[i].precio} `);
}

// ForEach
carrito.forEach(function (producto) {
  console.log(`Articulo: ${producto.nombre} Precio: $ producto.precio} `);
});

// Recorre y almacenarlo en un nuevo Array (map)
const nuevoArray = carrito.map(function (producto) {
  return `Articulo: ${producto.nombre} Precio: ${producto.precio} `;
});

const nuevoArray2 = carrito.forEach(function (producto) {
  return `Articulo: ${producto.nombre} Precio: ${producto.precio} `;
});

console.log(nuevoArray); // Array con su objeto
console.log(nuevoArray2); // undefined
