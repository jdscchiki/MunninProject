<form id="formChangePassword" class="form-horizontal" action="${URIHome}cambioContrasena" method="POST">
    <div id="changePassword" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Cambio de Contraseņa</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordCurrent">Actual:</label>
                        <div class="col-sm-5">
                            <input id="passwordCurrent" type="password" name="passwordCurrent" class="form-control" placeholder="Contraseņa actual" maxlength="16" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordNew">Nueva contraseņa:</label>
                        <div class="col-sm-5">
                            <input id="passwordNew" type="password" name="passwordNew" class="form-control" placeholder="Nueva contraseņa" maxlength="16" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-5" for="passwordNewC">Repetir nueva contraseņa:</label>
                        <div class="col-sm-5">
                            <input id="passwordNewC" type="password" name="passwordNewC" class="form-control" placeholder="Repite nueva contraseņa"  maxlength="16" />
                        </div>
                    </div>
                    <div id="formPassword_message">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Cambiar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </div>

</form>