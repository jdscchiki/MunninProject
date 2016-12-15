<%@page import="modelo.bean.TipoDocumento"%>
<%@page import="java.util.ArrayList"%>
<form id="formRegisterFunctionary" class="form-horizontal" role="form" method="POST" action="${URICoordinator}register">
    <div id="registerFunctionary" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Registro de funcionarios</h4>
                </div>
                <div class="modal-body">
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
                        <div id="formRegisterFunctionary_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Registrar Funcionario</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </div>
</form>