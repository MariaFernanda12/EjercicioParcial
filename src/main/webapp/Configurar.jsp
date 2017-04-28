
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Configurar</title>                
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
        <br>
        <!--Contenido-->
        <div class="col-sm-12">


            <ul>                
                <li><a href="Configurar.jsp" id="a">Configurar</a></li>
                <li><a href="Reservar.jsp" id="b">Reservar</a></li>
                <li><a href="Entregar.jsp" id="c">Entregar</a></li>
            </ul>
            <br>
            <br>
            <p style="text-align: center; font-size: 27px">El primer número del id es el número del piso</p>
            <form method="post" action="CrearListar">
                <p>Id habitación:</p>
                <input name="id" placeholder="101,201,201..." style="width: 300px;">
                <br>
                <br>
                <br>
                <p>Precio Habitación:</p>
                <input name="precio" placeholder="Precio por noche..." style="width: 300px;">
                <br>
                <br>
                <br>
                <p>Número máximo de personas: </p>
                <input name="cantidad" placeholder="Cantidad máxima de personas..." style="width: 300px;">
                <br>
                <br>
                <br>
                <br>
                <div id="botonEnviar"><input name="Enviar" type="submit" class="enviar" ></div>
                <br>
                <br>

            </form>
            <br>
            <br>
            <br>
            <br>


            <%
                if (request.getAttribute("insersion") != null) {
                    String respuesta = (String) request.getAttribute("insersion");
                    if (respuesta.equals("OK")) {

            %>
            <div class="alert alert-success" style="text-align: center">
                <strong>Success!&nbsp&nbsp&nbsp</strong> Habitacion registrada correctamente
            </div>
            <%        } else if (respuesta.equals("NOK")) {
            %>
            <div class="alert alert-warning" style="text-align: center">
                <strong>Warning!&nbsp&nbsp&nbsp</strong>Problemas durante el registro
            </div>
            <%
                    }
                }
            %>

            <a href="Listar.jsp" id="c">Listar</a>
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