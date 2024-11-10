package dominio;

import java.io.*;
import java.util.ArrayList;
public class Libreta implements Serializable {
    private String nombre;
    private ArrayList<Contacto> lista;
    private String apellido;
    private String telefono;
    private String email;

    public Libreta() {
        nombre = "";
        lista = new ArrayList<>();
        apellido = "";
        telefono = "";
        email = "";
    }


    public Libreta add(Contacto nuevoContacto) {
        lista.add(nuevoContacto);
        return this;
    }

    public Contacto buscar(Contacto c) {
        int p = lista.indexOf(c);
        if (p == -1)
            return null;
        else
            return lista.get(p);
    }

    public boolean modificar(Contacto c) {
        Contacto encontrado = buscar(c);
        if (encontrado != null) {
            encontrado.setNombre(c.getNombre());
            encontrado.setApellido(c.getApellido());
            encontrado.setTelefono(c.getTelefono());
            encontrado.setEmail(c.getEmail());
            guardar();
            return true;
        }
        return false;
    }

    public void borrarContacto(Contacto c) {
        lista.remove(c);
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
            System.out.println("Error al guardar el libreta.");
        }
    }


    public void modificar(String nombre, String atributo, String nuevoValor) {
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
