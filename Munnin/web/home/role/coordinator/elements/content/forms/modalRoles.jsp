<form id="formAssignRole" class="form-horizontal" role="form" method="POST" action="${URICoordinator}assign-roles">
    <div id="assignRole" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Administrar roles de los funcionarios</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="roles" class="control-label col-lg-3">Roles :</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="documento" name="documento" placeholder="Documento" maxlength="12">
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="formAssignRole_message" class="col-lg-offset-3 col-lg-8">
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>

        </div>
    </div>
</form>