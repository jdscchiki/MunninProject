<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="calificarArchivo" class="modal fade" role="dialog">
    <form id="formcalificarArchivo" 
          class="form-horizontal"
          role="form" 
          method="POST" 
          data-ajax-form="true"
          action="${pageContext.request.contextPath}/home/role/technical/files/assign-list"
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
                            <input type="hidden" name="idVersion" value="${version.getId()}">
                            <input type="hidden" name="idLista" value="${lista.getId()}">
                            <c:forEach items="${items}" var="item">
                                <div class="checkbox">
                                    <label><input type="checkbox" 
                                                  name="item" 
                                                  value="${item.getId()}">
                                        ${item.getDescriptor()}
                                    </label>
                                    <textarea name="coment${item.getId()}" maxlength="50" placeholder=" Comentario"></textarea>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="message_file" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="${pageContext.request.contextPath}/home/download?idVersion=${version.getId()}" 
                       class="btn btn-primary pull-left"
                       target="_blank">
                        descargar
                    </a>
                    <button type="button" class="btn btn-primary" data-panel-table="formcalificarArchivo" data-action="rechazar">Rechazar</button>
                    <button type="button" class="btn btn-primary" data-panel-table="formcalificarArchivo" data-action="aprobar">Aprobar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>                    
                </div>
            </div>
        </div>
        <input type="hidden" name="action" data-action="">
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