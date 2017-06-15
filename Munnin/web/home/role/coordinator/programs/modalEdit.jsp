<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="editProgram" class="modal fade" role="dialog">
    <form id="formEditProgram"
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/programs/edit" 
          data-display="divEditProgram_message" 
          data-data-table="tableBodyPrograms">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Editar Programa</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formEditProgramNombre" class="control-label col-lg-3">Nombre : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="formEditProgramNombre" name="nombre" maxlength="70" value="${program.getNombre()}">                            
                            <input type="hidden" name="id" value="${program.getId()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divEditProgram_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success" 
                            data-action="" 
                            data-panel-table="formEditProgram">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editProgram").modal();
            $(document).on("hidden.bs.modal", "#editProgram", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>