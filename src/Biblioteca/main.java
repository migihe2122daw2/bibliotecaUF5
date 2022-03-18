package Biblioteca;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.*;
import java.util.function.ToDoubleBiFunction;

public class main {

    /**
     * @param args the command line arguments
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException, IOException {

        // Main class for all the biblio-related stuff

        // Primero creamos libros
        Libros Libro1 = new Libros("El camino de los reyes", "Brandon Sanderson", 1212, 3, 30);
        Libros Libro2 = new Libros("Indigno de ser humano", "Osamu Dazai", 5626, 1, 19);
        Libros Libro3 = new Libros("Dime quien soy", "Julia Navarro", 8233, 5, 20);
        Libros Libro4 = new Libros("La chica del tren", "Paula Hawkins", 9024, 2, 16);
        Libros Libro5 = new Libros("Los renglones torcidos de Dios", "Torcuato Luca de Tena", 2010, 10, 15);
        Libros Libro6 = new Libros("Tan poca vida", "Hanya Yanagihara", 1256, 20, 17);
        Libros Libro7 = new Libros("1984", "George Orwell", 9983, 4, 15);

        // TODO: LINKEDLIST (Añadir libros a linkedlist)

        List<Libros> libros = new LinkedList<Libros>();
        libros.add(Libro1);
        libros.add(Libro2);
        libros.add(Libro3);
        libros.add(Libro4);
        libros.add(Libro5);
        libros.add(Libro6);
        libros.add(Libro7);


        // Creamos los vinilos
        // TODO: ARRAYLIST
        ArrayList<Vinilos> vinilos = new ArrayList<Vinilos>();

        Vinilos vinilos1 = new Vinilos("Fine line", 12, 01, "03/05/2018", 9);
        Vinilos vinilos2 = new Vinilos("Evermore", 10, 02, "20/05/2012", 1);
        Vinilos vinilos3 = new Vinilos("Nevermind", 12, 03, "08/03/1991", 9);
        Vinilos vinilos4 = new Vinilos("The doors", 11, 04, "19/10/2010", 10);
        Vinilos vinilos5 = new Vinilos("Morrison Hotel", 11, 05, "21/09/2015", 4);

        vinilos.add(vinilos1);
        vinilos.add(vinilos2);
        vinilos.add(vinilos3);
        vinilos.add(vinilos4);
        vinilos.add(vinilos5);


        // Crear usuario administrador en un array estatico
        Administrador admin1[] = new Administrador[1];
        admin1[0] = new Administrador("Biblioteca/admin", "Biblioteca/admin");


        // Crear cliente Privado
        // TODO: HASHMAP
        Map<String, ClientePrivado> clientesPrivados = new HashMap<>();
        ClientePrivado clientePrivado1 = new ClientePrivado("Juan", "Perez", "2131231", "juan1989@gmail.com", "1989");
        ClientePrivado clientePrivado2 = new ClientePrivado("Felipe", "Armadillo", "257239", "ArmadilloGOD@gmail.com", "1182");
        ClientePrivado clientePrivado3 = new ClientePrivado("Amanda", "Flores", "654932", "floresitamanda@gmail.com", "1009");

        clientesPrivados.put(clientePrivado1.getDni(), clientePrivado1);
        clientesPrivados.put(clientePrivado2.getDni(), clientePrivado2);
        clientesPrivados.put(clientePrivado3.getDni(), clientePrivado3);


        // Crear cliente escuela privada
        // TODO: TREEMAP
        Map<String, ClienteEscolaMusica> clienteEscuelaM = new TreeMap();
        ClienteEscolaMusica clienteEscola1 = new ClienteEscolaMusica("Tania", "Torres", "231312", "taniaat@gmail.com", "Clot");
        ClienteEscolaMusica clienteEscola2 = new ClienteEscolaMusica("Manolo", "Lopez", "987123", "manolin@gmail.com", "Clot");
        ClienteEscolaMusica clienteEscola3 = new ClienteEscolaMusica("Mariola", "Serrano", "561209", "mariiola1@gmail.com", "Clot");

        clienteEscuelaM.put(clienteEscola1.getDni(), clienteEscola1);
        clienteEscuelaM.put(clienteEscola2.getDni(), clienteEscola2);
        clienteEscuelaM.put(clienteEscola3.getDni(), clienteEscola3);


        // Crear trabajadores
        //TODO: LinkedHashSet
        Set<Trabajador> trabajadores = new LinkedHashSet<Trabajador>();
        Trabajador trabajadores1 = new Trabajador("1234", "Alberto", "de la Capital", "capitalalberto@gmail.com", "encarregat", "encarregat");
        Trabajador trabajadores2 = new Trabajador("1235", "Juan", "Alberto", "albertojuan@gmail.com", "encarregat", "encarregat");
        Trabajador trabajadores3 = new Trabajador("1236", "Carlos", "Fernandez", "fernandezcarlos@gmail.com", "encarregat", "encarregat");

        trabajadores.add(trabajadores1);
        trabajadores.add(trabajadores2);
        trabajadores.add(trabajadores3);


        // Crear prestamos

        //TODO: TREESET
        TreeSet<PrestadoLibro> prestamosLibros = new TreeSet<>();

        //TODO: HASHSET
        HashSet<PrestadoVinilo> prestamosVinilos = new HashSet<>();

        //TODO: PARTE DE CLASE GENERICA
        Vinilos Vinilocomentario = new Vinilos();
        Libros Libroscomentario = new Libros();


        // Swwitch case para el menu

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            // Hacer login para acceder al menu

            System.out.println("Indica que tipo de usuario eres: ");
            System.out.println("1. Usuario Privado");
            System.out.println("2. Usuario Escuela de musica");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");

            opcion = 0;
            // TODO: EXCEPCIÓN PROPIA
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new Excepcion(e.getMessage());
            }
            switch (opcion) {
                case 1:
                    System.out.println("Introduce tu nombre de usuario: ");
                    String usuarioP = sc.next();
                    System.out.println("Introduce tu contraseña: ");
                    String contrasenaP = sc.next();

                    // Comprobar que el usuario y contraseña son correctos
                    boolean correcto = false;

                    // Leer el archivo encarregat
                    FileReader frE2 = new FileReader("src/Biblioteca/encarregat");
                    BufferedReader brE2 = new BufferedReader(frE2);
                    String lineaE2;
                    while ((lineaE2 = brE2.readLine()) != null) {
                        String[] datosE2 = lineaE2.split(",");
                        if (datosE2[0].equals(usuarioP) && datosE2[1].equals(contrasenaP)) {
                            correcto = true;
                        }
                    }

                    // Si el usuario y contraseña son correctos, acceder al menu
                    if (correcto) {
                        do {
                            System.out.println("Escoge un libro");

                            // Iterator para recorrer el arraylist
                            Iterator<Libros> it = libros.iterator();
                            while (it.hasNext()) {
                                Libros libro = it.next();
                                System.out.println("ISBN: " + libro.getIsbn() + "\n Titulo: " + libro.getTitulo() + "\n Autor: " + libro.getAutor() + "\n");
                            }
                            System.out.println("Escribe el isbn del libro que quiere o 99 para salir: ");

                            // Con el isbn buscamos el libro en el arraylist y lo pasamos a la clase libros al metodo PrestadoOno
                            int isbn = sc.nextInt();
                            if (isbn == 99) {
                                break;
                            }

                            // Comprobar que el isbn esta en el ArrayList
                            boolean encontrado = false;
                            Iterator<Libros> it2 = libros.iterator();
                            while (it2.hasNext()) {
                                Libros libro = it2.next();
                                if (libro.getIsbn() == isbn) {
                                    encontrado = true;
                                }
                            }

                            for (Libros libro : libros) {

                                if (libro.getIsbn() == isbn) {


                                    // Si el libro no esta prestado, se le puede presta
                                    if (libro.getCantidad() >= 1) {

                                        int numeroEscape = 0;

                                        do {

                                            System.out.println("\nHay " + libro.getCantidad() + " libros disponibles");
                                            System.out.println("Quieres prestar o devolver el libro? (1. Si, 2. No)");
                                            int opcion2 = sc.nextInt();
                                            if (opcion2 == 1) {

                                                System.out.println("\nQuieres prestar el libro(1) o devolverlo(2)?");
                                                int opcion21 = sc.nextInt();
                                                if (opcion21 == 1) {
                                                    // Prestar libro


                                                    String nombre = libro.Prestar(libro.getIsbn(), libros, clientesPrivados);
                                                    sc.nextLine();
                                                    // Leer valor de la variable de retorno del metodo Prestar

                                                    // Guardar el libro prestado en el metodo guardarLibro de ClientePrivado
                                                    for (Map.Entry<String, ClientePrivado> entry : clientesPrivados.entrySet()) {
                                                        if (entry.getKey().equals(nombre)) {
                                                            ClientePrivado clientePrivado = entry.getValue();
                                                            clientePrivado.guardarLibro(libro);
                                                            System.out.println("Pulsa cualquier tecla para continuar");
                                                            sc.nextLine();
                                                            numeroEscape = 1;
                                                        }
                                                    }

                                                    // Guardar datos del prestamo en el fichero prestamos.txt
                                                    try {
                                                        FileWriter fw = new FileWriter("src/Biblioteca/prestamos", true);
                                                        BufferedWriter bw = new BufferedWriter(fw);
                                                        PrintWriter pw = new PrintWriter(bw);
                                                        pw.println(libro.getIsbn() + " " + nombre);
                                                        pw.close();
                                                    } catch (IOException e) {
                                                        System.out.println("Error al escribir en el fichero");
                                                    }
                                                } else if (opcion21 == 2) {
                                                    System.out.println("\nIndica el isbn y el nombre del cliente que quiere devolver el libro");
                                                    System.out.println("ISBN: ");
                                                    int isbn22 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Nombre: ");
                                                    String nombre22 = sc.nextLine();
                                                    for (Map.Entry<String, ClientePrivado> entry : clientesPrivados.entrySet()) {
                                                        if (entry.getKey().equals(nombre22)) {
                                                            ClientePrivado clientePrivado = entry.getValue();
                                                            clientePrivado.devolverLibro(isbn22);
                                                            Libros.devolverLibros(libros, isbn22);
                                                            numeroEscape = 1;
                                                        }
                                                    }

                                                }

                                            } else if (opcion2 == 2) {
                                                int numeroEscape2 = 0;
                                                do {
                                                    System.out.println("Quieres comprar el libro? (1. Si, 2. No)");
                                                    int opcion3 = sc.nextInt();
                                                    if (opcion3 == 1) {
                                                        libro.Comprar(libro.getIsbn(), libros);
                                                    } else if (opcion3 == 2) {
                                                        System.out.println("No se ha realizado ninguna accion");
                                                        numeroEscape2 = 1;
                                                    }
                                                } while (numeroEscape2 == 0);
                                                numeroEscape = 1;

                                            }


                                        } while (numeroEscape == 0);

                                        break;
                                    } else if (libro.getCantidad() == 0) {
                                        System.out.println("No hay libros disponibles");
                                        // Decir quien tiene los libros prestados, mirar en el arraylist clientesPrivados
                                        for (Map.Entry<String, ClientePrivado> entry : clientesPrivados.entrySet()) {
                                            if (entry.getValue().comprobarLibro(libro.getIsbn())) {
                                                System.out.println("Los libros se encuentran prestados por " + entry.getKey());

                                                System.out.println("\nQuieres devolver el libro? (1. Si, 2. No)");
                                                int opcion23 = sc.nextInt();
                                                if (opcion23 == 1) {
                                                    entry.getValue().devolverLibro(libro.getIsbn());
                                                    Libros.devolverLibros(libros, isbn);
                                                }
                                            }

                                        }
                                        break;

                                    }
                                    sc.nextLine();
                                    System.out.println("Pulsa cualquier tecla para continuar");
                                    sc.nextLine();
                                }


                            }


                            if (encontrado == false) {
                                System.out.println("El isbn no existe");
                                System.out.println("Pulsa cualquier tecla para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }

                        } while (opcion != 4);
                        break;
                    } else {
                        System.out.println("No has iniciado sesion");
                        System.out.println("Pulsa cualquier tecla para continuar");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    }

                case 2:

                    System.out.println("Introduce tu nombre de usuario");
                    sc.nextLine();
                    String nombreUsuario = sc.nextLine();
                    System.out.println("Introduce tu contraseña");
                    String contrasena = sc.nextLine();

                    boolean encontradoE = false;

                    // leer el fichero de encarregat
                    FileReader frE = new FileReader("src/Biblioteca/encarregat");
                    BufferedReader brE = new BufferedReader(frE);
                    String lineaE;
                    while ((lineaE = brE.readLine()) != null) {
                        String[] datosE = lineaE.split(",");
                        if (datosE[0].equals(nombreUsuario) && datosE[1].equals(contrasena)) {
                            encontradoE = true;
                        }
                    }

                    if (encontradoE) {

                        do {

                            System.out.println("Escoge un vinilo: ");
                            // Iterator para recorrer el arraylist

                            Iterator<Vinilos> ite = vinilos.iterator();
                            while (ite.hasNext()) {
                                Vinilos vinilo = ite.next();
                                System.out.println("ID: " + vinilo.getId() + "\n Nombre: " + vinilo.getNombre() + "\n Numero de canciones: " + vinilo.getCanciones() + "\n\n");
                            }
                            System.out.println("Escribe el ID del vinilo que quiere o 99 para salir: ");

                            // Con el isbn buscamos el libro en el arraylist y lo pasamos a la clase libros al metodo PrestadoOno
                            int id = sc.nextInt();
                            if (id == 99) {
                                break;
                            }

                            // Comprobar que el id esta en el ArrayList
                            boolean encontrado1 = false;
                            Iterator<Vinilos> ite2 = vinilos.iterator();
                            while (ite2.hasNext()) {
                                Vinilos vinilo = ite2.next();
                                if (vinilo.getId() == id) {
                                    encontrado1 = true;
                                }
                            }

                            for (Vinilos vinilo : vinilos) {
                                if (vinilo.getId() == id) {
                                    System.out.println("El vinilo seleccionado es: " + vinilo.getNombre());
                                    System.out.println("El vinilo tiene " + vinilo.getCanciones() + " canciones");
                                    System.out.println("El vinilo salio a la venta el dia: " + vinilo.getFechaLanzamiento());

                                    if (vinilo.getCantidad() >= 1) {
                                        int numeroEscape = 0;
                                        do {
                                            System.out.println("\nHay" + vinilo.getCantidad() + "vinilos disponibles");
                                            System.out.println("Quieres ver prestar o devolver vinilo? (1. Si, 2. No)");
                                            int opcion2 = sc.nextInt();
                                            if (opcion2 == 1) {
                                                System.out.println("\nQuieres prestar el libro(1) o devolverlo(2)?");
                                                int opcion21 = sc.nextInt();
                                                if (opcion21 == 1) {
                                                    String nombre = vinilo.Prestar(vinilo.getId(), vinilos, clienteEscuelaM);
                                                    sc.nextLine();

                                                    //Guardar el libro prestado en el metodo guardarLibro de ClientePrivado
                                                    for (Map.Entry<String, ClienteEscolaMusica> entry : clienteEscuelaM.entrySet()) {
                                                        if (entry.getValue().getNombre().equals(nombre)) {
                                                            entry.getValue().guardarVinilo(vinilo);
                                                            System.out.println("Pulsa cualquier tecla para continuar");
                                                            sc.nextLine();
                                                            numeroEscape = 1;
                                                        }
                                                    }
                                                } else if (opcion21 == 2) {
                                                    System.out.println("\n Indica el isbn y el nombre del cliente que quiere devolver el libro");
                                                    System.out.println("ISBN: ");
                                                    int isbn22 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Nombre: ");
                                                    String nombre22 = sc.nextLine();
                                                    for (Map.Entry<String, ClienteEscolaMusica> entry : clienteEscuelaM.entrySet()) {
                                                        if (entry.getValue().getNombre().equals(nombre22)) {
                                                            entry.getValue().devolverLibro(isbn22);
                                                            Vinilos.devolverVinilos(vinilos, isbn22);
                                                            numeroEscape = 1;
                                                        }
                                                    }
                                                }
                                            } else if (opcion2 == 2) {
                                                int numeroEscape3 = 0;
                                                do {
                                                    System.out.println("Quieres comprar el libro? (1.Si, 2.No)");
                                                    int opcion3 = sc.nextInt();
                                                    if (opcion3 == 1) {
                                                        vinilo.Comprar(vinilo.getId(), vinilos);
                                                    } else if (opcion3 == 2) {
                                                        System.out.println("No se ha realizado ninguna acción");
                                                        numeroEscape3 = 1;

                                                    }
                                                } while (numeroEscape3 == 0);
                                                numeroEscape = 1;
                                            }

                                        } while (numeroEscape == 0);
                                        break;
                                    } else if (vinilo.getCantidad() == 0) {
                                        System.out.println("No hay vinilos disponibles");
                                        //Decir quien tiene los vinilos prestados, mirar en el arraylist ClientesMusica
                                        for (Map.Entry<String, ClienteEscolaMusica> entry : clienteEscuelaM.entrySet()) {
                                            if (entry.getValue().comprobarVinilos(vinilo.getId())) {
                                                System.out.println("Los libros se encuentran prestados por" + entry.getValue().getNombre());

                                                System.out.println("\n Quieres devolver el libro (1.Si, 2.No)");
                                                int opcion24 = sc.nextInt();
                                                if (opcion24 == 1) {
                                                    entry.getValue().devolverLibro(vinilo.getId());
                                                    Vinilos.devolverVinilos(vinilos, id);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    sc.nextLine();
                                    System.out.println("Pulsa cualquier tecla para continuar");
                                    sc.nextLine();
                                }
                            }

                            if (encontradoE == false) {
                                System.out.println("El id no existe");
                                System.out.println("Pulsa cualquier tecla para continuar");
                                sc.nextLine();
                                sc.nextLine();
                            }

                        } while (opcion != 4);
                        break;
                    } else {
                        System.out.println("Usuario o contraseña incorrectos");
                        System.out.println("Pulsa cualquier tecla para continuar");
                        sc.nextLine();
                        break;
                    }
                case 3:
                    int oportunidades = 3;
                    do {

                        // Pedir usuario y contraseña
                        System.out.println("Introduce tu usuario: ");
                        sc.nextLine();
                        String usuario = sc.nextLine();
                        System.out.println("Introduce tu contraseña: ");
                        String contrasena1 = sc.nextLine();
                        boolean encontrado = false;
                        // Comprobar que el usuario y contraseña son correctos usando el archivo de admin
                        // Leer el archivo de admin
                        FileReader fr = new FileReader("src/Biblioteca/admin");
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            String[] datos = linea.split(",");
                            if (datos[0].equals(usuario) && datos[1].equals(contrasena1)) {
                                encontrado = true;
                                break;
                            }
                        }
                        /*
                        for (int i = 0; i < admin1.length; i++) {
                            if (admin1[i].getUsuario().equals(usuario) && admin1[i].getContra().equals(contrasena1)) {
                                encontrado = true;
                            }
                        }*/

