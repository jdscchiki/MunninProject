<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Muninn</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="shortcut icon" type="image/x-icon" href="imagenes/icono.png">
		<link rel="stylesheet" href="css/estilos.css">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
                <script src="js/sha512.js" type="text/javascript"></script>
                <script src="js/encrypt.js" type="text/javascript"></script>
	</head>
	<body>
		
		<header>
			
		</header>

		<section>

			<div class="clogin">
				<div class="login">
                                    <img src="imagenes/icono_munnin.png" alt="munnin_icono">
					<h3>Ingreso</h3>
					<hr>
                                        <form role="form" metodo="post" action="ingreso">	
					    <div class="form-group">
					    	<h4>Correo</h4>
                                                <input type="text" id="email" placeholder="Tu correo" name="textCorreo" value="">
					    	<i><span class="glyphicon glyphicon-user"></span></i>	
					    </div>
					    <div class="form-group">
					      	<h4>Contrase�a</h4>
					      	<input type="password" id="pwd" placeholder="Tu contrase�a" name="textPass">
                                                <!-- para el servlet se consulta es la contrase�a encriptada -->
                                                <input id="pwd_encrypt" type="hidden" name="textPassEncrypt">
					      	<i><span class="glyphicon glyphicon-lock"></span></i>
					    </div>
					    <div class="checkbox">
					      	<p><input type="checkbox">Recuerdame </p> 
						    <a href=""> �He olvidado mi contrase�a! </a>
					    </div>
                                            <div id="respuesta">
                                                <% if(request.getAttribute("Error")!= null){ %>
                                                    ${Error}
                                                <% } %>
                                            </div>
                                            <button id="enviar" onclick="encrypt()"type="button"><span>Entrar</span></button>
				  	</form>
				</div>			
			</div>
			
		</section>

		<footer>
			<ul id="menu">
				<li><a href="">Opcion-1	-Footer </a></li>
				<li><a href="">Opcion-2-Footer </a></li>
				<li><a href="">Opcion-3-Footer </a></li>
				<li><a href="">Opcion-4-Footer</a></li>
			</ul>		
		</footer>
	
	</body>
</html>