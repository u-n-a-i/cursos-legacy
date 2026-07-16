// teclado
// keydown  - cuando presionas una tecla
// keyup - Cuando sueltas la tecla...
// blur - cuando sales del input - ideal para validación...
// También hay eventos para cortar copiar y pegar

// cut
// copy
// paste
// input

const inputHTML = document.querySelector("input");

inputHTML.addEventListener("input", (e) => {
  console.log(e);
  console.log(e.target);
  console.log(e.target.value);
});

const formulario = document.querySelector("form");

formulario.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log("enviando...");

  console.log(e);

  console.log(e.target.method);
  console.log(e.target.action);
});
