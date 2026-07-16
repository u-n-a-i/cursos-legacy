// Veamos como concatenar o unir 2 textos o variables:
const producto = "Monitor 20 Pulgadas";
const precio = "30 USD";

// Método concat
console.log(producto.concat("En Descuento")); // Concatenar un string
console.log(producto.concat(precio)); // Concatenar una variable

// Otras formas de concatenar:
console.log(producto + precio);
console.log(producto + "Con un precio de " + precio);
console.log("El Producto" + producto + " tiene un precio de " + precio); // Esta forma se puede complicar
console.log("El Producto", producto, " tiene un precio de ", precio); // Otra forma

// Template String
console.log(`El Producto ${producto} tiene un precio de ${precio}`);
