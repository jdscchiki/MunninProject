<!DOCTYPE html>
<html lang="en">
<head>
	<title>Munnin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/skin-start.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<!--navbar-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
					<div class="container" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
						<div class="bar1"></div>
						<div class="bar2"></div>
						<div class="bar3"></div>
					</div>
				</button>
				<img class="navbar-brand" src="imagenes/LogoNavbar.png" alt="munnin-logo" style="padding: 7px 7px;">
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0)" class="tablinks" id="defaultOpen" onclick="menuOpcion(event, 'option1')">Tablas</a></li>
					<li><a href="javascript:void(0)" class="tablinks" onclick="menuOpcion(event, 'option2')">UpLoad</a></li>
			      	<li><a href="javascript:void(0)" class="tablinks" onclick="menuOpcion(event, 'option3')">option3</a></li>
					<li><a href="#vtn2" data-toggle="modal">listas de chequeo </a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
					<li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Usuario</a>
		              	<ul class="dropdown-menu ">
		                	<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
		               		<li><a href="#"><span class="glyphicon glyphicon-credit-card"></span> Calendario</a></li>
		               		<li><a href="#"><span class="fa fa-question-circle-o glyphicon"></span> Preguntas Frecuentes</a></li>		
		              	</ul>
		            </li>
					<li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
				</ul>
			</div>
		</div>
	</nav>

<!--left changing_role-->
	<div class="left">
		<div class="item">
			<span class="fa fa-eye glyphicon" style="font-size:18px"></span>Administrador
		</div>
		<div class="item active">
			<span class="fa fa-file-o glyphicon" style="font-size:18px"></span>Cordinador
		</div>
		<div class="item">
			<span class="fa fa-group glyphicon" style="font-size:18px"></span>ETecnico
		</div>
		<div class="item">
			<span class="fa fa-group glyphicon" style="font-size:18px"></span>EPedagogico
		</div> 
		<div class="item">
			<span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
		</div>    
	</div>

<!--Log out-->
	<div class="modal fade" id="vtn">
    	<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>¿Esta seguro de querer salir?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick=" location.href='index.jsp'">Salir</button>
				</div>
			</div>
		</div>
	</div>

