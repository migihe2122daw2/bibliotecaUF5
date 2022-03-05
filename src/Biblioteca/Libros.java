package Biblioteca;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

public class Libros<tematica> {
    private static String titulo;
    protected tematica tematica;

    // Atributos


    private String autor;
    private int isbn;
    private int cantidad;
    private int precio; // ESTO SERA UN POLIMORFISMO

    // Constructor

    /**
     *
     * @param titulo
     * @param autor
     * @param isbn
     * @param cantidad
     * @param precio
     *
     * Metodo para crear un libro
     */
    public Libros(String titulo, String autor, int isbn, int cantidad, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.precio = precio;
    }


    public Libros() {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Libros(tematica tematica) {
        this.tematica = tematica;
    }

    public static String getTitulo(int isbn) {
        return titulo;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //metodos

    public void devolverPrestado() {
        System.out.println("El vinilo se ha devuelto");
    }

    /**
     *
     * @param isbnPrestado
     * @param libros
     * @param clientePrivados
     * @return
     *
     * Metodo para prestar un libro
     */

    public String Prestar(int isbnPrestado, ArrayList<Libros> libros, ArrayList<ClientePrivado> clientePrivados) {

        String prestamo = null;
        // Prestar el libro

        // Preguntar datos del usuario

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el nombre del usuario");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del usuario");
        String apellido = sc.nextLine();
        System.out.println("Introduzca el DNI del usuario");
        String dni = sc.nextLine();

        // Buscar el cliente por el dni

        for (int i = 0; i < clientePrivados.size(); i++) {
            if (Objects.equals(clientePrivados.get(i).getDni(), dni)) {
                Calendar fecha = Calendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                fecha.add(Calendar.MONTH, 1);
                int mes = fecha.get(Calendar.MONTH);
                int anio = fecha.get(Calendar.YEAR);


                // Mostrar datos del usuario

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("DNI: " + dni);
                System.out.println("Fecha de prestamo: " + dia + "/" + mes + "/" + anio);

                // Buscar el libro con el isbn usando el metodo buscarLibro

                Libros libro = buscar(libros, isbnPrestado);

                // Mostrar datos del libro

                System.out.println("Titulo: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("ISBN: " + libro.getIsbn());

                // Decir que devuelva el libro en un mes

                System.out.println("El libro se tiene que devolver en un mes");

                // Poner fecha de devolucion

                Calendar fechaDevolucion = Calendar.getInstance();
                fechaDevolucion.add(Calendar.MONTH, 2);
                int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
                int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
                int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

                // Mostrar fecha de devolucion

                System.out.println("Fecha de devolucion: " + diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion);

                // Actualizar la cantidad del libro

                libro.setCantidad(libro.getCantidad() - 1);
                break;
            } else {

                System.out.println("El cliente no existe");

                // Crear un cliente nuevo

                ClientePrivado cliente = new ClientePrivado(nombre, apellido, dni);
                clientePrivados.add(cliente);

                Calendar fecha = Calendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                fecha.add(Calendar.MONTH, 1);
                int mes = fecha.get(Calendar.MONTH);
                int anio = fecha.get(Calendar.YEAR);


                // Mostrar datos del usuario

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("DNI: " + dni);
                System.out.println("Fecha de prestamo: " + dia + "/" + mes + "/" + anio);

                // Buscar el libro con el isbn usando el metodo buscarLibro

                Libros libro = buscar(libros, isbnPrestado);

                // Mostrar datos del libro

                System.out.println("Titulo: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("ISBN: " + libro.getIsbn());

                // Decir que devuelva el libro en un mes

                System.out.println("El libro se tiene que devolver en un mes");

                // Poner fecha de devolucion

                Calendar fechaDevolucion = Calendar.getInstance();
                fechaDevolucion.add(Calendar.MONTH, 2);
                int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
                int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
                int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

                // Mostrar fecha de devolucion

                System.out.println("Fecha de devolucion: " + diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion);

                // Crear string con todos los datos

                prestamo = "Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nFecha de prestamo: " + dia + "/" + mes + "/" + anio + "\nTitulo: " + libro.getTitulo() + "\nAutor: " + libro.getAutor() + "\nISBN: " + libro.getIsbn() + "\nEl libro se tiene que devolver en un mes" + "\nFecha de devolucion: " + diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion;

                // Actualizar la cantidad del libro



                libro.setCantidad(libro.getCantidad() - 1);
                break;
            }
        }

        return nombre;

    }

    // Devolver libro

    /**
     * Metodo que devuelve un libro
     * @param libros
     * @param isbnPrestado
     */

    public static void devolverLibros(ArrayList<Libros> libros, int isbnPrestado) {

        // Buscar el libro con el isbn usando el metodo buscarLibro

        Libros libro = buscar(libros, isbnPrestado);

        // Actualizar la cantidad del libro

        libro.setCantidad(libro.getCantidad() + 1);

    }

    public void Comprar(int isbnCompra, ArrayList<Libros> libros) { // ESTO SERA UN POLIMORFISMO


    }

    /**
     * Metodo que busca un libro
     * @param libros
     * @param isbn
     * @return
     */
    public static Libros buscar(ArrayList<Libros> libros, int isbn) { // el metodo buscarLibro recibe un arraylist de libros y un isbn,
        // es un polimorfismo
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn() == isbn) {
                // DEVOLVER EL LIBRO CON TODOS SUS DATOS EN FORMATO STRING
                return libros.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo que muestra los libros
     * @param libros
     * @param isbn
     * @param cantidad
     * @throws CloneNotSupportedException
     */

    public static void clonar(ArrayList<Libros> libros, int isbn, int cantidad) throws CloneNotSupportedException {
        // Comprobar que el libro no existe
        boolean existe = false;
        for (Libros libro : libros) {
            if (libro.getIsbn() == isbn) {
                existe = true;
                // Clonar el libro existente con el metodo clone
                Libros libroClonado = (Libros) libro.clone();
                libroClonado.setCantidad(libroClonado.getCantidad() + cantidad);
            }
        }
    }

}
