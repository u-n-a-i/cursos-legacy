// Eventos ratón

const caja = document.querySelector(".caja-pruebas");

caja.addEventListener("mouseenter", () => {
  caja.style.backgroundColor = "teal";
});

caja.addEventListener("mouseout", () => {
    caja.style.backgroundColor = "white";
  });