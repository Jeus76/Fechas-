package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Provincia implements Serializable{
    private String nombre;
    private ArrayList<Municipio> municipios;
    public Provincia(String nombre_) {
        nombre=nombre_;
        municipios=new ArrayList<Municipio>();
    }
    public Provincia add(Municipio municipio){
        municipios.add(municipio);
        return this;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPoblacion(){
        int poblacion=0;
        for(Municipio municipio:municipios){
            poblacion+=municipio.getPoblacion();
        }
        return poblacion;
    }
    public ArrayList<Municipio> getMunicipios(){
        return municipios;
    }
    public Municipio getMunicipio(int i){
        return municipios.get(i);
    }
    public String toString(){
        return "Provincia: "+nombre+" Población: "+getPoblacion() +" habitantes\n"+municipios.toString()+"\n";
    }
    public int size(){
        return municipios.size();
    }

}