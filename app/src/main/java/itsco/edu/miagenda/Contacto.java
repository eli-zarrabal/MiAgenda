package itsco.edu.miagenda;

/**
 * Created by 75000 on 05/03/2017.
 */

public class Contacto {


    private String Nombre;
    private String Movil;
    private String Casa;
    private String Email;

    public Contacto(){

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMovil() {
        return Movil;
    }

    public void setMovil(String movil) {
        Movil = movil;
    }

    public String getCasa() {
        return Casa;
    }

    public void setCasa(String casa) {
        Casa = casa;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    @Override
    public String toString() {
        return this.Nombre;
    }
}


