<%-- 
    Document   : modalEditCategories
    Created on : 25/03/2017, 12:33:18 PM
    Author     : Monica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="editCategories" class="modal fade" role="dialog">
    <form id="formEditCategories"
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/categories/edit-categories" 
          data-display="divEditCategories_message" 
          data-data-table="tableBodyCategories">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Editar Categoria</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formEditCategoriesNombre" class="control-label col-lg-3">Nombre : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="formEditCategoriesNombre" name="nombre" maxlength="70" value="${categories.getNombre()}">                            
                            <input type="hidden" name="id" value="${categories.getId()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divEditCategories_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success" 
                            data-action="" 
                            data-panel-table="formEditCategories">Guardar</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#editCategories").modal();
            $(document).on("hidden.bs.modal", "#editCategories", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>