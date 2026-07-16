const cajaPruebas = document.querySelector(".caja-pruebas");
const infoDiv = document.querySelector("p");
const titulo = document.querySelector("h2");

cajaPruebas.addEventListener("click", (e) => {
  e.stopPropagation();
  console.log("click div");
});
infoDiv.addEventListener("click", (e) => {
  e.stopPropagation();
  console.log("click info");
});

titulo.addEventListener("click", (e) => {
  e.stopPropagation();
  console.log("click titulo");
});

// mirar propagación event bubbling