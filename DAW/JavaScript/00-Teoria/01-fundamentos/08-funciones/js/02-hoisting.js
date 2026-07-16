//Hoisting

//Función declarativa
sumar(); // 4
function sumar() {
  console.log(2 + 2);
}

// Función de expresión
restar(); // Uncaught ReferenceError: Cannot access 'restar' before initialization
const restar = function () {
  console.log(3 - 3);
};

/* Uncaught ReferenceError: 
Esto pasa porque JavaScript se ejecuta digamos que en 2 vueltas
La primer vuelta registra todas las funciones y determina las variables, esta etapa se le llama de creación.
la segunda pasada es la que ejecuta tu código, se llama de ejecución.

Por lo tanto el primer código funciona porque function se registra primero y después se ejecuta el código.
El segundo no funciona porque si bien es una función no es declarada como tal, lo ve más bien como una variable.
*/
