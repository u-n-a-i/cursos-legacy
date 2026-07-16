// Concat unir arrays
const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];
const meses2 = [
  "Julio",
  "Agosto",
  "Septiembre",
  "Octubre",
  "Noviembre",
  "Diciembre",
];

const meses3 = meses.concat(meses2);
console.log(meses3);

//Spread
const meses4 = [...meses, ...meses2]; // Tienes que asegurarte de que sean arrays cuando usas ...'Otro mes'
console.log(meses4);
