
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Agregar</title>
    </head>
    <body>
        <div class = "container mt-5">
            <div class = "row justify-content-md-center"> 
                <div class = "col col-lg-5" > 
                    <h1>Agregar Persona</h1>
                    <form action = "Controlador" method= "get">
                        <div class = "form-group" >
                            <label >Escribe tu Nombre</label>
                            <input type="text" class = "form-control"  name="nombrehumano"  placeholder="Nombre">

                        </div>
                        <div class="form-group" >
                            <label >Escribe tu  DNI</label>
                            <input type="text" class="form-control"   name="dniHumano"  placeholder="DNI">

                        </div>

                        <button type="submit" class="btn btn-primary" name="accion" value="agregar">Enviar</button> 
                    </form>
                </div>
               
            </div>
        </div>
    </body>
</html>
