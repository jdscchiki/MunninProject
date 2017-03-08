<%@tag description="modal to change password on basicTemplate" pageEncoding="UTF-8"%>

<div id="changePassword" class="modal fade" role="dialog">
    <form id="formChangePassword" action="${pageContext.request.contextPath}/home/change-password" method="POST">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Perfil</h4>
                </div>
                <div class="modal-body">
                    <div class="media">
                        <div class="media-left">
                            <img src="${pageContext.request.contextPath}/resources/img/img_avatar1.png" class="media-object" style="width:60px">
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Nombre Usuario</h4>
                            <p>Rol actual</p>
                        </div><br>
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo : </label>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="correo" type="text" class="form-control" name="correo" placeholder="ejemplo@misena.edu.co" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="passwordCurrent">Actual:</label>
                        <input id="passwordCurrent" type="password" name="passwordCurrent" class="form-control" placeholder="Contraseña actual" maxlength="16" />
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="passwordNew">Nueva contraseña:</label>
                        <input id="passwordNew" type="password" name="passwordNew" class="form-control" placeholder="Nueva contraseña" maxlength="16" />
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="passwordNewC">Repetir nueva contraseña:</label>
                        <input id="passwordNewC" type="password" name="passwordNewC" class="form-control" placeholder="Repite nueva contraseña"  maxlength="16" />
                    </div>
                    <div id="divPassword_message">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
</div>
