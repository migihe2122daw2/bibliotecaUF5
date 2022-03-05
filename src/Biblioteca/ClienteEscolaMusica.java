package Biblioteca;

import java.util.ArrayList;

public class ClienteEscolaMusica extends Cliente {

    // Atributos

    public String nombreEscuela;


    // Constructor

    public ClienteEscolaMusica() {
        this.nombreEscuela = nombreEscuela;
    }

    @Override
    public Integer devolverLibro(int isbn) {
        return null;
    }


    public ClienteEscolaMusica(String dni9, String nombre9, String apellidos9, String email9, String escuela9) {
        super(dni9, nombre9, apellidos9, email9);
        this.nombreEscuela = escuela9;
    }

    public ClienteEscolaMusica(String nombre, String apellido, String dni, String nombreEscuela) {
        super(nombre, apellido, dni);
        this.nombreEscuela = nombreEscuela;
    }

    public ClienteEscolaMusica(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    // Getters y Setters

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    /**
     * Metodo que devuelve una lista de libros que tiene el cliente
     */
    ArrayList<Integer> vinilos = new ArrayList<>();
    //Guardar isbn del libro prestado
    public void guardarVinilo(Vinilos vinilo){
        vinilos.add(vinilo.getId());
        System.out.println("Vinilos guardados");
    }

    //comparar isbn

    /**
     * Metodo que devuelve una lista de libros que tiene el cliente
     * @param id
     * @return
     */
    public boolean comprobarVinilos(int id){
        if(vinilos.contains(id)){
            return true;
        }
        return false;
    }

    // Devolver libro
    public Integer devolverVinilos(int id){
        vinilos.removeIf(i -> i == id);
            return null;
    }

}


