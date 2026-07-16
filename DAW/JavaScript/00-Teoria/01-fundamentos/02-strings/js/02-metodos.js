// Métodos para Strings
const producto = "  Monitor 20 Pulgadas  ";
const precio = "30 USD";

//Longitud o extension
console.log(producto.length);
console.log(precio.length);

// IndexOf buscar texto y devolver la posición
console.log(producto.indexOf("Pulgadas"));
console.log(precio.indexOf("Pulgadas")); // -1 Significa que no lo pudo encontrar

// Includes devuelve true o false si encuentra el texto
console.log(producto.includes("Monitor"));
console.log(producto.includes("monitor"));

// Trim cortar cadenas
console.log(producto.trim().length); // Obtener la longitud de una cadena después de eliminar los espacios en blanco al principio y al final de la misma.
console.log(producto.trimStart()); // Elimina todos los espacios en blancos del inicio
console.log(producto.trimEnd()); // Elimina todos los espacios en blancos del final
console.log(producto.trimStart().trimEnd()); // Cortar en ambas direcciones

// Replace
console.log(producto.replace("20", "24"));
console.log(producto.replace("Pulgadas", '"'));

// Slice te va a permitir extraer una parte de una cadena
console.log(producto.slice(0, 10)); // Iniciar en 0 y cortar hasta 10
console.log(producto.slice(8)); // Cortar desde el 8 hasta el fin
console.log(producto.slice(2, 10)); // cortar desde 2 hasta el 10
console.log(producto.slice(2, 1)); // Si el primer número es mayor, no va a cortar hacia atrás

// Existe uno similar a Slice que se llama substring
console.log(producto.substring(0, 10));

// Si has visto algunos sitios web muestran tu primer letra de tu nombre
const nombre = "Juan";
console.log(nombre.substring(0, 1));
console.log(nombre.charAt(0));

// Repeat Te va a permitir repetir una cadena de texto
const monitor = "Monitor 24 pulgadas ";
const texto = "en Promoción ".repeat(3);
console.log(monitor.repeat(3));
console.log(monitor.repeat(2.2)); // va a redondear a entero
console.log(`${monitor} ${texto} !!!`);

// Split dividir la cadena
const actividad = "Estoy aprendiendo Javascript Moderno";
console.log(actividad.split(" ")); // ['Estoy', 'aprendiendo', 'Javascript', 'Moderno']

const hobbies =
  "Leer, caminar, escuchar música, escribir, aprender a programar";
console.log(hobbies.split(", "));
["Leer", "caminar", "escuchar música", "escribir", "aprender a programar"];

// .toUpperCase() cambiar un texto a todo mayúsculas
console.log(producto.toUpperCase());

// .toLowerCase() cambiar un texto a todo minúsculas
console.log(producto.toLowerCase());

// .toString() cambiar el tipo de dato a String
const cantidad = 200;
console.log(cantidad);
console.log(cantidad.toString());
