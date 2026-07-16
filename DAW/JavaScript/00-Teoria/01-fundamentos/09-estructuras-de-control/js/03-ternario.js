// Ternario
const autenticado = false;
const puedePagar = false;

console.log(
  autenticado && puedePagar ? "Si esta autenticado" : "No esta autenticado"
);

console.log(
  autenticado
    ? puedePagar
      ? "Si puede pagar"
      : "esta autenticado pero no puede pgar"
    : "No esta autenticado"
);
