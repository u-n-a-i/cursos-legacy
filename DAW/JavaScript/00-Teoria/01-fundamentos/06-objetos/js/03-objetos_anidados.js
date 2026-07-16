// Un objeto puede contener cualquier tipo de dato dentro de el, incluso puede tener otros objetos
const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
  informacion: {
    peso: "1kg",
    medida: "1m",
  },
};

console.log(producto);

// Acceder al objeto anidado
console.log(producto.informacion);
console.log(producto.informacion.peso);
console.log(producto.informacion.medida);

// Destructuring objeto anidado
const { nombre, informacion, informacion: { peso, medida } } = producto;

console.log(nombre)
console.log(informacion)
console.log(informacion.medida)
console.log(peso)
console.log(medida)