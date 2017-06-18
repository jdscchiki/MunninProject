<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="registerArea" class="modal fade" role="dialog">
    <form id="formRegisterArea" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/area/register" 
          data-display="divRegisterAreas_message"
          data-data-table="tableBodyAreas">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Crear Area</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formRegisterAreaNombre" class="control-label col-lg-3">Nombre : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="formRegisterAreaNombre" name="nombre" placeholder="Nombre Area" maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divRegisterAreas_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success"
                            data-panel-table="formRegisterArea"
                            data-action="">Crear</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
</div>