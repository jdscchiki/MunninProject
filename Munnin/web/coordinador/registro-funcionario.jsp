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
        <title>Munnin</title>
        <meta charset="utf-8">
        <jsp:include page="contenido/head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="../contenido/sidenav.jsp"></jsp:include>
            <div class="right">
                <jsp:include page="../contenido/navbar.jsp"></jsp:include>
                <div class="container-fluid">
                    <h1>Registro</h1>
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
            </div>
            <jsp:include page="../contenido/footer.jsp" ></jsp:include>
        </div>
    </body>
</html>
