// delegation

const caja = document.querySelector(".caja-pruebas");

caja.addEventListener("click", (e) => {
  if (e.target.classList.contains("titulo")) {
    console.log("click titulo");
  }
  if (e.target.classList.contains("info")) {
    console.log("click info");
  }
});
