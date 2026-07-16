// Funciones que retornan una función

const obtenerCliente = () => () => console.log("Juan Pablo");

const fn = obtenerCliente();

fn();
