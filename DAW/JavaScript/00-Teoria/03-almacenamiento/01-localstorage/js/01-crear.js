// Local Storage funciona con una especie de Llave valor...

localStorage.setItem("nombre", "Juan");

// añadir algo a session storage
sessionStorage.setItem("nombre", "Pablo");

// Local Storage solo soporta strings, no soporta arrays ni objetos pero puedes almacenarlos convirtiendolos a string..

const producto = {
  nombre: 'Monitor 24"',
  precio: 300,
};

const productoString = JSON.stringify(producto);
localStorage.setItem("productoJSON", productoString);

// Lo mismo con un array
const meses2 = ["Enero", "Febrero", "Marzo"];
localStorage.setItem("meses", JSON.stringify(meses2));
