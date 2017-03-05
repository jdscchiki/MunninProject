<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="registerFunctionary" class="modal fade" role="dialog">
    <form id="formRegisterFunctionary" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/register-functionary">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Registro de funcionarios</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formRegisterFunctionaryTipoDoc" 
                               class="control-label col-lg-3">
                            Tipo de documento:</label>
                        <div class="col-lg-4">
                            <select id="formRegisterFunctionaryTipoDoc" 
                                    class="form-control" 
                                    name="tipoDoc">
                                <c:forEach items="${tiposDoc}" var="tipoDoc">
                                    <option value="${tipoDoc.getId()}">${tipoDoc.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formRegisterFunctionaryDocumento" class="control-label col-lg-3">Documento :</label>
                        <div class="col-lg-4">
                            <input type="text" 
                                   class="form-control" 
                                   id="formRegisterFunctionaryDocumento" 
                                   name="documento" 
                                   placeholder="Documento" 
                                   maxlength="12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formRegisterFunctionaryCorreo" 
                               class="control-label col-lg-3">
                            Correo : </label>
                        <div class="col-lg-6">
                            <input type="email" 
                                   class="form-control" 
                                   id="formRegisterFunctionaryCorreo" 
                                   name="correo" 
                                   placeholder="Correo electronico" 
                                   maxlength="100">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formRegisterFunctionaryNombre" 
                               class="control-label col-lg-3">
                            Nombres : </label>
                        <div class="col-lg-6">
                            <input type="text" 
                                   class="form-control" 
                                   id="formRegisterFunctionaryNombre" 
                                   name="nombre" 
                                   placeholder="Nombres"
                                   maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formRegisterFunctionaryApellido" 
                               class="control-label col-lg-3">
                            Apellidos : </label>
                        <div class="col-lg-6">
                            <input type="text" 
                                   class="form-control" 
                                   id="formRegisterFunctionaryApellido" 
                                   name="apellido" 
                                   placeholder="Apellidos" 
                                   maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formRegisterFunctionaryTelefono" 
                               class="control-label col-lg-3">
                            Telefono:</label>
                        <div class="col-lg-4">
                            <input type="text" 
                                   class="form-control" 
                                   id="formRegisterFunctionaryTelefono" 
                                   name="telefono" 
                                   placeholder="Telefono" 
                                   maxlength="10">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divRegisterFunctionary_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Registrar</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </form>
</div>