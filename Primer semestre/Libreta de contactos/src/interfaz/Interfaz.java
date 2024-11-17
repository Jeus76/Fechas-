package interfaz;

import java.util.Scanner;
import dominio.Contacto;
import dominio.Libreta;

public class Interfaz {
    private Libreta libreta;
    private Scanner sc;


    public Interfaz() {
        this.libreta = Libreta.leer();
        this.sc = new Scanner(System.in);
    }


    public Interfaz(Libreta libreta) {
        this.libreta = libreta;
        this.sc = new Scanner(System.in);
    }


    public void InterfazUsuario() {
        while (true) {
            System.out.println("Introduzca una instrucción: ");
            mostrarOpciones();
            String[] instruct = procesarPeticion();


            switch (instruct[0].toLowerCase()) {
                case "ayuda":
                    help();
                    break;
                case "listar":
                    lista();
                    break;
                case "agregar":
                    if (instruct.length == 5) {
                        agregar(instruct[1], instruct[2], instruct[3], instruct[4]);
                    } else {
                        System.out.println("Formato incorrecto para agregar. Use: agregar,<Nombre>,<Apellido>,<Telefono>,<Email>");
                    }
                    break;
                case "eliminar":
                    if (instruct.length == 3) {
                        borrarContacto(instruct[1], instruct[2]);
                    } else {
                        System.out.println("Formato incorrecto para eliminar. Use: eliminar,<Nombre>,<Apellido>");
                    }
                    break;
                case "modificar":
                    if (instruct.length == 4) {
                        modificar(instruct[1], instruct[2], instruct[3]);
                    } else {
                        System.out.println("Formato incorrecto para modificar. Use: modificar,<Nombre>,<Atributo>,<NuevoValor>");
                    }
                    break;
                case "salir":
                    libreta.guardar();
                    System.out.println("Se ha guardado la libreta, saliendo...");
                    return;
                default:
                    System.out.println("Comando no reconocido. Escriba 'ayuda' para ver los comandos disponibles.");
            }
        }
    }


    private String[] procesarPeticion() {
        String instruct = sc.nextLine();
        return instruct.split(",");
    }


    private void lista() {
        System.out.println(libreta.toString());
    }


    private void help() {
        System.out.println("Comandos disponibles:\n" +
                "- ayuda: Muestra este menú de ayuda con detalles de los comandos.\n" +
                "- listar: Muestra todos los contactos de la agenda.\n" +
                "- agregar: Añade un nuevo contacto en el formato:\n\tagregar,<Nombre>,<Apellido>,<Telefono>,<Email>.\n" +
                "- eliminar: Elimina un contacto en el formato:\n\teliminar,<Nombre>,<Apellido>.\n" +
                "- modificar: Modifica un contacto en el formato:\n\tmodificar,<Nombre>,<Atributo>,<NuevoValor>.\n" +
                "  Atributos modificables: nombre, apellido, telefono, email.\n" +
                "- salir: Guarda y cierra la agenda.\n\n" +
                "Cada comando debe ser introducido con el formato adecuado.");
    }


    private void mostrarOpciones() {
        System.out.println("- ayuda: Muestra el menú de ayuda.\n" +
                "- listar: Muestra todos los contactos de la agenda.\n" +
                "- agregar: Añade un contacto.\n" +
                "- eliminar: Elimina un contacto.\n" +
                "- modificar: Modifica un contacto.\n" +
                "- salir: Guarda y cierra la agenda.");
    }


    private void agregar(String nombre, String apellido, String telefono, String email) {
        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono, email);
        libreta.add(nuevoContacto);
        System.out.println("Contacto añadido.");
    }


    private void borrarContacto(String nombre, String apellido) {
        Contacto contacto = new Contacto(nombre, apellido, null, null);
        libreta.borrarContacto(contacto);
        System.out.println("Contacto borrado.");
    }


    private void modificar(String nombre, String atributo, String nuevoValor) {
        if (atributo.equals("nombre") || atributo.equals("apellido") || atributo.equals("telefono") || atributo.equals("email")) {
            libreta.modificar(nombre, atributo, nuevoValor);
            System.out.println("Contacto modificado.");
        } else {
            System.out.println("Atributo no válido.");
        }
    }
}
