package interfaz;

import dominio.Catalogo;
import dominio.Zapatillas;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Catalogo catalogo;
    private final Scanner scanner;

    public Menu(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n1. Anadir Zapatillas");
            System.out.println("2. Modificar Zapatillas");
            System.out.println("3. Eliminar Zapatillas");
            System.out.println("4. Listar Zapatillas");
            System.out.println("5. Salir");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        addZapatillas();
                        break;
                    case 2:
                        modZapatillas();
                        break;
                    case 3:
                        rmZapatillas();
                        break;
                    case 4:
                        lsZapatillas();
                        break;
                    case 5:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Mensaje de entrada no valido, ingrese un numero.");
                scanner.nextLine();
                opcion = -1;
            }

        } while (opcion != 5);
    }

    private void addZapatillas() {
        System.out.println("Ingrese el ID del Zapatilla: ");
        int id = obtenerIdZapatilla();
        if (id <= 0) return;

        if (!catalogo.esIdUnico(id)) {
            System.out.println("️ El ID ya está en uso. Por favor, ingrese otro ID.");
            return;
        }

        System.out.print("Ingrese Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese Color: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese talla (En formato ES): ");
        String talla = scanner.nextLine();
        System.out.print("Ingrese Precio (mayor que 0): ");
        double precio = scanner.nextDouble();

        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return;
        }

        Zapatillas zapatillas = new Zapatillas(id, marca, modelo, color, talla, precio);
        catalogo.addZapatilla(zapatillas);
        System.out.println("Zapatillas agregadas correctamente.");
    }

    private void modZapatillas() {
        if (catalogo.getListaZapatillas().isEmpty()) {
            System.out.println("No hay zapatillas en el catalogo para modificar.");
            return;
        }

        System.out.println("Ingrese el ID del Zapatilla que desea editar: ");
        int id = obtenerIdZapatilla();
        if (id <= 0) return;

        if (!catalogo.existeZapatilla(id)) {
            System.out.println("No se han encontrado las zapatillas con ese ID");
            return;
        }

        System.out.print("Ingrese nueva marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese nuevo modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese nuevo color: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese nueva talla (En formato ES): ");
        String talla = scanner.nextLine();
        System.out.print("Ingrese nuevo precio (mayor que 0): ");
        double precio = scanner.nextDouble();

        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return;
        }

        Zapatillas nuevaZapatilla = new Zapatillas(id, marca, modelo, color, talla, precio);
        boolean modificado = catalogo.modificarZapatilla(id, nuevaZapatilla);
        if (modificado) {
            System.out.println("Zapatilla modificada correctamente.");
        } else {
            System.out.println("No se han encontrado las zapatillas con ese ID.");
        }
    }

    private void rmZapatillas() {
        if (catalogo.getListaZapatillas().isEmpty()) {
            System.out.println("No hay zapatillas en el catalogo que se puedan eliminar.");
            return;
        }

        System.out.println("Ingrese el ID del Zapatilla que desea eliminar: ");
        int id = obtenerIdZapatilla();
        if (id <= 0) return;

        boolean eliminado = catalogo.eliminarZapatilla(id);
        if (eliminado) {
            System.out.println("Zapatilla eliminada correctamente.");
        } else {
            System.out.println("No se han encontrado las zapatillas con ese ID.");
        }
    }

    private void lsZapatillas() {
        if (catalogo.getListaZapatillas().isEmpty()) {
            System.out.println("No hay zapatillas en el catalogo para listar.");
        } else {
            catalogo.listarZapatillas();
        }
    }

    private int obtenerIdZapatilla() {
        int id = 0;
        boolean encontrado = false;
        while (!encontrado) {
            try {
                id = scanner.nextInt();
                scanner.nextLine();

                if (id <= 0) {
                    System.out.println("El id debe ser mayor que 0.");
                } else {
                    encontrado = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                scanner.nextLine();
            }
        }
        return id;
    }
}
