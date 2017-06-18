<div id="disabledPrograms" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Programas inhabilitados</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <form id="formSearchProgramDisable" 
                              class="form-horizontal" 
                              method="POST" 
                              action="${pageContext.request.contextPath}/home/role/coordinator/programs/search-disabled"
                              data-ajax-form="true"
                              data-display="showDisabledProgramsTable">
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="searchMunninDisabledPrograms">Buscar:</label>
                                <div class="col-sm-5">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Buscar programa" id="searchMunninDisabledPrograms" name="search">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit">
                                                <i class="glyphicon glyphicon-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="col-lg-12">
                        <div id="showDisabledProgramsTable">

                        </div>
                    </div>

                    <div id="showDisabledProgramsMessage" class="col-lg-offset-1 col-lg-10">

                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" 
                        class="btn btn-success" 
                        data-panel-table="formEnableProgram"
                        data-action="">
                    Habilitar</button>
                <button class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
    <form id="formEnableProgram"
          method="POST"
          action="${pageContext.request.contextPath}/home/role/coordinator/programs/enable"
          data-display="showDisabledProgramsMessage"
          data-data-table="tableBodyProgramsDisabled">
        <input type="hidden" name="id" value="-1" data-selected-item="">
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#disabledPrograms").modal();
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/programs/search-disabled", "showDisabledProgramsTable");
            $(document).on("hidden.bs.modal", "#disabledPrograms", function (event) {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/programs/search", "fulltable");
                $(this).remove();
            });
        });
    </script>
</div>