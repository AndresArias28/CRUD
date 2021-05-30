
package Config;

import com.mysql.jdbc.Connection;
import java.sql.*;

public class Coneccion {
   Connection con;
    public Coneccion(){
          try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pais","root","");
            
       
        }catch(Exception e){
            if(e!=null){
                System.out.println("Conexión realizada a la base de datos con éxito.");
            }else{
                System.out.println("error de tipo: "+e);
            }
              
             
        }
          
    }
    public Connection getConnection(){
        return con;
    }
    
    
  
    
}
