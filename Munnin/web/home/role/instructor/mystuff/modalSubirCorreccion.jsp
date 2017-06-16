<%-- 
    Document   : SubirCorrecion
    Created on : 5/06/2017, 07:26:30 AM
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalSubirCorreccion" 
     class="modal fade" 
     role="dialog">
    <form id="formSubirCorreccion"
          enctype="multipart/form-data"
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/instructor/mystuff/correccion"
          data-ajax-form="true"
          data-display="message_mystuff">
        <input type="hidden" name="correction" value="${Version.getProducto().getId()}">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Subir Correción</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectoNombre">Nombre:</label>
                        <div class="col-sm-10">
                            <input type="text" 
                                   class="form-control" 
                                   name="objectoNombre" 
                                   id="objectoNombre">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectoDescripcion">Descripción:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" 
                                      name="objectoDescripcion" 
                                      id="objectoDescripcion" 
                                      rows="3"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectoTipo">Tipo de objeto:</label>
                        <div class="col-sm-3">
                            <select class="form-control" 
                                    name="objectoTipo"
                                    id="objectoTipo">
                                <c:forEach items="${objectTypes}" var="objectoTipo">
                                    <option value="${objectType.getId()}">${objectType.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>    

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectoArchivo">Archivo</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <label class="input-group-btn">
                                    <span class="btn btn-default">
                                        Buscar&hellip; <input type="file" 
                                                              style="display: none;" 
                                                              name="objectoArchivo" 
                                                              id="objectoArchivo" 
                                                              required="required">
                                    </span>
                                </label>
                                <input type="text" class="form-control" readonly>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button id="btnSubirCorreccionVolver" 
                                class="btn btn-primary">
                            Volver</button>
                        <button type="submit" 
                                class="btn btn-success">
                            Enviar</button>
                    </div>
                </div>

            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(document).on("click", "#btnSubirCorreccionVolver", function (event) {
            event.preventDefault();
            $("#modalSubirCorreccion").modal("hide");
            $("#modalSubirObjeto").modal("show");

        });
    });
</script>