<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
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
                        <tables:dataTableSearch id="formSearchCategoriesEnable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/categories/search-disabled"
                                                placeholder="Buscar categoria"
                                                display="showDisabledCategoriesTable"
                                                width="6"/>
                    </div>
                    <div class="col-lg-12">
                        <div id="showDisabledCategoriesTable"></div>
                    </div>
                    <div id="showDisabledCategoriesMessage" class="col-lg-offset-1 col-lg-10"></div>
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
    <tables:dataTableSelectForm id="formEnableCategories"
                                dataTable="tableBodyCategoriesDisabled"
                                display="showDisabledCategoriesMessage"
                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/categories/enable" />
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
