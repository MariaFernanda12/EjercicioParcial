

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Listar</title>                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Imagenes/royal.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>
    <body>
        <header>            
            <div class="col-sm-12">
                <div style="text-align: center"><p style="font-size: 48px">Hotel King Royal</p></div>
            </div>
        </header>
        <div id="contentTable">
            <table border="2">
                <tr>
                    <th></th>                                               
                    <th style="width:400px">Número de Habitación</th>                    
                    <th style="width:400px">Precio</th>                                    
                    <th style="width:400px">Capacidad en Personas</th> 
                    <th style="width:400px">Estado</th>


                </tr>
                <%  if (request.getAttribute("habitaciones") != null) {
                        ArrayList<Habitacion> hab = (ArrayList<Habitacion>) request.getAttribute("habitaciones");
                        for (Habitacion habi : hab) {
                %>            
                <tr>    
                    <td> <%=habi.getId()%> </td>
                    <td> <%=habi.getPrecio()%></td>
                    <td> <%=habi.getPersonas()%> </td>                
                    <td> <%=habi.getEstado()%> </td> 

                </tr>

                <%
                        }
                    }
                %>

            </table>
        </div>

        <br>
        <footer>
            <div class="col-sm-12" id="footer">
                <div style="text-align: center">

                </div>
            </div>   
        </footer>
    </body>
</html>