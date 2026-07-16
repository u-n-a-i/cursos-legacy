// this es una palabra clave que hace referencia al objeto al que pertenece la función en la que se está utilizando.
const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
  mostrarInfo: function () {
    return `El Producto: ${this.nombre}  tiene un precio de ${this.precio}`;
  },
};

console.log(producto.mostrarInfo());
