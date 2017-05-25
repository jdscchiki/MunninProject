<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="addProgram" class="modal fade" role="dialog">
    <form id="formAddProgram" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/programs/add"
          data-display="divAddProgram_message"
          data-data-table="tableBodyPrograms">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Agregar programa</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formAddProgramArea" 
                               class="control-label col-lg-3">
                            Area:</label>
                        <div class="col-lg-4">
                            <select id="formAddProgramArea" 
                                    class="form-control" 
                                    name="area">
                                <c:forEach items="${areas}" var="area">
                                    <option value="${area.getId()}">${area.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formAddProgramDocumento" class="control-label col-lg-3">Nombre :</label>
                        <div class="col-lg-4">
                            <input type="text" 
                                   class="form-control" 
                                   id="formAddProgramDocumento" 
                                   name="nombre" 
                                   placeholder="Nombre del programa" 
                                   maxlength="12">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divAddProgram_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success"
                            data-panel-table="formAddProgram"
                            data-action="">
                        Registrar</button>
                    <button type="reset" 
                            class="btn btn-danger">
                        Borrar datos del formulario</button>
                    <button type="button" 
                            class="btn btn-default" 
                            data-dismiss="modal">
                        Cerrar</button>
                </div>
            </div>
        </div>
    </form>
</div>