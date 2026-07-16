// Los objetos son la pieza principal en JavaScript, en lugar de crear diferentes variables
const nombreProducto = "Monitor 20 Pulgadas";
const precio = 30;
const disponible = true;

// Podemos crear un objeto que agrupe toda esta información en una sola variable
// Aun que se declaren como const se pueden reasignar sus propiedades
const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
};

// Acceder a las propiedades de un objeto
console.log(producto);
console.log(producto.nombre);
console.log(producto.precio);
console.log(producto.disponible);

// Otra forma aunque no tan común
console.log(producto["nombre"]);

// Añadir propiedades nuevas a un objeto
producto.imagen = "image.jpg";

// Eliminar una propiedad se utiliza delete
delete producto.nombre;
console.log(producto);
