/*
se realiza toda la logica del negocio conectada a la base ded atos
 */
package ModeloDAO;

import Config.Coneccion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//heradamos los metodos de la interfaz CRUD, por ser interfaz se debe implemntar todos los metodos que tiene
public class PersonaDAO implements CRUD{
    Coneccion objConeccion = new Coneccion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Persona p = new Persona();
  
    @Override
    public List listar() {
        ArrayList<Persona>list = new ArrayList<>();//vector dinamico con la lista de objetos de las personas
        String sql = "Select * from persona";
        
        try{
            con = objConeccion.getConnection();//obtengo el objeto conexion de la clase Coneccion  y la paso a un objeto de tipo Conection
            pst = con.prepareStatement(sql);//objeto(pst) le asigno u nmetodo que envia paramatros sql
            rs = pst.executeQuery();//objeto rs se asigna la ejecucion de la peticion sql
            while(rs.next()){//mientras la peticion siga ejecuntandose, es decir que encuentre el siguiente objeto en la BD
                Persona per = new Persona();
                per.setId(rs.getInt("ID"));//fijo el ID de la BD al modelo 
                per.setDni(rs.getString("CedulaPersona"));
                per.setNombre(rs.getString("NombrePersona"));
                list.add(per); 
            }                           
       
           
        }catch(Exception e){
            System.out.println("exepcionm de tipo"+e);
        }
        return list;
    }

    @Override
    public Persona list(int id) {
       String sql = "Select * from persona where ID = "+id;
        
        try{
            con = objConeccion.getConnection();//obtengo el objeto conexion de la clase Coneccion  y la paso a un objeto de tipo Conection
            pst = con.prepareStatement(sql);//objeto(pst) le asigno u nmetodo que envia paramatros sql
            rs = pst.executeQuery();//objeto rs se asigna la ejecucion de la peticion sql
            while(rs.next()){//mientras la peticion siga ejecuntandose, es decir que encuentre el siguiente objeto en la BD
                //Persona per = new Persona();
                p.setId(rs.getInt("ID"));//fijo el ID de la BD al modelo 
                p.setDni(rs.getString("CedulaPersona"));
                p.setNombre(rs.getString("NombrePersona"));
                //list.add(per); 
            }                           
       
           
        }catch(Exception e){
            System.out.println("exepcion de tipo"+e);
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into persona(CedulaPersona,NombrePersona)values('"+per.getDni()+"','"+per.getNombre()+"')";
       try{
           con = objConeccion.getConnection();
           pst = con.prepareStatement(sql);
           pst.executeUpdate();
           
       }catch(Exception e){
           System.out.println(" excepcion de tipo: "+e);
       }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
      String sql="UPDATE persona SET CedulaPersona='"+per.getDni()+"', NombrePersona='"+per.getNombre()+"' WHERE ID = "+per.getId();
        try {
            con = objConeccion.getConnection();
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("execpion de tipo:" +e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from persona where ID = "+id;
        try {
            con = objConeccion.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("error de tipo: "+e);
        }
        return false;
    }
    
}
