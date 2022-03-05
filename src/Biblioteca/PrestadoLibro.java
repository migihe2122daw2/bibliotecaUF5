package Biblioteca;
import java.util.Calendar;

public class PrestadoLibro {

    //atributos
    private ClientePrivado CodigoPostal;
    private ClientePrivado Nombre;
    private Libros titol;
    private String titolS;
    private int isbnI;
    private String autorS;
    private int cantidadI;
    private Libros isbn;
    private Libros autor;
    private Libros cantidad;
    private Calendar f_entrada;
    private Calendar f_devolucion;
    public String multa;

    //Constructor

    public PrestadoLibro(ClientePrivado CodigoPostal, ClientePrivado nombre, Libros titol, Libros isbn, Libros autor, Libros cantidad, Calendar f_entrada, Calendar f_devolucion, String multa) {
        this.CodigoPostal = CodigoPostal;
        this.Nombre = nombre;
        this.titol = titol;
        this.isbn = isbn;
        this.autor = autor;
        this.cantidad = cantidad;
        this.f_entrada = f_entrada;
        this.f_devolucion = f_devolucion;
        this.multa = multa;
    }

    public PrestadoLibro(){

    }



    //getters y setters




    public PrestadoLibro(String titulo, String autor, int isbn, int cantidad) {
        this.titolS = titulo;
        this.autorS = autor;
        this.isbnI = isbn;
        this.cantidadI = cantidad;
    }

    public void setCodigoPostal(ClientePrivado codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    public Libros getTitol() {
        return titol;
    }

    public void setTitol(Libros titol) {
        this.titol = titol;
    }

    public Libros getIsbn() {
        return isbn;
    }

    public void setIsbn(Libros isbn) {
        this.isbn = isbn;
    }

    public Libros getAutor() {
        return autor;
    }

    public void setAutor(Libros autor) {
        this.autor = autor;
    }

    public Libros getCantidad() {
        return cantidad;
    }

    public void setCantidad(Libros cantidad) {
        this.cantidad = cantidad;
    }

    public Calendar getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(Calendar f_entrada) {
        this.f_entrada = f_entrada;
    }

    public Calendar getF_devolucion() {
        return f_devolucion;
    }

    public void setF_devolucion(Calendar f_devolucion) {
        this.f_devolucion = f_devolucion;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String toString(){
        return "Codigo Postal: " + CodigoPostal + "\n" + "Titulo: " + titol + "\n" + "ISBN: " + isbn + "\n" + "Autor: " + autor + "\n" + "Cantidad: " + cantidad + "\n" + "Fecha de entrada: " + f_entrada + "\n" + "Fecha de devolucion: " + f_devolucion + "\n" + "Multa: " + multa;
    }

    //metodos

    public void multa() {

        // Se multara el libro si la fecha de devolucion es menor a la fecha de entrada

        if (f_devolucion.compareTo(f_entrada) < 0) {
            multa = "Multa";
        } else {
            multa = "No Multa";
        }

        switch (multa) {
            case "Multa":
                System.out.println("El libro esta multado");
                break;
            case "No Multa":
                System.out.println("El libro no esta multado");
                break;
        }

    }

    // Metodo para guardar los libros que se han prestado


}

