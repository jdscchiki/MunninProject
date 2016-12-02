<!--check_list-->
	<div class="modal fade" id="vtn1">
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

<!--formulario_ingreso-->
	<div class="modal fade" id="vtn2">
    	<div class="modal-dialog">
      		<div class="modal-content">
        		<div class="modal-header">
          			<button type="button" class="close" data-dismiss="modal">&times;</button>
          			<h4 class="modal-title">Formulario de ingreso</h4>
        		</div>
        		<form action="">
	        	<div class="modal-body">
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
	        	</div>
	        	<div class="modal-footer">
	          		<button type="submit" class="btn btn-success">Añadir </button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>	        		
	        	</div>
	        	</form>
      		</div>
    	</div>
  	</div>

<!--Add algo no me acuerdo como se llama-->
	<div class="modal fade" id="vtn3">
		<div class="modal-dialog">	
			<div class="modal-content">
				<div class="modal-header">
					<button tyle="button" class="close" data-dismiss="modal" aria-hiden="true">&times;</button>
					<h3 class="modal-title">Añadir Documento</h3>
				</div>
				<form action="">
				<div class="modal-body">
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
						<textarea class="form-control" rows="5" name="" maxlength="240"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" onclick=" location.href='munnin.jsp'">Atras</button>
					<button type="button" class="btn btn-success">Enviar</button>
		        </div>
		        </form>
			</div>
		</div>
	</div>


<!--  -->

<div class="row">
    <div class="col-sm-8 col-sm-offset-2">
        <div class="panel panel-default">
            <div class="panel-heading">Registro de funcionarios</div>
            <div class="panel-body">
                <form class="form-horizontal" role="form" method="POST" action="<%=request.getContextPath()%>/registro">
                    <div class="form-group">
                        <label for="tipoDoc" class="control-label col-lg-3">Tipo de documento:</label>
                        <div class="col-lg-4">
                            <select id="tipoDoc" class="form-control" name="tipoDoc">
                                <!-- Las opciones se actualizan con una consulta al servidor-->
                                <%
                                    if (request.getAttribute("tiposDoc") != null) {
                                        ArrayList<TipoDocumento> tiposDoc = (ArrayList<TipoDocumento>) request.getAttribute("tiposDoc");
                                        if (!tiposDoc.isEmpty()) {
                                            for (int i = 0; i < tiposDoc.size(); i++) {

                                %>
                                <option value="<%=tiposDoc.get(i).getId()%>"> <%=tiposDoc.get(i).getNombre()%> </option>
                                <%
                                            }
                                        }
                                    }
                                %>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="documento" class="control-label col-lg-3">Documento :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="documento" name="documento" placeholder="Documento" maxlength="12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="correo" class="control-label col-lg-3">Correo : </label>
                        <div class="col-lg-6">
                            <input type="email" class="form-control" id="correo" name="correo" placeholder="Correo electronico" maxlength="100">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nombre" class="control-label col-lg-3">Nombres : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombres"maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="apellido" class="control-label col-lg-3">Apellidos : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellidos" maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefono" class="control-label col-lg-3">Telefono:</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Telefono" maxlength="10">
                        </div>
                    </div>
                    <div id="div_mensaje" class="">
                        <p id="mensaje">
                        </p>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-3 col-lg-8">
                            <button type="submit" class="btn btn-success">Registrar Funcionario</button>
                            <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>