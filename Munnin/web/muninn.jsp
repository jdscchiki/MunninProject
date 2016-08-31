<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Muninn </title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="shortcut icon" type="image/x-icon" href="favicon.png">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/style.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/muninn-action.js"></script>
		<style>
			.btn-cfg {
				color:white;
			}
			.btn-cfg:hover {
				background-color:#000000;
				width: 30px;
				height: 30px;
				border-radius: 50%;
			}
			#m1{
				cursor: pointer;
				font-size:30px;
			}
			.noti {
				right: 0;
				background-color: #FF0000;
			}
			.noti:hover {
				background-color: black;
			}
			#sidebar {
				width: 23%;
			    background-color: #e6e6e6;	
			    float: left;
			    min-height: 500px;
			    margin-top: 0;
			    box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3);
			}
			#sidebar hr {
				border: 0; border-top: 1px solid #999; border-bottom: 1px solid #333; height:0;
			}
			.lupa {
				text-align: center;
			    padding: 14px 0 10px 0;
			}
			aside h4{
				text-transform: uppercase;
				margin: 10px 0 10px 6%;
				float: left;
				width: 92%;
			}
			.toggleLink {
			    color: white;
			    font-size: 10px;
			    display: block;
			    float: right;
			    margin-right: 2%;
			}
			a {
				text-decoration: none;
				color: black;
			}
			#sidebar li {
				list-style: none;
				margin: 0 0 0 12%; padding: 0;
			}
			#sidebar li a {
				padding-left: 25px;
				text-decoration: none;
				display: inline-block;
				height: 17px;
				line-height: 17px;
				margin: 2px 0;
			}
			section #main {
			    width: 77%;
			    min-height: 500px;
			    background-color: #FFFFFF;
			    float: left;
			}
			.top {
				height: 55px;
				width: 100%;
				background-color:#e6e6e6;
			}
			.greeting {
				float: left;
				margin: 0;
				font-size: 22px;
				display: block;
				width: 23%;
				height: 55px;
				font-weight: normal;
				text-align: left;
				text-indent: 1.8%;
				line-height: 55px;
				color: #000000;
				/*text-shadow: 0 -1px 0 #000;*/
			}
			.top-center {
				width: 68%;
				float: left;
				margin: 0;
				font-size: 22px;
				display: block;
				height: 55px;
				font-weight: normal;
				text-align: center;
				text-indent: 1.8%;
				line-height: 55px;
				color: #000000;
				/*text-shadow: 0 -1px 0 #000;*/
			}
			.top-right {
				float: left;
				width: 9%;
			}
			.menu-right {
				display: block;
				margin-top: 12px;
				width: 91px;
				height: 27px;
				text-align: center;
				line-height: 29px;
				color: #000000;
				text-decoration: none;
				/*text-shadow: 0 -1px 0 #000;*/
			}
			.nvbar {
				height: 38px;
				width: 100%;
				background-color: #cccccc;
			}
			.user {
				float: left;
				width: 23%;
				height: 38px;
			}
			.menu-user {
				margin: 0;
				padding: 0;
				font-weight: bold;
				display: block;
				float: left;
				width: 85%;
				height: 35px;
				line-height: 35px;
				text-indent: 25px;
			}
			textarea {
				resize: none;
			}
			.search {
			    width: 230px;
			    box-sizing: border-box;
			    border: 2px solid #ccc;
			    border-radius: 4px;
			    font-size: 16px;
			    background-color: white;
			    background-image: url('../imagenes/searchicon.png');
			    background-position: 10px 10px;
			    background-repeat: no-repeat;
			    padding: 12px 20px 12px 40px;
			    -webkit-transition: width 0.4s ease-in-out;
			    transition: width 0.4s ease-in-out;
			}

			.search:focus {
			    width: 90%;
			}
			.modal-body {
				background:#F6FBFC
			}
		</style>
	</head>
	<body style="display:block">
		
		<header class="top">
			<h1 class="greeting">Hola, Red <span class="glyphicon glyphicon-fire"></span></h1>
			<h2 class="top-center"> No supe que colocar aqui</h2>
			<div class="top-right">
				<a class="menu-right">aqui va algo</a>
			</div>
		</header>

		<section class="nvbar">
			<div class="user">
				<p class="menu-user">Red Fire</p>
				<span class="badge noti" style="cursor:pointer;">7</span>
				<div class="btn-group">
					<div id="m1" data-toggle="dropdown"><span class="btn-cfg icon-circle-down"></span></div>
					<ul class="dropdown-menu">
						<li><a href="#">Configuracion </a></li>
						<li><a href="index.html">Salir </a></li>
					</ul>
				</div>	
			</div>	
		</section>

		<aside id="sidebar" style="height: 1000px;">
			<div class="lupa">
				<form>
					<input class="search" type="text" name="search" placeholder="Buscar...">
				</form>
			</div>
			<hr>
			<h4 title="Por que no puede ser la 0">Lista 1 </h4>
			<ul class="toggle">
				<li><span class="glyphicon glyphicon-plus"></span><a href="#">Nuevo Articulo </a></li>
				<li><span class="glyphicon glyphicon-pencil"></span><a href="#">Editar Aritculos </a></li>
				<li><span class="glyphicon glyphicon-th-list"></span><a href="#">Categorias </a></li>
				<li><span class="glyphicon glyphicon-bookmark"></span><a href="#">Etiquetas </a></li>
			</ul>
			<h4>Rol Disponible</h4>
			<ul class="toggle">
				<li><span class="glyphicon glyphicon-pawn"></span><a href="">Profe </a></li>
				<li><span class="glyphicon glyphicon-knight"></span><a href="">Jf Pedagojico </a></li>
				<li><span class="glyphicon glyphicon-tower"></span><a href="">Jf Tecnico </a></li>
				<li><span class="glyphicon glyphicon-king"></span><a href="">Cordinador </a></li>
				<li><span class="glyphicon glyphicon-fire"></span><a href="">Masterpro :3 </a></li>
			</ul>
			<h4>Lista 3</h4>
			<ul class="toggle">
				<li><span class="glyphicon glyphicon-file"></span><a href="">Archivos </a></li>
				<li><span class="glyphicon glyphicon-picture"></span><a href="">Galeria </a></li>
				<li><span class="glyphicon glyphicon-volume-down"></span><a href="">Audio </a></li>
				<li><span class="glyphicon glyphicon-film"></span><a href="">Video </a></li>
			</ul>
			<h4>Lista 4</h4>
			<ul class="toggle">
				<li><span class=""></span><a href="">1</a></li>
				<li><span class=""></span><a href="">2</a></li>
				<li><span class=""></span><a href="">3</a></li>
			</ul>
		</aside>

		<section id="main" style="height: 1000px;">

			<a href="#vtn1" class="btn btn-primary" data-toggle="modal">Material de Apoyo </a>
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

			<a href="#vtn2" class="btn btn-primary" data-toggle="modal">listas de chequeo </a>
			<div class="modal fade" id="vtn2">
				<div class="modal-dialog">	
					<div class="modal-content">
						<div class="modal-header">
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h3 class="modal-title">Lista de chequeo equipo X </h3>
						</div>
						<div class="modal-body" style="background:#F6FBFC">
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

			<a href="#vtn3" class="btn btn-primary" data-toggle="modal">buscar </a>
			<div class="modal fade" id="vtn3">
				<div class="modal-dialog">	
					<div class="modal-content">
						<div class="modal-header">
							<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
							<h4 class="modal-title">Buscar : </h4>
						</div>
						<div class="modal-body">
							<form>
								<input class="search" type="text" name="search" placeholder="Buscar...">
							</form>
							<h3>Filtros</h3>
							<hr>
							<form>
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
			
		</section>
	
	</body>
</html>