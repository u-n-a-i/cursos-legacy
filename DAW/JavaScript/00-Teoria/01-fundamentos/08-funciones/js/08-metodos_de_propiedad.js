// Métodos de propiedad, funciones dentro de objetos

const reproductor = {
  reproducir: function (id) {
    console.log(`Reproduciendo canción id ${id}`);
  },
  pausar: function () {
    console.log("pausando...");
  },
  borrar: function (id) {
    console.log(`Borrando canción con id: ${id}`);
  },
  crearPlaylist: function (nombre) {
    console.log(`Creando la Playlist ${nombre}`);
  },
  reproducirPlaylist: function (nombre) {
    console.log(`Reproduciendo la Playlist ${nombre}`);
  },
};

reproductor.reproducir(30);
reproductor.pausar();
reproductor.borrar(20);
reproductor.crearPlaylist("Heavy Metal");
reproductor.reproducirPlaylist("Heavy Metal");
