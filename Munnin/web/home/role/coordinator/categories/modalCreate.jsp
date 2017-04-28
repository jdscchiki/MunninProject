<%-- 
    Document   : modalCreateCategories
    Created on : 25/03/2017, 12:28:58 PM
    Author     : Monica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="registerCategories" class="modal fade" role="dialog">
    <form id="formRegisterCategories" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/categories/register" 
          data-display="divRegisterCategories_message"
          data-data-table="tableBodyCategories">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Crear Categoria</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formRegisterCategoriesNombre" class="control-label col-lg-3">Nombre : </label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="formRegisterCategoriesNombre" name="nombre" placeholder="Nombre Categoria" maxlength="70">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="divRegisterCategories_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success"
                            data-panel-table="formRegisterCategories"
                            data-action="">Crear</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
</div>
