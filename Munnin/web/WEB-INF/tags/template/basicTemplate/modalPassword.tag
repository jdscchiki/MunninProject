<%-- 
    Document   : modalPassword
    Created on : 22/02/2017, 08:30:58 PM
    Author     : Juan David Segura
--%>

<%@tag description="modal to change password on basicTemplate" pageEncoding="UTF-8"%>

<div id="changePassword" class="modal fade" role="dialog">
    <form id="formChangePassword" class="form-horizontal" action="${pageContext.request.contextPath}/home/change-password" method="POST">
        <div class="modal-dialog">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Cambio de Contraseña</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordCurrent">Actual:</label>
                        <div class="col-sm-5">
                            <input id="passwordCurrent" type="password" name="passwordCurrent" class="form-control" placeholder="Contraseña actual" maxlength="16" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordNew">Nueva contraseña:</label>
                        <div class="col-sm-5">
                            <input id="passwordNew" type="password" name="passwordNew" class="form-control" placeholder="Nueva contraseña" maxlength="16" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordNewC">Repetir nueva contraseña:</label>
                        <div class="col-sm-5">
                            <input id="passwordNewC" type="password" name="passwordNewC" class="form-control" placeholder="Repite nueva contraseña"  maxlength="16" />
                        </div>
                    </div>
                    <div id="divPassword_message">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Cambiar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
</div>
