<%@page import="modelo.bean.TipoDocumento"%>
<%@page import="java.util.ArrayList"%>
<form role="form" method="POST" action="registro">
    <label for="tipoDoc">Tipo de documento:</label>
    <select id="tipoDoc" name="tipoDoc">
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
    <label for="documento">Documento:</label>
    <input type="text" id="documento" name="documento">
    <label for="correo">Correo:</label>
    <input type="text" id="correo" name="correo">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre">
    <label for="apellido">Apellido:</label>
    <input type="text" id="apellido" name="apellido">
    <label for="telefono">Telefono:</label>
    <input type="text" id="telefono" name="telefono">
    <label for="idCentro">Id Centro:</label>
    <input type="text" id="idCentro" name="idCentro">
    <button type="submit">Registrar Funcionario</button>
    <button type="reset">Borrar datos del formulario</button>
</form>