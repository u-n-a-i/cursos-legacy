let pendientes = ["Tarea", "Comer", "Proyecto", "Estudiar JavaScript"];

// Recorrer con un Foreach
pendientes.forEach((pendiente, index) => {
  console.log(`${index} : ${pendiente}`);
});

// Recorrer arreglo de objetos
const carrito = [
  { id: 1, producto: "Libro" },
  { id: 2, producto: "Camisa" },
  { id: 3, producto: "Disco" },
];

carrito.forEach((producto) => {
  console.log(`Agregaste ${producto}`);
});
