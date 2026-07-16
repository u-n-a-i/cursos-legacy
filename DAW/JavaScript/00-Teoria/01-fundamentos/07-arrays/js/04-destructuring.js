const numbers = [10, 20, 30, 40, 50];

// Array Destructuring
const [posicion0, , posicion2, posicion3] = numbers;

console.log(posicion0);
console.log(posicion2);
console.log(posicion3);

// Extraer el resto
const [primero, ...resto] = numbers;

console.log(primero);
console.log(resto);
