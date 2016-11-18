<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <jsp:include page="contenido/head.jsp" ></jsp:include>        
        </head>
        <body data-spy="scroll" data-target=".navbar" data-offset="50">
            <!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
                    <img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
            </div>-->

            <!--navbar-->
        <jsp:include page="contenido/navbar.jsp" ></jsp:include>

            <!--changing role-->
        <jsp:include page="contenido/roles.jsp" ></jsp:include>

            <!--content start_page-->
            <div class="container-fluid filled">
                <form class="form-horizontal" action="cambioContrasena" method="POST" onsubmit="return validarPass()">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="passwordActual">Contraseña actual:</label>
                        <div class="col-sm-6">
                            <input id="passwordActual" type="password" name="passwordActual" class="form-control" placeholder="Contraseña actual"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="passwordNew1">Nueva contraseña:</label>
                        <div class="col-sm-6">
                            <input id="passwordNew1" type="password" name="passwordNew1" class="form-control" placeholder="Nueva contraseña"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="passwordNew2">Repite contraseña:</label>
                        <div class="col-sm-6">
                            <input id="passwordNew2" type="password" name="passwordNew2" class="form-control" placeholder="Repite nueva contraseña"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Submit</button>
                        </div>
                    </div>
                    <div id="div_mensaje" class="">
                        <p id="mensaje">
                        </p>
                    </div>
                </form>
            </div>
            <!--footer-->
        <jsp:include page="contenido/footer.jsp"></jsp:include>

        <jsp:include page="contenido/javascript.jsp"></jsp:include>
            <script src="js/index_validator.js" type="text/javascript"></script>
            <script src="js/mensajes.js" type="text/javascript"></script>
        <% if (request.getAttribute("Mensaje") != null) { %>
        ${Mensaje}
        <% }%>
    </body>
</html>
