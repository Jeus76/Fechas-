package dominio;
import java.util.ArrayList;
import java.io.*;

public class Catalogo implements Serializable {
    private ArrayList<Zapatillas> listaZapatillas;
    private static final String FILE_NAME = "catalogo.dat";

    public Catalogo() {
        leer();
    }

    public void addZapatilla(Zapatillas zapatilla) {
        listaZapatillas.add(zapatilla);
        escribir();
    }

    public boolean eliminarZapatilla(int id) {
        Zapatillas zapatillaEliminar = buscarZapatillaPorId(id);
        if (zapatillaEliminar != null) {
            listaZapatillas.remove(zapatillaEliminar);
            escribir();
            return true;
        }
        return false;
    }

    public boolean modificarZapatilla(int id, Zapatillas nuevaZapatilla) {
        Zapatillas zapatillaExistente = buscarZapatillaPorId(id);
        if (zapatillaExistente != null) {
            zapatillaExistente.setMarca(nuevaZapatilla.getMarca());
            zapatillaExistente.setModelo(nuevaZapatilla.getModelo());
            zapatillaExistente.setColor(nuevaZapatilla.getColor());
            zapatillaExistente.setTalla(nuevaZapatilla.getTalla());
            zapatillaExistente.setPrecio(nuevaZapatilla.getPrecio());
            escribir(); // Guardar después de modificar
            return true;
        }
        return false;
    }

    public Zapatillas buscarZapatillaPorId(int id) {
        for (Zapatillas zapatilla : listaZapatillas) {
            if (zapatilla.getId() == id) {
                return zapatilla;
            }
        }
        return null;
    }

    public void listarZapatillas() {

        System.out.printf("%-4s | %-20s | %-30s | %-10s | %-6s | $%-8s | \n",
                "ID", "Marca", "Modelo", "Color", "Talla", "Precio");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Zapatillas zapatillas : listaZapatillas) {
            System.out.printf("%-4d | %-20s | %-30s | %-10s | %-6s | $%-8.2f\n",
                    zapatillas.getId(),
                    zapatillas.getMarca(),
                    zapatillas.getModelo(),
                    zapatillas.getColor(),
                    zapatillas.getTalla(),
                    zapatillas.getPrecio());
        }
    }

        public boolean esIdUnico ( int id){
            return buscarZapatillaPorId(id) == null;
        }
    public void escribir () {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oo.writeObject(listaZapatillas);
        } catch (Exception e) {
            System.out.print("Error al guardar los datos en el fichero: " + e.getMessage());
        }
    }
    public void leer () {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listaZapatillas = (ArrayList<Zapatillas>) oi.readObject();
        } catch (Exception e) {
            listaZapatillas = new ArrayList<>();
        }

    }
    public ArrayList<Zapatillas> getListaZapatillas() {
        return listaZapatillas;
    }
    public boolean existeZapatilla(int id) {
        return buscarZapatillaPorId(id) != null;
    }
}