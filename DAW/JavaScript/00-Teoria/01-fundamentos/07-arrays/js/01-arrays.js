// Arreglos
const numbers = [10, 20, 30, 40];

// Acceder
console.log(numbers);
console.table(numbers);
console.log(numbers[0]);
console.log(numbers[1]);
console.log(numbers[3]);

// Agregar y Modificar
numbers[4] = 50;
numbers[0] = 0;
console.log(numbers);

// Otras formas
const meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio");
console.log(meses);

const deTodo = [
  "Hola",
  10,
  true,
  "si",
  null,
  { nombre: "Juan", trabajo: "Programador" },
  [1, 2, 3, 4],
];
console.log(deTodo);

// Longitud de los arrays
console.log(meses.length);
