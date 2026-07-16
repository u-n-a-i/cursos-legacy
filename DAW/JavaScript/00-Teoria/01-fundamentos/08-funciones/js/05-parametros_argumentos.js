// Funciones que toman parámetros y argumentos
function saludar(nombre, apellido) {
  // nombre y apellido son parámetros, son valores que se le pueden pasar a la función
  console.log(`Hola ${nombre}  ${apellido} `);
}
saludar("Juan", "De la torre"); // Pablo y De la torre son argumentos, son los valores reales...

saludar(); // Hola undefined  undefined

// Parámetros por defecto
function saludar2(nombre = "Desconocido", apellido = "") {
  // nombre y apellido son parametros, son valores que se le pueden pasar a la función... Los valores digamos no son reales, pues son variables...
  console.log(`Hola ${nombre}  ${apellido} `);
}
saludar2("Juan", "De la torre"); // Pablo y De la torre son argumentos, son los valores reales...

saludar2("Juan");

saludar2();
