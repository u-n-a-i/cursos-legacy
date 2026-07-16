// Objeto
const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
};

// Asignar variables hacia un objeto
const disponible = producto.disponible;

// Destructuring (sacar de una estructura)
// const { nombre } = producto;
// const { precio } = producto;
const { nombre, precio } = producto;
console.log(nombre);
console.log(precio);
