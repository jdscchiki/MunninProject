<%@page import="modelo.bean.TipoDocumento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%-- esto se usa en el top para dar propiedades segun la pagina--%>
<%
    request.setAttribute("title", "Munnin Coordinador");
    request.setAttribute("navbar", 3);
    request.setAttribute("mainPage", 3);
    
    String aditionalJS = "";
    aditionalJS += "<script src='"+request.getContextPath()+"/js/mensajes.js' type='text/javascript'></script>";
    
    request.setAttribute("aditionalJS", aditionalJS);
%>
<jsp:include page="/elements/content/top.jsp" />
<%-- todo el contnido aqui--%>
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

<jsp:include page="/elements/content/bot.jsp" />
