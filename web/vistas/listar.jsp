
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body><div class= "container mt-5">
            <div>
                <h3>PERSONAS!</h3>
                <a href="Controlador?accion=add">Agregar Nuevo <a/>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="table-primary">ID</th>
                                <th class="table-primary">DNI</th>
                                <th class="table-primary" >Nombres</th>
                                <th class="table-primary" >Acciones</th>
                            </tr>
                        </thead>
                        <%
                            PersonaDAO dao = new PersonaDAO();
                            List<Persona> list = dao.listar(); //llamar el metodo listar() y asiganarlo(la lista de personas) en list
                            Iterator<Persona> iter = list.iterator(); //creo un objeto iterador de tipo persona. sirve para recorrer estructuras
                            Persona per = null;

                            while (iter.hasNext()) { //mientras encuntre un  elemento siguiente en el itereador continue ejecuntadose
                                per = iter.next(); //le paso cada persona siguiente que encuentra en el objeto iterador al objeto persona

                        %>
                        <tbody>
                            <tr>
                                <td><%= per.getId()%></td> 
                                <td><%= per.getDni()%></td>
                                <td><%= per.getNombre()%></td>
                                <td>
                                    <a href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a> <!-- envio al Controlador 2 parametros: ID y accion. -->
                                    <a href="Controlador?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                                </td>
                            </tr>
                        </tbody>
                        <%}%>


                    </table>

            </div>
        </div>
    </body>
</html>
