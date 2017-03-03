<%-- 
    Document   : modalLogOut
    Created on : 22/02/2017, 08:28:04 PM
    Author     : Juan David Segura
--%>

<%@tag description="logout modal of basicTemplate" pageEncoding="UTF-8"%>

<div class="modal fade" id="vtn">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cerrar sesión</h4>
            </div>
            <div class="modal-body">
                <p>¿Esta seguro de cerrar sesión?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/exit" >Salir</a>
            </div>
        </div>
    </div>
</div>