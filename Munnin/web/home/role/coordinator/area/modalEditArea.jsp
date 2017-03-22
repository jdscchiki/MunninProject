<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="editArea" class="modal fade" role="dialog">
    <form id="formEditArea"
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/area/edit-area" 
          data-display="divEditArea_message" 
          data-data-table="tableBodyAreas">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Editar Area</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formEditAreaNombre" class="control-label col-lg-3">Nombre : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="formEditAreaNombre" name="nombre" maxlength="70" value="${area.getNombre()}">                            
                            <input type="hidden" name="id" value="${area.getId()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divEditArea_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success" 
                            data-action="" 
                            data-panel-table="formEditArea">Guardar</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editArea").modal();
            $(document).on("hidden.bs.modal", "#editArea", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>