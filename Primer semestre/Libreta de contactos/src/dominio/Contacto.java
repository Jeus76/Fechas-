package dominio;

public class Contacto{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Contacto (String nombre, String apellido, String telefono, String email){
    this.nombre = "";
    this.apellido = "";
    this.telefono = "";
    this.email = "";
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }

    public Contacto setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public Contacto setApellido(String apellido){
        this.apellido = apellido;
        return this;
    }
    public Contacto setTelefono(String telefono_){
        telefono=telefono_;
        return this;
    }
    public Contacto setEmail(String email){
        this.email = email;
        return this;
    }
    public String toString(){
        StringBuilder sb =new StringBuilder();
        sb.append("Nombre: ")
                .append(nombre)
                .append(" ")
                .append(apellido)
                .append("\n telefono:")
                .append(telefono)
                .append("\n email:")
                .append(email);
        return sb.toString();
    }





// la diferencia entre dos objetos iguales y de su mismo estado, cuando tienen mismas caracteristicas (nombre, apellido, etc...) tienen el mismo estado, pero no son el mismo objeto


}

