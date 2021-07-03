
package Modelo;

public class Usuario {
    public String nombre;
    public String correo;
    public String pasword;
    public int id;
    
    public Usuario(){
        
    }

    public Usuario(String nombre, String correo, String pasword, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.pasword = pasword;
        this.id = id;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPasword() {
        return pasword;
    }
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
