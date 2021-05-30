<%-- 
    Document   : newjsp
    Created on : 24/05/2021, 12:38:31 PM
    Author     : Usuario
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class = "container mt-5">
             <%
                 PersonaDAO dao = new PersonaDAO();
                 int id = Integer.parseInt((String)request.getAttribute("IDpersona"));
                 Persona p = (Persona)dao.list(id);
                 %>
              <div class = "row"> 
                <div class = "col-sm" > 
                    <h1>Modificar Persona</h1>
                    <form action = "Controlador" method= "get">
                        <div class = "form-group" >
                            <label >Nombre</label>
                            <input type="text" class = "form-control"  name="nombrehumano" value="<%= p.getNombre()%>" placeholder="Nombre">
                             
                        </div>
                        <div class="form-group" >
                            <label >DNI</label>
                            <input type="text" class="form-control"   name="dniHumano"  value ="<%= p.getDni()%>"placeholder="DNI">
                           
                        </div>
                        <div class="form-group" >
                           
                            <input type="hidden" class="form-control"   name="txtid"  value="<%= p.getId()%>" placeholder="DNI">
                           
                        </div>
                       
                          <button type="submit" class="btn btn-primary" name="accion" value="actualizar">Actualizar</button> 
                          <a href="Controlador?accion=listar">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
