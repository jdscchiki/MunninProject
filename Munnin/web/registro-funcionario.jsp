<%-- 
    Document   : registro-funcionario
    Created on : 26/10/2016, 10:39:00 PM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.bean.TipoDocumento" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Munnin</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form role="form" method="POST" action="ingreso">
            <label for="tipoDoc">Tipo de documento:</label>
            <select id="tipoDoc" name="tipoDoc">
                <!-- Las opciones se actualizan con una consulta al servidor-->
                <% 
                    ArrayList<TipoDocumento> tiposDoc = (ArrayList<TipoDocumento>)request.getAttribute("tiposDoc");
                    if(!tiposDoc.isEmpty()){
                        for(int i = 0; i<tiposDoc.size();i++){
                %>
                
                <option value="<%=tiposDoc.get(i).getId()%>"> <%=tiposDoc.get(i).getNombre()%> </option>
                <%
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
            <button type="submit">Registrar Funcionario</button>
            <button type="reset">Borrar datos del formulario</button>
        </form>
    </body>
</html>
