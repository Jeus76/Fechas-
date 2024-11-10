package dominio;
import java.io.Serializable;
import java.util.ArrayList;
public class Municipio implements Serializable{
    private String nombre;
    private ArrayList<Localidad> localidades;

    public Municipio(String nombre_) {
        nombre=nombre_;
        localidades=new ArrayList<Localidad>();
    }
    public Municipio add(Localidad localidad){
        localidades.add(localidad);
        return this;
    }
    public int getPoblacion(){
        int poblacion=0;
        for(Localidad localidad:localidades){
            poblacion+=localidad.getPoblacion();
        }
        return poblacion;
    }
    public int getLocalidades(){
        return localidades.size();
    }
    public Localidad getLocalidad(int i){
        return localidades.get(i);
    }
    public String toString(){
        return "Municipio: "+nombre+" Población: "+getPoblacion() +" habitantes\n"+localidades.toString()+"\n";
    }

    public String getNombre() {
        return nombre;
    }

}