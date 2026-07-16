window.addEventListener("scroll", () => {
  // console.log('scrolling...');

  // Detectar el Scrolling vertical...

  // const pxScroll = window.scrollY;
  // console.log(pxScroll);

  // Detectar un elemento al dar scroll...

  const enlace = document.querySelector("#enlace");

  const ubicacion = enlace.getBoundingClientRect(); // Este método te da el tamaño de un elemento y su ubicación respecto a la ubicación actual..
  // console.log(ubicacion);

  if (ubicacion.top < 100) {
    console.log("Ya esta visible");
  } else {
    console.log("Aún no esta visible..");
  }
});
