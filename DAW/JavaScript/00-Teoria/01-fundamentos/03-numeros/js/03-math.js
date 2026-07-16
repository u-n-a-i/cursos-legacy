/*
 Math es parte de la ventana global de JavaScript,
 tiene una serie de operaciones que pueden ser muy útiles 
*/

let resultado;

// Pi
resultado = Math.PI;
// Redondeo
resultado = Math.round(2.5);
// redondeo abajo o arriba (ceil o floor )
resultado = Math.ceil(2.2);
// Raíz cuadrada
resultado = Math.sqrt(144);
// Absoluto
resultado = Math.abs(-300);
// Potencia
resultado = Math.pow(8, 3);
// Mínimo
resultado = Math.min(3, 5, 1, 2, 9, 4, 2, -3);
// Max
resultado = Math.max(4, 1, 21, 4, 15, 5, 11, 5);
// Aleatorio
resultado = Math.random();
// Aleatorio dentro de un rango:
resultado = Math.floor(Math.random() * 30);

console.log(resultado);
