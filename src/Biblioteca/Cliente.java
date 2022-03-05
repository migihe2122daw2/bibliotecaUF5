package Biblioteca;

public abstract class Cliente {

    // Atributos

    public String dni;
    public String nombre;
    public String apellidos;
    public String email;

    
    // Constructor
    
    public Cliente() {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;

    }

    public Cliente(String nombre5, String apellidos5, String dni5, String email5) {
        this.dni = dni5;
        this.nombre = nombre5;
        this.apellidos = apellidos5;
        this.email = email5;
    }

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.dni = dni;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public abstract Integer devolverLibro(int isbn);


}
