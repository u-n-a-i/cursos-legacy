const carrito = [
  { id: 1, producto: "Libro" },
  { id: 2, producto: "Camisa" },
  { id: 3, producto: "Disco" },
];

for (let producto of carrito) {
  console.log(producto.producto);
}

let automovil = {
  modelo: "Camaro",
  motor: "6.0",
  anio: "1969",
  marca: "Chevrolet",
};
for (let auto in automovil) {
  console.log(`${auto} : ${automovil[auto]}`);
}
