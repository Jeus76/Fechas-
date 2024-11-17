package dominio;

import java.io.Serializable;
import java.io.*;

public class Contacto implements Serializable {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String atributo;
    private String nuevoValor;

    public Contacto() {
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.email = "";
    }

    public Contacto(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto(String nombre, String atributo, String nuevoValor) {
        this.nombre = nombre;
        this.apellido = "";
        this.telefono = "";
        this.email = "";
        this.atributo = atributo;
        this.nuevoValor = nuevoValor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getAtributo() {
        return atributo;
    }

    public String getNuevoAtributo() {
        return nuevoValor;
    }

    public Contacto setAtributo(String atributo) {
        this.atributo = atributo;
        return this;
    }

    public Contacto setNuevoValor(String nuevoValor) {
        this.nuevoValor = nuevoValor;
        return this;
    }

    public Contacto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Contacto setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Contacto setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Contacto setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean equals(Object o){
        if (o==null)
            return false;
        if (this.getClass()!=o.getClass())
            return false;
        Contacto c= (Contacto) o;
        return nombre.equals(c.nombre)&& apellido.equals(c.apellido);
    }
    public int hashCode(){
        return (nombre.hashCode()-1)*33 + apellido.hashCode();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ")
                .append(nombre)
                .append(" ")
                .append(apellido)
                .append("\n telefono:")
                .append(telefono)
                .append("\n email:")
                .append(email);
        return sb.toString();
    }
}