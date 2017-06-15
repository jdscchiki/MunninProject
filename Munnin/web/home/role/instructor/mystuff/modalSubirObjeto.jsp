<%-- 
    Document   : modalSubirArchivo
    Created on : 19/05/2017, 07:37:02 AM
    Author     : Monica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="modalSubirObjeto" class="modal fade" role="dialog">
    <form class="form-horizontal" 
          role="form" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Ver Objeto</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="formSubirObjetoNumero" class="control-label col-lg-3">Número Version :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="formSubirObjetoNumero" name="numero" maxlength="70" value="${verResult.getNumero()}" disabled>                
                        </div>
                    </div> 
                    <div class="form-group">
                        <label for="formSubirObjetoEstado" class="control-label col-lg-3">Estado Version :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="formSubirObjetoNombre" name="estado" maxlength="70" value="${verResult.getEstado().getNombre()}" disabled>                
                        </div>
                    </div>    
                    <div class="form-group">
                        <label for="formVerObjetoNombre" class="control-label col-lg-3">Nombre :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="formVerObjetoNombre" name="nombre" maxlength="70" value="${verResult.getProducto().getNombre()}" disabled>                
                        </div>
                    </div>
                    <div class="form-group">    
                        <label for="formVerObjetoDescripcion" class="control-label col-lg-3">Descripción :</label>
                        <div class="col-lg-6">
                            <textarea class="form-control" rows="5" id="formVerObjetoDescrpcion" disabled>${verResult.getProducto().getDescripcion()}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formSubirObjetoPalabra" class="control-label col-lg-3">Palabra Clave :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="formVerObjetoNombre" name="nombre" maxlength="70" value="${verResult.getProducto().getPalabrasClave()}" disabled>                
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button id="btnSubirCorreccion"
                            class="btn btn-success">
                        Subir Corrección
                    </button>
                </div>

            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#modalSubirObjeto").modal();
            $(document).on("click", "#btnSubirCorreccion", function (event) {
                event.preventDefault();
                
                $("#modalSubirObjeto").modal("hide");
                $("#modalSubirCorreccion").modal("show");
                
            });
        });
    </script>
</div>

<jsp:include page="/home/role/instructor/mystuff/modalSubirCorreccion.jsp" />            

