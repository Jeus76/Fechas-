package aplicacion;

import interfaz.Interfaz;
import dominio.Libreta;

public class Principal {
    public static void main(String[] args) {
        Libreta libreta = new Libreta();
        Interfaz interfaz = new Interfaz(libreta);
        interfaz.InterfazUsuario();
    }
}