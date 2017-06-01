<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables/" %>
<div id="disabledFunctionary" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Funcionarios inhabilitados</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <tables:dataTableSearch id="formSearchFunctionaryDisable"
                                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/search-disabled"
                                                placeholder="Buscar funcionario"
                                                display="showDisabledFunctionaryTable"
                                                width="6"/>
                    </div>
                    <div class="col-lg-12">
                        <div id="showDisabledFunctionaryTable"></div>
                    </div>
                    <div id="showDisabledFunctionaryMessage" class="col-lg-offset-1 col-lg-10"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" 
                        class="btn btn-success" 
                        data-panel-table="formEnableFunctionary"
                        data-action="">
                    Habilitar</button>
                <button class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
    <tables:dataTableSelectForm id="formEnableFunctionary"
                                dataTable="tableBodyFunctionariesDisabled"
                                display="showDisabledFunctionaryMessage"
                                urlServlet="${pageContext.request.contextPath}/home/role/coordinator/functionary/enable" />
    <script type="text/javascript">
        $(document).ready(function () {
            $("#disabledFunctionary").modal();
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/functionary/search-disabled", "showDisabledFunctionaryTable");
            $(document).on("hidden.bs.modal", "#disabledFunctionary", function (event) {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/functionary/search", "fulltable");
                $(this).remove();
            });
        });
    </script>
</div>