                        // Si falla la contraseña o el usuario se repite hasta 3 veces
                        if (encontrado == false) {
                            System.out.println("Usuario o contraseña incorrectos");
                            oportunidades--;
                        }


                        if (encontrado == true) {
                            System.out.println("Bienvenido " + usuario);
                            opcion = 0;
                            do {

                                // Menu de opciones
                                System.out.println("1. Gestión de libros");
                                System.out.println("2. Gestión discos de vinilo: ");
                                System.out.println("3. Gestión de clientes: ");
                                System.out.println("4. Gestión de trabajadores: ");
                                System.out.println("5. Salir");

                                opcion = sc.nextInt();
                                sc.nextLine();

                                switch (opcion) {
                                    case 1:
                                        int opcion2 = 0;
                                        do {
                                            System.out.println("1. Añadir libro");
                                            System.out.println("2. Eliminar libro");
                                            System.out.println("3. Modificar libro");
                                            System.out.println("4. Ver libros");
                                            System.out.println("5. Libros que estaran disponible proximamente");
                                            System.out.println("6. Añadir libro a la lista de libros que estaran disponibles proximamente");
                                            System.out.println("7. Ver libros en prestamo");
                                            System.out.println("8. Salir");

                                            opcion2 = sc.nextInt();
                                            sc.nextLine();

                                            switch (opcion2) {
                                                case 1:
                                                    System.out.println("Introduce el titulo del libro: ");
                                                    String titulo = sc.nextLine();
                                                    System.out.println("Introduce el autor del libro: ");
                                                    String autor = sc.nextLine();
                                                    System.out.println("Introduce el isbn del libro: ");
                                                    int isbn = sc.nextInt();
                                                    System.out.println("Introduce la cantidad de libros: ");
                                                    int cantidad = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce el precio del libro: ");
                                                    int precio = sc.nextInt();
                                                    sc.nextLine();
                                                    // TODO: CLONAR LIBRO
                                                    Libros.clonar(libros, isbn, cantidad);

                                                    libros.add(new Libros(titulo, autor, isbn, cantidad, precio));
                                                    break;
                                                case 2:
                                                    System.out.println("Introduce el isbn del libro que quieres eliminar: ");
                                                    int isbn2 = sc.nextInt();
                                                    sc.nextLine();
                                                    libros.removeIf(libro -> libro.getIsbn() == isbn2);
                                                    break;
                                                case 3:
                                                    System.out.println("Introduce el isbn del libro que quieres modificar: ");
                                                    int isbn3 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Libros libro : libros) {
                                                        if (libro.getIsbn() == isbn3) {
                                                            System.out.println("Introduce el nuevo titulo del libro: ");
                                                            String titulo2 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo autor del libro: ");
                                                            String autor2 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo isbn del libro: ");
                                                            int isbn4 = sc.nextInt();
                                                            System.out.println("Introduce la nueva cantidad de libros: ");
                                                            int cantidad2 = sc.nextInt();
                                                            sc.nextLine();
                                                            System.out.println("Introduce el nuevo precio del libro: ");
                                                            int precio2 = sc.nextInt();
                                                            sc.nextLine();
                                                            libro.setTitulo(titulo2);
                                                            libro.setAutor(autor2);
                                                            libro.setIsbn(isbn4);
                                                            libro.setCantidad(cantidad2);
                                                            libro.setPrecio(precio2);
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    //TODO: CLASE GENERICA 2
                                                    Libroscomentario.setLibroComentario("Introduce el isbn del libro que quieres consultar: ");
                                                    Libroscomentario.getLibroComentario();
                                                    int isbn5 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Libros libro : libros) {
                                                        if (libro.getIsbn() == isbn5) {
                                                            System.out.println("Titulo: " + libro.getTitulo());
                                                            System.out.println("Autor: " + libro.getAutor());
                                                            System.out.println("ISBN: " + libro.getIsbn());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    // Mostrar libros que estaran disponible proximamente en la biblioteca utilizando el archivo libros.xml

                                                    //Leer fichero xml

                                                    try {

                                                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        DocumentBuilder builder = factory.newDocumentBuilder();
                                                        Document document = builder.parse(new File("src/Biblioteca/libros.xml"));
                                                        document.getDocumentElement().normalize();

                                                        // Mostrar los libros

                                                        NodeList nList = document.getElementsByTagName("libro");
                                                        for (int temp = 0; temp < nList.getLength(); temp++) {

                                                            Node nNode = nList.item(temp);

                                                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                                                Element eElement = (Element) nNode;

                                                                System.out.println("\n Libro " + (temp + 1) + " : \n");
                                                                System.out.println("Titulo: " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                                                                System.out.println("Autor: " + eElement.getElementsByTagName("autor").item(0).getTextContent());
                                                                System.out.println("ISBN: " + eElement.getElementsByTagName("isbn").item(0).getTextContent());
                                                                System.out.println("Cantidad: " + eElement.getElementsByTagName("cantidad").item(0).getTextContent());
                                                                System.out.println("Precio: " + eElement.getElementsByTagName("precio").item(0).getTextContent());

                                                            }
                                                        }

                                                    } catch (Excepcion e) {
                                                        e.printStackTrace();
                                                    } catch (ParserConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    } catch (SAXException e) {
                                                        e.printStackTrace();
                                                    }

                                                    break;
                                                case 6:
                                                    // Añadir un libro a la lista de libros que se añadiran a la biblioteca proximamente utilizando el archivo libros.xml

                                                    //Leer fichero xml


                                                    try {

                                                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        DocumentBuilder builder = factory.newDocumentBuilder();
                                                        Document document = builder.parse(new File("src/Biblioteca/libros.xml"));
                                                        document.getDocumentElement().normalize();

                                                        // Añadir libro

                                                        System.out.println("\nAñadir libro\n");
                                                        System.out.println("Titulo: ");
                                                        String tituloV = sc.nextLine();
                                                        System.out.println("Autor: ");
                                                        String autorV = sc.nextLine();
                                                        System.out.println("ISBN: ");
                                                        String isbnV = sc.nextLine();
                                                        System.out.println("Cantidad: ");
                                                        int cantidadV = sc.nextInt();
                                                        System.out.println("Precio: ");
                                                        double precioV = sc.nextDouble();

                                                        Element libro = document.createElement("libro");
                                                        Element tituloLibro = document.createElement("titulo");
                                                        tituloLibro.appendChild(document.createTextNode(tituloV));
                                                        Element autorLibro = document.createElement("autor");
                                                        autorLibro.appendChild(document.createTextNode(autorV));
                                                        Element isbnLibro = document.createElement("isbn");
                                                        isbnLibro.appendChild(document.createTextNode(isbnV));
                                                        Element cantidadLibro = document.createElement("cantidad");
                                                        cantidadLibro.appendChild(document.createTextNode(String.valueOf(cantidadV)));
                                                        Element precioLibro = document.createElement("precio");
                                                        precioLibro.appendChild(document.createTextNode(String.valueOf(precioV)));

                                                        libro.appendChild(tituloLibro);
                                                        libro.appendChild(autorLibro);
                                                        libro.appendChild(isbnLibro);
                                                        libro.appendChild(cantidadLibro);
                                                        libro.appendChild(precioLibro);

                                                        document.getElementsByTagName("libros").item(0).appendChild(libro);

                                                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                                        Transformer transformer = transformerFactory.newTransformer();
                                                        DOMSource source = new DOMSource(document);
                                                        StreamResult result = new StreamResult(new File("src/Biblioteca/libros.xml"));
                                                        transformer.transform(source, result);
                                                        System.out.println("Libro añadido");
                                                        break;


                                                    } catch (TransformerConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (ParserConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (TransformerException e) {
                                                        e.printStackTrace();
                                                    } catch (SAXException e) {
                                                        e.printStackTrace();
                                                    }

                                                    break;
                                                case 7:
                                                    // Mostrar los libros que estan en prestamo del archivo prestamos.txt
                                                    try {
                                                        File archivo = new File("src/Biblioteca/prestamos");
                                                        FileReader fr2 = new FileReader(archivo);
                                                        BufferedReader br2 = new BufferedReader(fr2);
                                                        String linea2;

                                                        System.out.println("Libros en prestamo\n");

                                                        while ((linea2 = br2.readLine()) != null) {
                                                            // Separar los datos del archivo por un espacio
                                                            String[] datos = linea2.split(" ");
                                                            System.out.println("ISBN: " + datos[0] + " " + "Nombre: " + datos[1]);
                                                        }

                                                        br2.close();
                                                        fr2.close();

                                                        System.out.println("Pulse enter para continuar");
                                                        sc.nextLine();
                                                        break;
                                                    }catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }
                                        } while (opcion2 != 8);
                                        break;
                                    case 2:
                                        int opcion3;
                                        do {
                                            System.out.println("1. Añadir un vinilo");
                                            System.out.println("2. Modificar un vinilo");
                                            System.out.println("3. Consultar un vinilo");
                                            System.out.println("4. Eliminar un vinilo");
                                            System.out.println("5. Vinilos que estarán disponibles proximamente");
                                            System.out.println("6. Añadir vinilos que estará disponible proximamente");
                                            System.out.println("7. Salir");
                                            opcion3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion3) {
                                                case 1:
                                                    //TODO: CLASE GENERICA EN ACCIÓN
                                                    Vinilocomentario.setComentario("Introduce el nombre del vinilo: ");
                                                    System.out.println(Vinilocomentario.getComentario());
                                                    String nombre3 = sc.nextLine();
                                                    System.out.println("Introduce numero de canciones del vinilo: ");
                                                    int numero3 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce el id del vinilo: ");
                                                    int id3 = sc.nextInt();
                                                    sc.nextLine();
                                                    System.out.println("Introduce la fecha de lanzamiento del vinilo: ");
                                                    String fecha3 = sc.nextLine();

                                                    Vinilos vinilo = new Vinilos(nombre3, numero3, id3, fecha3);
                                                    vinilos.add(vinilo);
                                                    break;
                                                case 2:
                                                    System.out.println("Introduce el id del vinilo que quieres modificar: ");
                                                    int id4 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Vinilos vinilo2 : vinilos) {
                                                        if (vinilo2.getId() == id4) {
                                                            System.out.println("Introduce el nuevo nombre del vinilo: ");
                                                            String nombre4 = sc.nextLine();
                                                            System.out.println("Introduce el nuevo numero de canciones del vinilo: ");
                                                            int numero4 = sc.nextInt();
                                                            sc.nextLine();
                                                            System.out.println("Introduce la nueva fecha de lanzamiento del vinilo: ");
                                                            String fecha4 = sc.nextLine();
                                                            vinilo2.setNombre(nombre4);
                                                            vinilo2.setCanciones(numero4);
                                                            vinilo2.setFechaLanzamiento(fecha4);

                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Introduce el id del vinilo que quieres consultar: ");
                                                    int id5 = sc.nextInt();
                                                    sc.nextLine();
                                                    for (Vinilos vinilo3 : vinilos) {
                                                        if (vinilo3.getId() == id5) {
                                                            System.out.println("Nombre del vinilo: " + vinilo3.getNombre());
                                                            System.out.println("Numero de canciones del vinilo: " + vinilo3.getCanciones());
                                                            System.out.println("Fecha de lanzamiento del vinilo: " + vinilo3.getFechaLanzamiento());
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Introduce el id del vinilo que quieres eliminar: ");
                                                    int id6 = sc.nextInt();
                                                    sc.nextLine();
                                                    vinilos.removeIf(vinilo5 -> vinilo5.getId() == id6);
                                                    break;
                                                case 5:
                                                    //Leer fichero xml

                                                    try {

                                                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        DocumentBuilder builder = factory.newDocumentBuilder();
                                                        Document document = builder.parse(new File("src/Biblioteca/vinilo.xml"));
                                                        document.getDocumentElement().normalize();

                                                        // Mostrar los libros

                                                        NodeList nList = document.getElementsByTagName("vinilo");
                                                        for (int temp = 0; temp < nList.getLength(); temp++) {

                                                            Node nNode = nList.item(temp);

                                                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                                                Element eElement = (Element) nNode;

                                                                System.out.println("\n Vinilo " + (temp + 1) + " : \n");
                                                                System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                                                                System.out.println("Canciones: " + eElement.getElementsByTagName("canciones").item(0).getTextContent());
                                                                System.out.println("ID: " + eElement.getElementsByTagName("id").item(0).getTextContent());
                                                                System.out.println("Fecha Lanzamiento: " + eElement.getElementsByTagName("fechaLanzamiento").item(0).getTextContent());
                                                            }
                                                        }

                                                    } catch (Excepcion e) {
                                                        e.printStackTrace();
                                                    } catch (ParserConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    } catch (SAXException e) {
                                                        e.printStackTrace();
                                                    }


                                                    break;

                                                case 6:
                                                    try {

                                                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        DocumentBuilder builder = factory.newDocumentBuilder();
                                                        Document document = builder.parse(new File("src/Biblioteca/vinilo.xml"));
                                                        document.getDocumentElement().normalize();

                                                        // Añadir libro

                                                        System.out.println("\nAñadir viniloo\n");
                                                        System.out.println("Nombre: ");
                                                        String nombre = sc.nextLine();
                                                        System.out.println("Canciones: ");
                                                        String canciones = sc.nextLine();
                                                        System.out.println("ID: ");
                                                        int id = sc.nextInt();
                                                        System.out.println("Fecha Lanzamiento: ");
                                                        String fecha = sc.nextLine();

                                                        Element vinilo2 = document.createElement("vinilo");
                                                        Element nombrevinilo = document.createElement("nombre");
                                                        nombrevinilo.appendChild(document.createTextNode(nombre));
                                                        Element cancionesVinilo = document.createElement("canciones");
                                                        cancionesVinilo.appendChild(document.createTextNode(canciones));
                                                        Element idVinilo = document.createElement("id");
                                                        idVinilo.appendChild(document.createTextNode(String.valueOf(id)));
                                                        Element fechaVinilo = document.createElement("fecha");
                                                        fechaVinilo.appendChild(document.createTextNode(fecha));

                                                        vinilo2.appendChild(nombrevinilo);
                                                        vinilo2.appendChild(cancionesVinilo);
                                                        vinilo2.appendChild(idVinilo);
                                                        vinilo2.appendChild(fechaVinilo);

                                                        document.getElementsByTagName("vinilos").item(0).appendChild(vinilo2);

                                                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                                        Transformer transformer = transformerFactory.newTransformer();
                                                        DOMSource source = new DOMSource(document);
                                                        StreamResult result = new StreamResult(new File("src/Biblioteca/vinilo.xml"));
                                                        transformer.transform(source, result);
                                                        System.out.println("Vinilo añadido");
                                                        break;


                                                    } catch (TransformerConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (ParserConfigurationException e) {
                                                        e.printStackTrace();
                                                    } catch (TransformerException e) {
                                                        e.printStackTrace();
                                                    } catch (SAXException e) {
                                                        e.printStackTrace();
                                                    }

                                                    break;
                                                case 7:
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }
                                        } while (opcion3 != 7);
                                        break;
                                    case 3:
                                        int opcion4;
                                        do {
                                            System.out.println("Indica que tipo de cliente quieres gestionar: ");
                                            System.out.println("1. Cliente Privado");
                                            System.out.println("2. Cliente escuela música");
                                            System.out.println("3. Salir");
                                            opcion4 = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcion4) {
                                                case 1:
                                                    int opcion5 = 0;
                                                    do {
                                                        System.out.println("1. Añadir un nuevo cliente");
                                                        System.out.println("2. Modificar un cliente");
                                                        System.out.println("3. Eliminar un cliente");
                                                        System.out.println("4. Consultar un cliente");
                                                        System.out.println("5. Salir");
                                                        opcion5 = sc.nextInt();
                                                        sc.nextLine();

                                                        switch (opcion5) {
                                                            case 1:
                                                                System.out.println("Introduce el nombre del cliente: ");
                                                                String nombre5 = sc.nextLine();
                                                                System.out.println("Introduce los apellidos del cliente: ");
                                                                String apellidos5 = sc.nextLine();
                                                                System.out.println("Introduce el DNI del cliente: ");
                                                                String dni5 = sc.nextLine();
                                                                System.out.println("Introduce el email del cliente: ");
                                                                String email5 = sc.nextLine();
                                                                System.out.println("Introduce el codigo postal del cliente: ");
                                                                String codigoPostal5 = sc.nextLine();

                                                                ClientePrivado clientePrivado444 = new ClientePrivado(nombre5, apellidos5, dni5, email5, codigoPostal5);
                                                                clientesPrivados.put(clientePrivado444.getDni(), clientePrivado444);
                                                                break;
                                                            case 2:
                                                                System.out.println("Introduce el DNI del cliente que quieres modificar: ");
                                                                String dni6 = sc.nextLine();
                                                                for (Map.Entry<String, ClientePrivado> clientePrivado412 : clientesPrivados.entrySet()) {
                                                                    if (clientePrivado412.getKey().equals(dni6)) {
                                                                        System.out.println("Introduce el nombre del cliente: ");
                                                                        String nombre6 = sc.nextLine();
                                                                        System.out.println("Introduce los apellidos del cliente: ");
                                                                        String apellidos6 = sc.nextLine();
                                                                        System.out.println("Introduce el email del cliente: ");
                                                                        String email6 = sc.nextLine();
                                                                        System.out.println("Introduce el codigo postal del cliente: ");
                                                                        int codigoPostal6 = sc.nextInt();

                                                                        // Instanciamos un nuevo cliente con los datos introducidos
                                                                        ClientePrivado clientePrivado4 = new ClientePrivado();

                                                                        clientePrivado4.setNombre(nombre6);
                                                                        clientePrivado4.setApellidos(apellidos6);
                                                                        clientePrivado4.setEmail(email6);
                                                                        clientePrivado4.setCodigoPostal(codigoPostal6);

                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.println("Introduce el DNI del cliente que quieres eliminar: ");
                                                                String dni7 = sc.nextLine();
                                                                // Eliminar cliente
                                                                clientesPrivados.entrySet().removeIf(clientePrivado -> clientePrivado.getKey().equals(dni7));
                                                                System.out.println("El cliente ha sido eliminado");

                                                                break;
                                                            case 4:
                                                                System.out.println("Introduce el DNI del cliente que quieres buscar: ");
                                                                String dni8 = sc.nextLine();
                                                                for (Map.Entry<String, ClientePrivado> entry : clientesPrivados.entrySet()) {
                                                                    // TODO: EXCEPCION PREDEFINIDA
                                                                    try {
                                                                        if (entry.getKey().equals(dni8)) {
                                                                            // Mostramos los datos del cliente
                                                                            System.out.println("Nombre: " + entry.getValue().getNombre());
                                                                            System.out.println("Apellidos: " + entry.getValue().getApellidos());
                                                                            System.out.println("Email: " + entry.getValue().getEmail());
                                                                            System.out.println("Codigo Postal: " + entry.getValue().getCodigoPostal());
                                                                            System.out.println("DNI: " + entry.getKey());
                                                                        }
                                                                    } catch (Exception e) {
                                                                        System.out.println("El cliente no existe");
                                                                    }

                                                                }
                                                                break;
                                                            case 5:
                                                                break;
                                                            default:
                                                                System.out.println("Opcion incorrecta");
                                                                break;
                                                        }
                                                    } while (opcion5 != 5);
                                                    break;
                                                case 2:
                                                    int opcion6;
                                                    do {
                                                        System.out.println("1. Añadir cliente");
                                                        System.out.println("2. Eliminar cliente");
                                                        System.out.println("3. Buscar cliente");
                                                        System.out.println("4. Modificar cliente");
                                                        System.out.println("5. Salir");
                                                        opcion6 = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (opcion6) {
                                                            case 1:

                                                                System.out.println("Introduce el nombre del cliente que quieres añadir: ");
                                                                String nombre9 = sc.nextLine();
                                                                System.out.println("Introduce los apellidos del cliente  que quieres añadir: ");
                                                                String apellidos9 = sc.nextLine();
                                                                System.out.println("Introduce el DNI del cliente que quieres añadir: ");
                                                                String dni9 = sc.nextLine();
                                                                System.out.println("Introduce el email del cliente que quieres añadir: ");
                                                                String email9 = sc.nextLine();
                                                                System.out.println("Introduce el nombre de la escuela del cliente que quieres añadir: ");
                                                                String escuela9 = sc.nextLine();

                                                                ClienteEscolaMusica clienteEscolaMusica = new ClienteEscolaMusica(dni9, nombre9, apellidos9, email9, escuela9);
                                                                clienteEscuelaM.put(clienteEscolaMusica.getDni(), clienteEscolaMusica);
                                                                break;
                                                            case 2:
                                                                System.out.println("Introduce el DNI del cliente que quieres eliminar: ");
                                                                String dni10 = sc.nextLine();
                                                                clienteEscuelaM.entrySet().removeIf(entry -> entry.getKey().equals(dni10));

                                                                break;
                                                            case 3:
                                                                System.out.println("Introduce el DNI del cliente que quieres buscar: ");
                                                                String dni11 = sc.nextLine();
                                                                for (Map.Entry<String, ClienteEscolaMusica> entry : clienteEscuelaM.entrySet()) {
                                                                    if (entry.getKey().equals(dni11)) {
                                                                        System.out.println("Nombre: " + entry.getValue().getNombre());
                                                                        System.out.println("Apellidos: " + entry.getValue().getApellidos());
                                                                        System.out.println("DNI: " + entry.getValue().getDni());
                                                                        System.out.println("Email: " + entry.getValue().getEmail());

                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("Introduce el DNI del cliente que quieres modificar: ");
                                                                String dni12 = sc.nextLine();
                                                                for (Map.Entry<String, ClienteEscolaMusica> clienteEscuelaMusica : clienteEscuelaM.entrySet()) {
                                                                    if (clienteEscuelaMusica.getKey().equals(dni12)) {
                                                                        System.out.println("Introduce el nuevo DNI del cliente que quieres modificar: ");
                                                                        String dni13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo nombre del cliente que quieres modificar: ");
                                                                        String nombre13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo apellidos del cliente que quieres modificar: ");
                                                                        String apellidos13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo email del cliente que quieres modificar: ");
                                                                        String email13 = sc.nextLine();
                                                                        System.out.println("Introduce el nuevo nombre de la escuela del cliente que quieres modificar: ");
                                                                        String escuela13 = sc.nextLine();

                                                                        ClienteEscolaMusica clienteEscolaMusica1 = new ClienteEscolaMusica();
                                                                        clienteEscolaMusica1.setDni(dni13);
                                                                        clienteEscolaMusica1.setNombre(nombre13);
                                                                        clienteEscolaMusica1.setApellidos(apellidos13);
                                                                        clienteEscolaMusica1.setEmail(email13);

                                                                    }
                                                                }
                                                                break;
                                                            case 5:
                                                                break;
                                                            default:
                                                                System.out.println("Introduce una opción correcta");
                                                                break;
                                                        }
                                                        break;
                                                    } while (opcion6 != 5);
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("Introduce una opción correcta");
                                                    break;
                                            }
                                        } while (opcion4 != 3);
                                        break;
                                    case 4:
                                        int opcion8;
                                        do {
                                            System.out.println("Indica que quieres hacer: ");
                                            System.out.println("1. Añadir un nuevo trabajador");
                                            System.out.println("2. Eliminar un trabajador");
                                            System.out.println("3. Modificar un trabajador");
                                            System.out.println("4. Consultar un trabajador");
                                            System.out.println("5. Salir");
                                            opcion8 = sc.nextInt();
                                            sc.nextLine();

                                            switch (opcion8) {
                                                case 1:
                                                    System.out.println("Introduce el nombre del trabajador: ");
                                                    String nombre0 = sc.nextLine();
                                                    System.out.println("Introduce los apellidos del trabajador: ");
                                                    String apellidos0 = sc.nextLine();
                                                    System.out.println("Introduce el DNI del trabajor: ");
                                                    String dni0 = sc.nextLine();
                                                    System.out.println("Introduce el email del trabajor: ");
                                                    String email0 = sc.nextLine();

                                                    Trabajador trabajadorNuevo = new Trabajador(nombre0, apellidos0, dni0, email0);
                                                    trabajadores.add(trabajadorNuevo);
                                                    break;
                                                case 2:
                                                    System.out.println("Introduce el DNI del trabajador que quieres eliminar: ");
                                                    String dni8 = sc.nextLine();
                                                    for (Trabajador trabajadorEliminar : trabajadores) {
                                                        if (trabajadorEliminar.getDni().equals(dni8)) {
                                                            trabajadores.removeIf(trabajadorEliminar1 -> trabajadorEliminar1.getDni() == dni8);

                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Introduce el DNI del trabajador que quieres modificar: ");
                                                    String dni9 = sc.nextLine();
                                                    for (Trabajador trabajadorModificar : trabajadores) {
                                                        if (trabajadorModificar.getDni().equals(dni9)) {
                                                            System.out.println("Introduce el nuevo nombre del trabajador: ");
                                                            String nombreM = sc.nextLine();
                                                            System.out.println("Introduce los nuevos apellidos del trabajador: ");
                                                            String apellidosM = sc.nextLine();
                                                            System.out.println("Introduce el nuevo email del trabajador: ");
                                                            String emailM = sc.nextLine();

                                                            trabajadorModificar.setNombre(nombreM);
                                                            trabajadorModificar.setApellido(apellidosM);
                                                            trabajadorModificar.setEmail(emailM);
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Introduce el DNI del trabajador que quieres buscar: ");
                                                    String dniG = sc.nextLine();
                                                    for (Trabajador trabajadorG : trabajadores) {
                                                        if (trabajadorG.getDni().equals(dniG)) {
                                                            System.out.println("Nombre: " + trabajadorG.getNombre());
                                                            System.out.println("Apellidos: " + trabajadorG.getApellido());
                                                            System.out.println("Email: " + trabajadorG.getEmail());
                                                            System.out.println("Dni: " + trabajadorG.getDni());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }

                                        } while (opcion8 != 5);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Introduce una opción correcta");
                                        break;
                                }
                                break;
                            } while (opcion != 5);
                        }
                    } while (oportunidades != 0 && opcion != 5);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Introduce una opción correcta");
                    break;
            }

        } while (opcion != 4);
    }


}
