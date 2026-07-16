const producto = {
  nombre: "Monitor 20 pulgadas",
  precio: 30,
  disponible: true,
};

const medidas = {
  peso: "1 kg",
  medida: "1 metro",
};

// Método assign
const resultado = Object.assign(producto, medidas);
console.log(resultado);

// Spread o Rest operator

const union = { ...producto, ...medidas };
console.log(union);
