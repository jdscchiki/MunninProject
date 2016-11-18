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
            <form name="formName" action="cambioContrasena" method="POST" onsubmit="return validarPass()">
                
                <div id="epasswordActual" style="color:#f00;"></div>
                <div>Contraseña Actual: <input type="password" name="passwordActual"/></div>
                <div id="epasswordNew1" style="color:#f00;"></div>
                <div>Nueva Contraseña: <input type="password" name="passwordNew1"/></div>
                <div>Repite Contraseña: <input type="password" name="passwordNew2"/></div>
                
                <div id="div_mensaje2" class="">
                    <p id="mensaje2">

                    </p>
                </div>
                <button>
                    <span> Enviar </span>
                </button>
            </form>
        </div>
	<!--footer-->
        <jsp:include page="contenido/footer.jsp"></jsp:include>
	
        <jsp:include page="contenido/javascript.jsp"></jsp:include>
        <script src="js/index_validator.js" type="text/javascript"></script>
        <script src="js/mensajes.js" type="text/javascript"></script>
        <% if (request.getAttribute("Mensaje2") != null) { %>
        ${Mensaje2}
        <% }%>
</body>
</html>
