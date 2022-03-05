package Biblioteca;

import java.util.ArrayList;

public class Trabajador extends Usuario{

    public String dni;
    public String nombre;
    public String apellido;
    public String email;
    public String usuario = "encarregat";
    public String password = "encarregat";

    // Constructor

    public Trabajador(){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    public Trabajador(String dni, String nombre, String apellido, String email, String usuario, String password){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    public Trabajador(String nombre, String apellido, String dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }




    // Getters y Setters

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(){
        this.usuario = usuario;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }



}

    // Metodos

