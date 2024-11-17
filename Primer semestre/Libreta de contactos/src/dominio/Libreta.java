package dominio;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import dominio.NoEncontrado;

public class Libreta implements Serializable {
    private String nombre;
    private ArrayList<Contacto> lista;
    private String apellido;
    private String telefono;
    private String email;
    private String atributo;
    private String nuevoValor;


    public Libreta() {
        nombre = "";
        lista = new ArrayList<Contacto>();
        apellido = "";
        telefono = "";
        email = "";
        atributo = "";
        nuevoValor = "";
    }




    public void add(Contacto c) throws NoEncontrado.DuplicadoException {
        if (lista.contains(c)) {
            throw new NoEncontrado.DuplicadoException("El contacto ya existe en la libreta.");
        }
        lista.add(c);
    }


    public Contacto buscar(String nombre) {
        for (Contacto c : lista) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }


    public void borrarContacto(Contacto c)throws NoEncontrado.cNoEncontradoException {
        if (!lista.remove(c)) {
            throw new NoEncontrado.cNoEncontradoException("El contacto no se ha encontrado en la libreta.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libreta de contactos:\n");
        for (Contacto contacto : lista) {
            sb.append(contacto.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Libreta leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactos.dat"))) {
            return (Libreta) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo, se procede a crear una nueva libreta.");
            return new Libreta();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardar() {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("contactos.dat"))) {
            oo.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar la libreta.");
        }
    }


    public boolean modificar(Contacto c) throws NoEncontrado.cNoEncontradoException {
        Contacto encontrado = buscar(c.getNombre());
        if (encontrado != null) {
            encontrado.setNombre(c.getNombre());
            encontrado.setApellido(c.getApellido());
            encontrado.setTelefono(c.getTelefono());
            encontrado.setEmail(c.getEmail());
            guardar();
            return true;
        } else {
            throw new NoEncontrado.cNoEncontradoException("El contacto no se ha encontrado en la libreta.");
        }

    }


    public void exportarCSV(String nombreArchivo) throws IOException {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write("Nombre, Apellido, Telefono,Email\n");
            for (Contacto contacto : lista) {
                escritor.write(contacto.toString() + "\n");
            }
        }

    }

}