<!--check_list-->
	<div class="modal fade" id="vtn">
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

<!--  -->
