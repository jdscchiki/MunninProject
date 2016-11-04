<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Munni</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid" style="padding-top: 20px">
		<div class="modal-content">
	        <div class="modal-header">
	          	<h4 class="modal-title">Modal Header</h4>
	        </div>
        	<%@page import="modelo.bean.TipoDocumento"%>
			<%@page import="java.util.ArrayList"%>
			<%@ page language="java" session="false"%>
			<form role="form" method="POST" action="registro">
		        <div class="modal-body">
				    <label for="tipoDoc">Tipo de documento:</label>
				    <select id="tipoDoc" class="form-control" name="tipoDoc" style="width: 180px">
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
				    <label for="documento">Documento :</label>
					<!--<select id="documento" class="form-control" style="width:120px">
						<option value="">C.C. </option>
						<option value="">C.E. </option>
						<option value="">Pasaporte </option>	
					</select>-->
					<input type="text" class="form-control" id="documento" name="documento">
				    <label for="correo">Correo : </label>
					<input type="text" class="form-control" id="correo" name="correo">
					<!--<label for="correo1">Confirme el correo  </label>
					<input type="text" class="form-control" id="correo1">-->
				    <label for="nombre">Nombres : </label>
					<input type="text" class="form-control" id="nombre" name="nombre">
					<label for="apellido">Apellidos : </label>
					<input type="text" class="form-control" id="apellido" name="apellido">
				    <label for="telefono">Telefono:</label>
				    <input type="text" class="form-control" id="telefono" name="telefono">
				    <label for="idCentro">Id Centro:</label>
				    <input type="text" class="form-control" id="idCentro" name="idCentro">
		        </div>
		        <div class="modal-footer">
			        <button type="submit" class="btn btn-success">Registrar Funcionario</button>
			    	<button type="reset" class="btn btn-success">Borrar datos del formulario</button>
		        </div>
	        </form>
	    </div>
		
	</div>
</body>
</html>