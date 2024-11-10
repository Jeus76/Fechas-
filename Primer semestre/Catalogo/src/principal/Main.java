package principal;

import dominio.Catalogo;
import interfaz.Menu;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Menu menu = new Menu(catalogo);
        menu.mostrarMenu();
    }
}