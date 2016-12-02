<!-- <%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Munnin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/skin-index.css">
</head>
<body>
	<div class="wrapper">
		<form class="login" role="form" action="ingreso">
			<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
			<h1 class="title"> Inicia sesión en Munnin </h1>
			<h4> Correo </h4>
			<input type="text" id="email" maxlength="40" placeholder="Tu correo" name="textEmail" value="">
			<i class="fa fa-user"><span class="glyphicon glyphicon-user"></span></i>
			<h4> Contraseña </h4>
			<input type="password" maxlength="16" id="pwd" placeholder="Tu contraseña" name="textPass">
			<i class="fa fa-key"><span class="glyphicon glyphicon-lock"></span></i>
            <input id="pwd_encrypt" type="hidden" name="textPassEncrypt">
			<button>
				<i class="spinner"></i>
				<span class="state" style="font-size: 25px;"> Ingresar </span>
			</button>
		</form>
		<footer><a href="#">© 2016 Munnin.</a></footer>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/prefixfree.min.js"></script>
	<script src="js/login.js"></script>
</body>
</html>