<!--content start_page-->
	<div class="container-fluid filled">
		
		<div class="contain">
			<div class="col-md-12">
			   	<div id="option1" class="tabcontent">
				   	<div class="clearfix">
					   	<div class="float-left">
				   			<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
				                <div class="btn-group">
				                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-folder"></i> <span class="caret"></span></a>
				                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
				                        <li><a href="#">Social</a></li>
				                        <li><a href="#">Forums</a></li>
				                        <li><a href="#">Updates</a></li>
				                       
				                        <li><a href="#">Spam</a></li>
				                        <li><a href="#">Trash</a></li>
				                       
				                        <li><a href="#">New</a></li>
				                    </ul>
				                </div>
				                <div class="btn-group">
				                    <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tags"></i> <span class="caret"></span></a>
				                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
				                        <li><a href="#">Work</a></li>
				                        <li><a href="#">Family</a></li>
				                        <li><a href="#">Social</a></li>
				                       
				                        <li><a href="#">Primary</a></li>
				                        <li><a href="#">Promotions</a></li>
				                        <li><a href="#">Forums</a></li>
				                    </ul>
				                </div>
				            </div>
				        </div>
				        <div class="float-right">
				            <ul class="pagination">
								<li><a href="#" class="fa fa-chevron-circle-left"></a></li>
								<li><a class="active" href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#" class="fa fa-chevron-circle-right"></a></li>
							</ul>
						</div>
						<!-- <span onclick="this.parentElement.style.display='none'" class="topright">x</span> -->
						<div style="clear: left;">
							<table class="table table-hover">
				    			<thead>
							      	<tr>
							        	<th>Firstname</th>
							        	<th>Lastname</th>
							        	<th>Email</th>
							      	</tr>
							    </thead>
							    <tbody id="point">
								    <tr>
								        <td>col1 f1</td>
								        <td>col2 f1</td>
								        <td>col3 f1</td>
								        <td>col4 f1</td>
								        <td>col5 f1</td>
								        <td>col6 f1</td>
								        <td>col7 f1</td>
								    </tr>
								    <tr>
								        <td>col1 f2</td>
								        <td>col2 f2</td>
								        <td>col3 f2</td>
								        <td>col4 f2</td>
								        <td>col5 f2</td>
								        <td>col6 f2</td>
								        <td>col7 f2</td>
								    </tr>
								    <tr>
								        <td>col1 f3</td>
								        <td>col2 f3</td>
								        <td>col3 f3</td>
								        <td>col4 f3</td>
								        <td>col5 f3</td>
								        <td>col6 f3</td>
								        <td>col7 f3</td>
								    </tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div id="option2" class="tabcontent">
					<form role="form">
						<h3>Documento para revicion</h3><br>
						<div class="form-group">
							<label for="#upload"><h4>Adjuntar :</h4></label><input id="upload" name="imagen" type="file" class="form-control">
						</div>
					    <div class="form-group">
							<label for="#sel1"><h4>Categoria :</h4></label>
							<select class="form-control" id="sel1">
								<option>Categoria </option>
								<option>Programacion</option>
								<option>Dibujo Artistico</option>
								<option>Libro claramente no plagiado</option>
								<option>Chupa el perro 2</option>
								<option>Mi libro luna de pluton es todo un exito...</option>
							</select>
						</div>
						<div class="form-group">
							<label for="#sel2"><h4>Tipo :</h4></label>
							<select class="form-control" id="sel2">
								<option>Taller </option>
								<option>Esto no es una guia</option>
								<option>Lectura </option>
								<option>Evaluacion </option>
								<option>Otro </option>
							</select>
						</div>
						<div class="form-group">
							<h4>Comentarios : </h4>
							<textarea class="form-control" rows="5" name="" maxlength="240"></textarea><br>
							<div class="btn-group btnsDown">
								<button type="button" class="btn btn-danger" onclick=" location.href='munnin.jsp'">Atras</button>
								<button type="button" class="btn btn-success">Enviar</button>
							</div>
						</div>
					</form>	
				</div>

				<div id="option3" class="tabcontent">
					<form action="">
						<div class="form-group">
							<label for="nombre">Nombres : </label>
							<input type="text" class="form-control" id="nombre">
						</div>
						<div class="form-group">
						<label for="apellido">Apellidos : </label>
						<input type="text" class="form-control" id="apellido">
						</div>
						<div class="form-group">
							<label for="documento">Documento :</label>
							<select id="documento" class="form-control" style="width:120px">
								<option value="">C.C. </option>
								<option value="">C.E. </option>
								<option value="">Pasaporte </option>	
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="documento">
						</div>
						<div class="form-group">
							<label for="correo">Correo : </label>
							<input type="text" class="form-control" id="correo">
						</div>
						<div class="form-group">
							<label for="correo1">Confirme su correo  </label>
							<input type="text" class="form-control" id="correo1">
						</div>
						<div class="form-group">
							<label for="contraseña">Contraseña :</label>
							<input type="text" class="form-control" id="contraseña">
						</div>
						<div class="form-group">
							<label for="contraseña1">Confirme su contraseña :</label>
							<input type="text" class="form-control" id="contraseña1">
						</div>
						<div class="btn-group">
							<button type="button" class="btn btn-success">Añadir </button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
						</div>
					</form>
				</div>

				<!--modelo de ventana guia-->
				<div id="option" class="tabcontent">
					<span onclick="this.parentElement.style.display='none'" class="topright">x</span>
					<h3>opcionTitle</h3>
					<p>content.</p>
				</div>

			</div>
		</div>

	</div>

<!--check_list-->
	<div class="modal fade" id="vtn2">
		<div class="modal-dialog">	
			<div class="modal-content">
				<div class="modal-header">
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Lista de chequeo equipo X </h3>
				</div>
				<div class="modal-body">
					<form method="POST">
						<label for="nombreLista">nombre de la lista:</label>
						<input type="text" class="form-control" id="nombreLista">
					    <div id="dynamicInput">
					        <input type="checkbox"><label for="item"> Item 1</label>
					        <textarea class="form-control" cols="77" rows="3"></textarea><br>
					    </div>
					    <input type="button" class="btn btn-default" value="Agregar Item" onClick="addInput('dynamicInput');">
					    <a href="#" title="Ayuda al Usuario" data-toggle="popover" data-content="El boton 'guardar' permitira que el usuario pueda guardar la lista de chequeo actual para usarla posteriormente, y el boton 'agregar' añadira la lista de chequeo sin guardarla.">¿Primera vez?</a>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success">Guardar</button>
					<button type="button" class="btn btn-primary">Agregar</button>
		            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
		        </div>
			</div>
		</div>
	</div>
	
<!--footer-->
	<div class="Restricted__footer">
		<div class="Footer">
			<div class="Footer__topMenu">
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						About
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Blog
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Privacy
					</a>
				</div>
				<div class="Footer__topMenu__item">
					<a class="Footer__topMenu__item__link" href="#">
						Terms
					</a>
				</div>
			</div>
			<div class="Footer__bottomMenu">
				<div class="Footer__copyrightText">
					<p>© 2016 Munnin.</p>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/add-forms.js" language="Javascript" type="text/javascript"></script>
	<script src="js/selectTables.js" language="Javascript" type="text/javascript"></script>
	<script src="js/showContent.js" language="Javascript" type="text/javascript"></script>
</body>
</html>

