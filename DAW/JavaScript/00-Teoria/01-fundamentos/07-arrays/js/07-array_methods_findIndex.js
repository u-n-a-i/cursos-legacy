const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];

// Con forEach
meses.forEach((mes, index) => {
  if (mes === "Abril") {
    // Si ponemos diciembre no lo va a encontrar...
    console.log(`Encontrado en el indice ${index}`);
  }
});

// Con findIndex devuelve la posición
const indice = meses.findIndex((mes) => mes === "Abril"); // Cambiar a Diciembre, Tendremos -1 eso quiere decir que no lo encontró
console.log(indice);
