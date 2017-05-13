<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <form id="formCheckList" 
                              class="form-horizontal" 
                              method="POST" 
                              action="${pageContext.request.contextPath}/home/role/technical/files/search-checkList"
                              data-ajax-form="true"
                              data-display="showCheckList">                                                        
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="searchMunnin">Buscar:</label>
                                <div class="col-sm-5">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Buscar lista" id="searchMunnin" name="search">
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
                        <div id="showCheckList">

                        </div>
                    </div>

                    <div id="showDisabledAreaMessage" class="col-lg-offset-1 col-lg-10">

                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" 
                        class="btn btn-success" 
                        data-panel-table="formActionItemEnable"
                        data-action="items">
                    Siguiente</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
    <form id="formActionItemEnable"
              method="POST"
              action="${pageContext.request.contextPath}/home/role/technical/files/manage-lista"
              data-display="message_file"
              data-ajax-form="true"
              data-data-table="tableBodyCheckList">
            <input type="hidden" name="idVersion" value="${version.getId()}">
            <input type="hidden" name="id" value="-1" data-selected-item="">
            <input type="hidden" name="action" data-action="">
        </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#checkList").modal();
            ajaxLoadContent("${pageContext.request.contextPath}/home/role/technical/files/search-checkList", "showCheckList");
            $(document).on("hidden.bs.modal", "#checkList", function (event) {
                ajaxLoadContent("${pageContext.request.contextPath}/home/role/coordinator/pagerFile", "fulltable");
                $(this).remove();
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#checkList").modal();
            $(document).on("hidden.bs.modal", "#checkList", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>