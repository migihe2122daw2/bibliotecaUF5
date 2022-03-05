package Biblioteca;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Calendar;

public class Vinilos {
    //atributos
    public String nombre;
    public int canciones;
    public int id;
    public String fechaLanzamiento;
    private int cantidad;

    //Constructor
    public Vinilos(String nombre, int canciones, int id, String fechaLanzamiento, int cantidad) {
        this.nombre = nombre;
        this.canciones = canciones;
        this.id = id;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cantidad = cantidad;
    }

    public Vinilos(String nombre, int canciones, int id, String fechaLanzamiento) {
        this.nombre = nombre;
        this.canciones = canciones;
        this.id = id;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Vinilos() {
        this.nombre = nombre;
        this.canciones = canciones;
        this.id = id;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cantidad = cantidad;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCanciones() {
        return canciones;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //metodos

    public void PrestadoOno(){
        System.out.println("El vinilo se encuentra prestado");
    }

    public void devolverPrestado(){
        System.out.println("El vinilo se ha devuelto");
    }

    public String Prestar(int id, ArrayList<Vinilos> vinilos, ArrayList<ClienteEscolaMusica> clienteEscolaMusica) {

        String prestamo = null;
        // Prestar el vinilo

        // Preguntar datos del usuarioEscuela

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del usuario");
        String nombre = sc.nextLine();
        System.out.println("Introduce el apellido del usuario");
        String apellido = sc.nextLine();
        System.out.println("Introduce el DNI del usuario");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre de la escuela");
        String escuela = sc.nextLine();

        // Buscar el usuario por el dni

        for (int i = 0; i < clienteEscolaMusica.size(); i++) {
            if (Objects.equals(clienteEscolaMusica.get(i).getDni(), dni)) {
                // FECHA DE PRESTAMO
                Calendar fecha = Calendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int mes = fecha.get(Calendar.MONTH);
                int anio = fecha.get(Calendar.YEAR);
                String fechaPrestamo = dia + "/" + mes + "/" + anio;

                // Mostrar datos del usuario

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("DNI: " + dni);
                System.out.println("Escuela: " + escuela);
                System.out.println("Fecha de prestamo:" + dia + "/" + mes + "/" + anio);
                // Buscar el vinilo con metodo buscarVinilo

                Vinilos vinilo = buscar(vinilos, id);

                // Mostrar datos del vinilo

                System.out.println("Nombre: " + vinilo.nombre);
                System.out.println("Canciones: " + vinilo.canciones);
                System.out.println("ID: " + vinilo.id);
                System.out.println("Fecha de lanzamiento: " + vinilo.fechaLanzamiento);
                System.out.println("El vinilo se tiene que devolver en un mes");

                // Fehca de devolucion

                Calendar fechaDevolucion = Calendar.getInstance();
                fechaDevolucion.add(Calendar.MONTH, 1);
                int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
                int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
                int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

                String fechaDevolucionString = diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion;

                System.out.println("Fecha de devolucion: " + fechaDevolucionString);

                vinilo.setCantidad(vinilo.getCantidad() -1);
                break;

            }else{
                System.out.println("El cliente no existe");

                ClienteEscolaMusica clienteEsc = new ClienteEscolaMusica(nombre, apellido, dni);
                clienteEscolaMusica.add(clienteEsc);

                Calendar fecha = Calendar.getInstance();
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                fecha.add(Calendar.MONTH, 1);
                int mes = fecha.get(Calendar.MONTH);
                int anio = fecha.get(Calendar.YEAR);

                //Mostrar datos del usuario
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: "+ apellido);
                System.out.println("DNI: "+ dni);
                System.out.println("Fecha de prestamo: "+ dia + "/" + mes + "/" + anio);

                // Buscar el libro con el id usando el metodo buscarLibro
                Vinilos vinilo = buscar(vinilos, id);

                // Mostrar datos del libro

                System.out.println("Nombre: " + vinilo.nombre);
                System.out.println("Canciones: " + vinilo.canciones);
                System.out.println("ID: " + vinilo.id);
                System.out.println("Fecha de lanzamiento: " + vinilo.fechaLanzamiento);
                System.out.println("El vinilo se tiene que devolver en un mes");

                // Fehca de devolucion

                Calendar fechaDevolucion = Calendar.getInstance();
                fechaDevolucion.add(Calendar.MONTH, 1);
                int diaDevolucion = fechaDevolucion.get(Calendar.DAY_OF_MONTH);
                int mesDevolucion = fechaDevolucion.get(Calendar.MONTH);
                int anioDevolucion = fechaDevolucion.get(Calendar.YEAR);

                String fechaDevolucionString = diaDevolucion + "/" + mesDevolucion + "/" + anioDevolucion;

                System.out.println("Fecha de devolucion: " + fechaDevolucionString);

                vinilo.setCantidad(vinilo.getCantidad() -1);
                break;

        }
        }
        return nombre;
    }

    public static void devolverVinilos(ArrayList<Vinilos> vinilos, int idPrestado){
        //buscar el vinilo con el isbn usando el metodo buscarVinilo
        Vinilos vinilo = buscar(vinilos, idPrestado);

        // Actualizar la cantidad del libro

        vinilo.setCantidad(vinilo.getCantidad() + 1);

    }



    public static Vinilos buscar(ArrayList<Vinilos> vinilos, int id){
        for (int i = 0; i < vinilos.size(); i++){
            if (vinilos.get(i).getId() == id){
                return vinilos.get(i);
            }
        }
        return null;
    }



    public void Comprar(int idCompra, ArrayList<Vinilos> vinilos){
    }

}
