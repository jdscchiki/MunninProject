<!DOCTYPE html>
<html lang="es">
<head>
	<title>Munnin</title>
	<jsp:include page="/contenido/head.jsp" ></jsp:include>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
		<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
	</div>-->

	<!--navbar-->
        <jsp:include page="contenido/navbar.jsp" ></jsp:include>

	<!--changing role-->
	<jsp:include page="/contenido/roles.jsp" ></jsp:include>

	<!--content start_page-->
        <div class="container-fluid filled">
            
        </div>
	<!--footer-->
        <jsp:include page="/contenido/footer.jsp"></jsp:include>
	
        <jsp:include page="/contenido/javascript.jsp"></jsp:include>
</body>
</html>
