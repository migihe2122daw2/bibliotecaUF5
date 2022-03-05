package Biblioteca;
// todo: herencia multiple
public class LibrosPapel extends Libros implements Biblioteca{

    // Atributos

    public String dataImpresio;
    public int CantidadHojas;

    // Constructor

    public LibrosPapel() {
        this.dataImpresio = dataImpresio;
        this.CantidadHojas = CantidadHojas;
    }

    // Getters y Setters

    public String getDataImpresio() {
        return dataImpresio;
    }

    public void setDataImpresio(String dataImpresio) {
        this.dataImpresio = dataImpresio;
    }

    public int getCantidadHojas() {
        return CantidadHojas;
    }

    public void setCantidadHojas(int CantidadHojas) {
        this.CantidadHojas = CantidadHojas;
    }

    // Metodos


}
