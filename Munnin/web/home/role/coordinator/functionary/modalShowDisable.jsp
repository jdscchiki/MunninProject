<div id="disabledFunctionary" class="modal fade" role="dialog">
    <form id="formDisabledFunctionary" class="form-horizontal" role="form" method="POST" action="${URICoordinator}refresh-disabled-functionary">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Funcionarios inhabilitados</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="search">Buscar:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Buscar" name="search" id="search">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="showDisabledFunctionary_Table">

                        </div>
                    </div>
                    <div class="form-group">
                        <div id="showDisabledFunctionary_message" class="col-lg-offset-1 col-lg-10">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" id="enable-functionary" >habilitar</button>
                    <button class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </form>
</div>