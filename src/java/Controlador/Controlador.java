package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    String listaGeneral = "vistas/listaIndex.jsp";
    String index = "index.jsp";
    Persona per = new Persona();
    PersonaDAO perDao = new PersonaDAO();
    UsuarioDAO userDAO = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso = "";
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        boolean respuesta = userDAO.autenticar(user, pass);
        if (respuesta == true) {
            acceso = listaGeneral;
        }else{
           
            //JOptionPane.showMessageDialog(null, "Usuario o contraseña in correctos, intenta de nuevo");
            request.setAttribute("ObjetoEnviar", respuesta);
            acceso=index;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;

        } else if (action.equalsIgnoreCase("Agregar")) {
            String dni = request.getParameter("dniHumano");
            String nombre = request.getParameter("nombrehumano");
            per.setDni(dni);
            per.setNombre(nombre);
            perDao.add(per);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {                           //si doy click en editar, 

            request.setAttribute("IDpersona", request.getParameter("id"));//enviar el id de la persona para poder capturarlo en la vista
            acceso = edit;

        } else if (action.equalsIgnoreCase("actualizar")) {
            int id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("dniHumano");
            String nombre = request.getParameter("nombrehumano");
            per.setId(id);
            per.setDni(dni);
            per.setNombre(nombre);
            perDao.edit(per);
            acceso = listar;

        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            per.setId(id);
            perDao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
