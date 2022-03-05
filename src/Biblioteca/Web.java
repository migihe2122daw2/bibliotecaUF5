package Biblioteca;

public class Web {
    //atributos
    private String nombreWeb;
    private String nombreEmpresa;
    public String domicilio;
    public String telefono;
        
    //constructor
    public Web() {
        this.nombreWeb = nombreWeb;
        this.nombreEmpresa = nombreEmpresa;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    //getters y setters


    public String getNombreWeb() {
        return nombreWeb;
    }

    public void setNombreWeb(String nombreWeb) {
        this.nombreWeb = nombreWeb;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
