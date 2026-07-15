package programacion_funcional;

import java.util.Optional;

class Usuario {
    private String email;

    public Usuario(String email) {
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

public class EjemploOptional {
    public static Optional<Usuario> obtenerUsuarioPorId(int id) {
        if (id == 123) {
            return Optional.of(new Usuario("usuario@example.com"));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<Usuario> usuario = obtenerUsuarioPorId(123);

        String email = usuario.flatMap(Usuario::getEmail)
                .orElse("Email no encontrado");
        System.out.println("Email del usuario: " + email);

        Optional<Usuario> usuarioNoEncontrado = obtenerUsuarioPorId(456);
        String emailNoEncontrado = usuarioNoEncontrado.flatMap(Usuario::getEmail)
                .orElse("Email no encontrado");
        System.out.println("Email del usuario no encontrado: " + emailNoEncontrado);
    }
}
