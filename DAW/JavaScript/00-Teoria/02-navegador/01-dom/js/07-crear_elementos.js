// Crear elemento
const enlace = document.createElement("a");

// Crear texto
enlace.textContent = "Nuevo Enlace";

// Asignar ruta
enlace.href = "/nuevo-enlace";

// Agregar una clase
enlace.classList.add("enlace");

enlace.setAttribute("data-enlace", "nuevo-enlace");

// Agregar
const caja = document.querySelector(".crear_elemento");
caja.appendChild(enlace);

console.log(caja);
