
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {
    
    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    Persona per = new Persona();
    PersonaDAO perDao = new PersonaDAO();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
            
        }else if(action.equalsIgnoreCase("Agregar")){
            String dni = request.getParameter("dniHumano");
            String nombre = request.getParameter("nombrehumano");
            per.setDni(dni);
            per.setNombre(nombre);
            perDao.add(per);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){                           //si doy click en editar, 
            
            request.setAttribute("IDpersona", request.getParameter("id"));//enviar el id de la persona para poder capturarlo en la vista
            acceso=edit;
            
            
        }else if(action.equalsIgnoreCase("actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("dniHumano");
            String nombre = request.getParameter("nombrehumano");
            per.setId(id);
            per.setDni(dni);
            per.setNombre(nombre);
            perDao.edit(per);
            acceso = listar;
            
        }else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            per.setId(id);
            perDao.eliminar(id);
            acceso=listar;
        }
       // request.setAttribute("ObjetoEnviar", objPersona);
         RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
