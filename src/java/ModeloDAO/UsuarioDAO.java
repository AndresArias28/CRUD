package ModeloDAO;

import Config.Coneccion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Coneccion objConeccion = new Coneccion();
    Connection conection;
    PreparedStatement pst;
    ResultSet resultSet;

    /*  public List listar() {
        ArrayList<Usuario> listUser = new ArrayList<>();//vector dinamico con la lista de objetos de usuarios
        String sql = "Select * from usuarios";

        try {
            conection = objConeccion.getConnection();//obtengo el objeto conexion de la clase Coneccion  y la paso a un objeto de tipo Conection
            pst = conection.prepareStatement(sql);//mediante el objeto coneccion
            resultSet = pst.executeQuery();//objeto rs se asigna la ejecucion de la peticion sql
            while (resultSet.next()) {//mientras la peticion siga ejecuntandose, es decir que encuentre el siguiente objeto en la BD
                Usuario objUsuario = new Usuario();
                objUsuario.setId(resultSet.getInt("ID"));//fijo el ID de la BD al modelo 
                objUsuario.setCorreo(resultSet.getString("Correo"));
                objUsuario.setNombre(resultSet.getString("Nombre"));
                objUsuario.setPasword(resultSet.getString("contrasena"));//paso la contraseña de la BD al modelo(pasword)
                listUser.add(objUsuario);
            }

        } catch (Exception e) {
            System.out.println("exepcionm de tipo" + e);
        }
        return listUser;
    }*/
    public boolean autenticar(String user, String pass) throws SQLException {
        String sql = "Select * from usuarios";
        conection = objConeccion.getConnection();//obtengo el objeto conexion de la clase Coneccion  y la paso a un objeto de tipo Conection
        pst = conection.prepareStatement(sql);//mediante el objeto coneccion
        resultSet = pst.executeQuery();//objeto rs se asigna la ejecucion de la peticion sql
        while (resultSet.next()) {
            if (user.equals(resultSet.getString("Correo")) && pass.equals(resultSet.getString("contrasena"))) {
                return true;
            }
        }
        return false;
    }

}
