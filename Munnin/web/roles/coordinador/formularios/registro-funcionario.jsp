<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <jsp:include page="/contenido/head.jsp" ></jsp:include>
        </head>
        <body data-spy="scroll" data-target=".navbar" data-offset="50">
            <!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
                    <img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
            </div>-->

            <!--navbar-->
        <jsp:include page="/roles/coordinador/contenido/navbar.jsp" ></jsp:include>

            <!--changing role-->
        <jsp:include page="/contenido/roles.jsp" ></jsp:include>

            <!--content start_page-->
            <div class="container-fluid filled">
            <%@page import="modelo.bean.TipoDocumento"%>
            <%@page import="java.util.ArrayList"%>
            <%@ page language="java" session="false"%>
            <form role="form" method="POST" action="<%=request.getContextPath()%>/registro">
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
        <!--footer-->
        <jsp:include page="/contenido/footer.jsp"></jsp:include>

        <jsp:include page="/contenido/javascript.jsp"></jsp:include>
    </body>
</html>
