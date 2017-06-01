<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tables" tagdir="/WEB-INF/tags/template/basicTemplate/tables" %>
<%@page import="java.util.ArrayList"%>
<div id="checkList" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Listas de Chequeo</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <tables:dataTableSearch id="formCheckList"
                                                urlServlet="${pageContext.request.contextPath}/home/role/pedagogical/check/search-checklist"
                                                placeholder="Buscar lista"
                                                display="showCheckList"
                                                width="6"/>
                    </div>
                    <div class="col-lg-12">
                        <div id="showCheckList"></div>
                    </div>
                    <div id="showDisabledAreaMessage" class="col-lg-offset-1 col-lg-10"></div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/home/download?idVersion=${version.getId()}" 
                   class="btn btn-primary pull-left"
                   target="_blank">
                    descargar
                </a>
                <button type="button" 
                        class="btn btn-success" 
                        data-panel-table="formActionItemEnable"
                        data-action="">
                    Siguiente</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
    <form id="formActionItemEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/pedagogical/check/select-list"
              data-display="message_file"
              data-ajax-form="true"
              data-data-table="tableBodyCheckListPedagogical">
            <input type="hidden" name="idVersion" value="${version.getId()}">
            <input type="hidden" name="id" value="-1" data-selected-item="">
        </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#checkList").modal();
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/pedagogical/check/search-checklist", "showCheckList");
            $(document).on("hidden.bs.modal", "#checkList", function (event) {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/pedagogical/check/search", "fulltable");
                $(this).remove();
            });
            $("#checkList").modal();
            $(document).on("hidden.bs.modal", "#checkList", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>