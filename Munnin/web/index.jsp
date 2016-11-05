<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/skin-indexConfig.css">
        <link rel="stylesheet" href="css/skin-index.css">
        <script src="js/index_validator.js" type="text/javascript"></script>
        <script src="js/mensajes.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="wrapper">
            <form class="login" role="form" method="post" action="ingreso" onsubmit="return validar()">
                <!--la imagen es muy grande, toca ajustarla-->
                <img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
                <h2 class="title"> Ingreso </h2>
                <label for="email"> Correo </label>
                <input type="email" id="email" maxlength="40" placeholder="Tu correo" name="textCorreo">
                <i class="fa fa-user"><span class="glyphicon glyphicon-user"></span></i>
                <label for="pwd"> Contraseña </label>
                <input type="password" maxlength="16" id="pwd" placeholder="Tu contraseña" name="textContr">
                <i class="fa fa-key"><span class="glyphicon glyphicon-lock"></span></i>
                <!--aun falta crear la pagina para esto-->
                <a href="#">¡He olvidado mi contraseña! </a>
                <div id="div_mensaje" class="">
                    <p id="mensaje">

                    </p>
                </div>
                <button>
                    <span> Ingresar </span>
                </button>
            </form>
            <footer><a href="#">©copyright</a></footer>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="js/prefixfree.min.js"></script>
        <% if (request.getAttribute("Mensaje") != null) { %>
        ${Mensaje}
        <% }%>
    </body>
</html>