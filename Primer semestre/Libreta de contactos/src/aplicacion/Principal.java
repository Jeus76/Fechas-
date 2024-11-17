package aplicacion;

import dominio.NoEncontrado;
import interfaz.Interfaz;
import dominio.Libreta;

public class Principal {
    public static void main(String[] args) throws NoEncontrado.cNoEncontradoException {
        Libreta libreta = Libreta.leer();
        Interfaz interfaz = new Interfaz(libreta);
        interfaz.InterfazUsuario();
        libreta.guardar();

    }
}
