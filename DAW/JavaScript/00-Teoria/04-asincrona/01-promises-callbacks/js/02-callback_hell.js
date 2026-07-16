// Listado de países
const paises = [];

// Un nuevo país se agrega después de 2 segundos...
function nuevoPais(pais, callback) {
  paises.push(pais);
  console.log(`Agregado: ${pais}`);
  callback();
}

function mostrarPaises() {
  console.log(paises);
}

// Los países se muestran después de 1 segundo
function iniciarCallbackHell() {
  setTimeout(() => {
    // Agregar nuevo pais
    nuevoPais("Alemania", mostrarPaises);
    setTimeout(() => {
      nuevoPais("Francia", mostrarPaises);
      setTimeout(() => {
        nuevoPais("Inglaterra", mostrarPaises);
      }, 3000);
    }, 3000); // Después de un segundo obtenemos los paises...
  }, 3000);
}

iniciarCallbackHell();
