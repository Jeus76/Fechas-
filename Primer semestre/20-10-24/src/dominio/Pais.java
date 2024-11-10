package dominio;
import java.io.*;
import java.util.ArrayList;
public class Pais implements Serializable{
    private String nombre;
    private ArrayList<Provincia> provincias=new ArrayList<Provincia>();
    public Pais add(Provincia provincia){
        provincias.add(provincia);
        return this;
    }
    public String getNombre() {
        return nombre;
    }
    public Pais setNombre(String nombre_){
        nombre=nombre_;
        return this;
    }
    public int getPoblacion(){
        int poblacion=0;
        for(Provincia provincia:provincias){
            poblacion+=provincia.getPoblacion();
        }
        return poblacion;
    }
    public ArrayList<Provincia> getProvincias(){
        return provincias;
    }
    public Provincia getProvincia(int i){
        return provincias.get(i);
    }
    public String toString(){
        return "Pais: "+nombre+" Población: "+getPoblacion() +" habitantes\n"+provincias.toString()+"\n";
    }
    public int size(){
        return provincias.size();
    }
    public void grabar(){
        try {
            ObjectOutputStream fo=new ObjectOutputStream (new FileOutputStream("pais.ser"));
            fo.writeObject(this);
            fo.close();
        } catch (Exception e){
            System.out.println("error de escritura");
        }
    }
    public static Pais leer(){
        try {
            ObjectInputStream fi=new ObjectInputStream(new FileInputStream("pais.ser"));
            Pais p= (Pais) fi.readObject();
            fi.close();
            return p;
        } catch (Exception e){
            return new Pais();
        }
    }
}