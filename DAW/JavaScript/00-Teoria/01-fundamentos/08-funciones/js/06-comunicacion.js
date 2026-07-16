// En lugar de tener una gran función con 800 lineas es recomendable dividirla en pequeñas partes

iniciarApp();

function iniciarApp() {
  console.log("Iniciando App...");
  segundaFuncion();
}

function segundaFuncion() {
  console.log("Desde la segunda función...");
  usuarioAutenticado("Pablo");
}

function usuarioAutenticado(usuario) {
  console.log("Autenticando usuario...");
  console.log(`Usuario autenticado con éxito ${usuario} `);
}
