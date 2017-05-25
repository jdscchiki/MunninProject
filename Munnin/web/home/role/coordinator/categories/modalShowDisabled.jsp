<%-- 
    Document   : modalShowDisableCategories
    Created on : 25/03/2017, 12:38:32 PM
    Author     : Monica
--%>

<div id="disabledCategories" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Categorias inhabilitadas</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <form id="formSearchCategoriesEnable" 
                              class="form-horizontal" 
                              method="POST" 
                              action="${pageContext.request.contextPath}/home/role/coordinator/categories/search-disabled"
                              data-ajax-form="true"
                              data-display="showDisabledCategoriesTable">
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                                <div class="col-sm-5">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Buscar categoria" id="searchMunnin" name="search">
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
                        <div id="showDisabledCategoriesTable">

                        </div>
                    </div>

                    <div id="showDisabledCategoriesMessage" class="col-lg-offset-1 col-lg-10">

                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" 
                        class="btn btn-success" 
                        data-panel-table="formEnableCategories"
                        data-action="">
                    Habilitar</button>
                <button class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
    <form id="formEnableCategories"
          method="POST"
          action="${pageContext.request.contextPath}/home/role/coordinator/categories/enable"
          data-display="showDisabledCategoriesMessage"
          data-data-table="tableBodyCategoriesDisabled">
        <input type="hidden" name="id" value="-1" data-selected-item="">
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#disabledCategories").modal();
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/categories/search-disabled", "showDisabledCategoriesTable");
            $(document).on("hidden.bs.modal", "#disabledCategories", function (event) {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/categories/search", "fulltable");
                $(this).remove();
            });
        });
    </script>
</div>
