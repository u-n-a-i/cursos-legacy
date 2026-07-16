// Listado de países
const paises = [
  "Francia",
  "España",
  "Portugal",
  "Australia",
  "Inglaterra",
  "Irlanda",
];

// Un nuevo pais se agrega despues de 2 segundos...
function nuevoPais(pais, callback) {
  setTimeout(() => {
    paises.push(pais);
    callback();
  }, 2000); // Pero el segundo ya paso, y se agrega uno nuevo, ejecutamos el callback para que se vuelva a llamar la función
}

// Los paises se muestran despues de 1 segundo
function mostrarPaises() {
  setTimeout(() => {
    paises.forEach((pais) => {
      console.log(pais);
    });
  }, 1000); // Después de un segundo obtenemos los países...
}

//mostrarPaises();

nuevoPais('Alemania', mostrarPaises);