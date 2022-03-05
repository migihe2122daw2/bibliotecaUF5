package Biblioteca;

import java.util.InputMismatchException;

public class Excepcion extends InputMismatchException{
    public Excepcion(String message) {

    }

    @Override
    public String getMessage() {
        String mensaje = "Has introducido una letra en lugar de un numero";
        return mensaje;
    }
}
