// Modificar HTML

const encabezado = document.querySelector("h1");

console.log(encabezado);
console.log(encabezado.innerHTML);
console.log(encabezado.innerText);
console.log(encabezado.textContent);

encabezado.innerHTML = "Titulo de la Web";
encabezado.innerText = "Hola";
encabezado.textContent = "Titulo";
