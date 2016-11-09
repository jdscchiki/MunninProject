<!DOCTYPE html>
<html lang="en">
<head>
	<title>Munnin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/skin-index.css">
	<link rel="stylesheet" href="css/skin-indexConfig.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/prefixfree.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<form class="login" role="form" metodo="post" action="ingreso">
			<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
			<p class="title"> Ingreso </p>
			<h4> Correo </h4>
			<input type="text" id="email" maxlength="40" placeholder="Tu correo" name="textEmail" value="">
			<i class="fa fa-user"><span class="glyphicon glyphicon-user"></span></i>
			<h4> Contraseña </h4>
			<input type="password" maxlength="16" id="pwd" placeholder="Tu contraseña" name="textPass">
			<!-- para el servlet se consulta es la contraseña encriptada -->
			<i class="fa fa-key"><span class="glyphicon glyphicon-lock"></span></i>
            <input id="pwd_encrypt" type="hidden" name="textPassEncrypt">
			<a href="#"> ¡He olvidado mi contraseña! </a>
			<div id="respuesta">
				<% if(request.getAttribute("Error")!= null){ %>
					${Error}
				<% } %>
			</div>
			<button>
				<i class="spinner"></i>
				<span class="state" style="font-size: 25px;"> Ingresar </span>
			</button>
		</form>
		<footer><a href="#">©copyright</a></footer>
	</div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/login.js"></script>
</body>
</html>