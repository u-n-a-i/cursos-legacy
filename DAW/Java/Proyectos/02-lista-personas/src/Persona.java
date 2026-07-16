public class Persona {
    // Atributos
    private int id;
    private String nombre;
    private String tel;
    private String email;
    private static int numeroPersonas = 0;

    // Constructor
    public Persona() {
        this.id = ++Persona.numeroPersonas;
    }

    public Persona(String nombre, String tel, String email) {
        this();
        this.nombre = nombre;
        this.tel = tel;
        this.email = email;
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getNumeroPersonas() {
        return numeroPersonas;
    }

    public static void setNumeroPersonas(int numeroPersonas) {
        Persona.numeroPersonas = numeroPersonas;
    }

    // To String

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
