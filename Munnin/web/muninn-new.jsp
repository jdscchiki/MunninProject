<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Munnin</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="shortcut icon" type="image/x-icon" href="">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/skin-start.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<style>
			.full-logo {
				width: 270px;
				height: 95px;
			}
		</style>
	</head>
<body>
	<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
		<img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
	</div>

	<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a  class="navbar-brand" href="#">Munnin</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#vtn0" class="btn" data-toggle="modal">Prueba</a></li>
					<li><a href="#vtn1" class="btn" data-toggle="modal">Material de Apoyo </a></li>
					<li><a href="#vtn2" class="btn" data-toggle="modal">listas de chequeo </a></li>
					<li><a href="#vtn3" class="btn" data-toggle="modal">buscar </a></li>
					<li><a href="#vtn4" class="btn" data-toggle="modal">agregar usuario</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><input type="text" name="search" class="search" placeholder="Buscar..."></li>
					<li><a href="#"><span class="glyphicon glyphicon-bell"></span></a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span> Imagen</a></li>
					<li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
		<h1>Some text to enable scrolling</h1>
	</div>
	
	
			<div class="modal fade" id="vtn1">
				<div class="modal-dialog">	
					<div class="modal-content">
						<div class="modal-header">	
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h3 class="modal-title">Material de apoyo </h3>
						</div>
						<div class="modal-body" style="background:#F6FBFC">
							<label for="#upload">Ingresa el archivo : </label><input id="upload" name="imagen" type="file" style="display:inline">
							<br>
							<form role="form">
							    <div class="form-group">
									<label for="#sel1">Categoria : </label>
									<select class="form-control" id="sel1">
										<option>Categoria </option>
										<option>Programacion</option>
										<option>Dibujo Artistico</option>
										<option>Libro claramente no plagiado</option>
										<option>Chupa el perro 2</option>
										<option>Mi libro luna de pluton es todo un exito...</option>
									</select>
									<br>
									<label for="#sel2">Tipo : </label>
									<select class="form-control" id="sel2">
										<option>Taller </option>
										<option>Esto no es una guia</option>
										<option>Lectura </option>
										<option>Evaluacion </option>
										<option>Otro </option>
									</select>
								</div>
							</form>		
							<h4>Comentarios : </h4>
							<textarea name="" id="" cols="77" rows="10"></textarea>
						</div>
					</div>
				</div>
			</div>

			<!--btn listas de chequeo-->
			
			<div class="modal fade" id="vtn2">
				<div class="modal-dialog">	
					<div class="modal-content">
						<div class="modal-header">
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h3 class="modal-title">Lista de chequeo equipo X </h3>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="checkbox"><label><input type="checkbox">Option 1</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 2</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 3</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 4</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 5</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 6</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 7</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 8</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 9</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
								<div class="checkbox"><label><input type="checkbox">Option 10</label></div>
								<textarea name="" id="" cols="77" rows="3"></textarea>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			<!--menu lateral izquierdo-->
			
			<div class="modal fade" id="vtn3">
				<div class="modal-dialog">	
					<div class="modal-content">
						<div class="modal-header">
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h3 class="modal-title">Filtros : </h3>
						</div>
						<div class="modal-body">
							<form>
								<!--<input class="search" type="text" name="search" placeholder="Buscar...">-->
								<br>
								<label for="#sel3">Categoria :</label>
								<select id="sel3" class="form-control">
									<option>Categoria </option>
									<option>Programacion </option>
									<option>Diseño </option>
									<option>Dibujo Artistico </option>
								</select>
								<label for="#sel4">Tipo :</label>
								<select id="sel4" class="form-control">
									<option>Taller </option>
									<option>Esto sigue sin ser una guia </option>
									<option>Evaluacion </option>
									<option>Lectura </option>
								</select>
								<label for="#sel5">Area de Formacion</label>
								<select id="sel4" class="form-control">
									<option>Area... </option>
									<option>opcion 1 </option>
									<option>opcion 2 </option>
									<option>opcion 3 </option>
								</select>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!--agregar usuario -->
			
			<div class="modal fade" id="vtn4">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h3 class="modal-title">Agregar Usuario</h3>
						</div>
						<div class="modal-body">
							<div style="position:relative">
							<form action="">
									<label for="nombre">Nombre: </label>
									<input type="text" class="form-control" id="nombre">
									<label for="apellido">Apellido: </label>
									<input type="text" class="form-control" id="apellido">
									<label for="correo">Correo: </label>
									<input type="text" class="form-control" id="correo">
									<label for="correo1">Confirme su correo: </label>
									<input type="text" class="form-control" id="correo1">
									<label for="contraseña">Contraseña:</label>
									<input type="text" class="form-control" id="contraseña">
									<label for="contraseña1">Confirme su contraseña:</label>
									<input type="text" class="form-control" id="contraseña1">
									<label for="rol">Seleccione rol:</label>
									<select id="rol" class="form-control">
										<option>Instructor </option>
										<option>Jefe equipo tecnico</option>
										<option>Jefe equipo pedagogico</option>
										<option>Cordinador </option>
										<option disabled>Admin </option>
									</select>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button>Añadir </button>
						</div>
					</div>
				</div>
			</div>
			

	<div class="modal fade" id="vtn0">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>