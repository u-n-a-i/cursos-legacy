// Función flecha (arrow function)

const aprendiendo = function () {
  console.log("Aprendiendo JavaScript");
};

const aprendiendoFlecha = () => {
  console.log("Aprendiendo JavaScript");
};

console.log(aprendiendo());
console.log(aprendiendoFlecha());

// Parámetros
const aprendiendoParametros = (tecnologia) => console.log(`aprendiendo ${tecnologia}`);
aprendiendoParametros('JavaScript');

const aprendiendoMultiples = (tecn1, tecn2) => console.log(`Aprendiendo ${tecn1} ${tecn2}`);
aprendiendoMultiples('JS', 'ES');

// forEach y map

const carrito = [
    { nombre: 'Monitor 20 Pulgadas', precio: 500},
    { nombre: 'Televisión 50 Pulgadas', precio: 700},
    { nombre: 'Tablet ', precio: 300},
    { nombre: 'Audifonos', precio: 200},
    { nombre: 'Teclado', precio: 50},
    { nombre: 'Celular', precio: 500},
]

// forEach
const nuevoArray2 = carrito.forEach( producto =>  console.log( `Articulo: ${ producto.nombre } Precio: $ producto.precio} `));

// map
const nuevoArray = carrito.map(  producto =>  `Articulo: ${ producto.nombre } Precio: $ producto.precio} `);

console.log(nuevoArray);
console.log(nuevoArray2);