<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="calificarArchivo" class="modal fade" role="dialog">
    <form id="formcalificarArchivo" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/pedagogical/files/assign-list"
          data-data-table="tableBodyFiles"
          data-display="formCalificarArchivo_message">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Calificar Archivo</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-lg-3">Producto:</label>
                        <div class="col-lg-4">
                            <p class="form-control-static">
                                ${version.getProducto().getNombre()}
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3">Items :</label>
                        <div class="col-lg-4">
                            <input type="hidden" name="id" value="${version.getId()}">
                            <c:forEach items="${items}" var="item">
                                <div class="checkbox">
                                    <label><input type="checkbox" 
                                                  name="role" 
                                                  value="${item.getId()}">
                                        ${item.getDescriptor()}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="formAssignRole_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" data-panel-table="formcalificarArchivo">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#calificarArchivo").modal();
            $(document).on("hidden.bs.modal", "#calificarArchivo", function (event) {
                $(this).remove();
            });
        });
    </script>

</div>