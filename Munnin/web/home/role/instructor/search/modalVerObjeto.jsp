<%-- 
    Document   : modalVerObjeto
    Created on : 1/04/2017, 05:56:40 PM
    Author     : Monica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="verObjeto" class="modal fade" role="dialog">
    <form id="formVerObjeto" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/instructor/search/ver" 
          data-display="divVerObjeto_message"
          data-data-table="tableBodyVer">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Ver Objeto</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formVerObjetoNombre" class="control-label col-xs-4">Nombre:</label>
                        <div class="col-xs-8">
                            <p class="form-control-static">${verResult.getProducto().getNombre()}</p>            
                        </div>
                    </div>
                    <div class="form-group">    
                        <label for="formVerObjetoDescripcion" class="control-label col-xs-4">Descripción:</label>
                        <div class="col-xs-8">
                            <p class="form-control-static">${verResult.getProducto().getDescripcion()}</p>
                        </div>
                    </div>
                    <div class="form-group">    
                        <label for="formVerObjetoPalabra" class="control-label col-xs-4">Palabras Clave:</label>
                        <div class="col-xs-8">
                            <div class="tagcloud">
                                <ul>
                                    <c:forEach items="${verResult.getProducto().getPalabrasClave().split(';')}" var="keyword" >
                                        <li>
                                            <div>
                                                ${keyword}
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>    
                    <div class="form-group">
                        <div id="divVerObjeto_message" class="col-xs-offset-3 col-xs-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success"
                            data-action="">Descargar</button>
                </div>
            </div>

        </div>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#verObjeto").modal();
        $(document).on("hidden.bs.modal", "#verObjeto", function (event) {
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/instructor/search", "fulltable");
            $(this).remove();
        });
    });
</script>
</div>
