const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];

// foreach -> buscar un mes
meses.forEach((mes) => {
  if (mes === "Enero") {
    console.log("Enero si existe...");
  }
});

// include -> buscar si un array incluye algo
const resultado = meses.includes("Enero"); // true
console.log(resultado);

// En el caso de un arreglo de objetos... .includes no es la mejor opción, utilizar .some
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

// .some
const existe = carrito.some((producto) => producto.nombre === "Celular");
console.log(existe); // true

// Some en un arreglo tradicional
const existe2 = meses.some((mes) => mes === "Diciembre"); // false
console.log(existe2);
