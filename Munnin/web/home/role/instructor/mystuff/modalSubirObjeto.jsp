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
                        <label for="formSubirObjetoNumero" class="control-label col-xs-4">Número Version:</label>
                        <div class="col-xs-8">
                            <label class="fontL control-label">${version.getNumero()}</label>              
                        </div>
                    </div> 
                    <div class="form-group">
                        <label for="formSubirObjetoEstado" class="control-label col-xs-4">Estado Version:</label>
                        <div class="col-xs-8">
                            <label class="fontL control-label">${version.getEstado().getNombre()}</label>                
                        </div>
                    </div>    
                    <div class="form-group">
                        <label for="formVerObjetoNombre" class="control-label col-xs-4">Nombre:</label>
                        <div class="col-xs-8">
                            <label class="fontL control-label">${version.getProducto().getNombre()}</label>                
                        </div>
                    </div>
                    <div class="form-group">    
                        <label for="formVerObjetoDescripcion" class="control-label col-xs-4">Descripción:</label>
                        <div class="col-xs-8">
                            <label class="fontL control-label">${version.getProducto().getDescripcion()}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formSubirObjetoPalabra" class="control-label col-xs-4">Palabra Clave:</label>
                        <div class="col-xs-8">
                            <label class="fontL control-label">${version.getProducto().getPalabrasClave()}</label>                
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

