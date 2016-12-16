<form id="formChangeRole" class="form-horizontal" role="form" method="POST" action="${URICoordinator}">
    <div id="changeRole" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Administrar roles de los funcionarios</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="documento" class="control-label col-lg-3">Documento :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="documento" name="documento" placeholder="Documento" maxlength="12">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="formChangeRole_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Registrar Funcionario</button>
                    <button type="reset" class="btn btn-danger">Borrar datos del formulario</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </div>
</form>