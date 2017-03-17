<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div id="assignRole" class="modal fade" role="dialog">
    <form id="formAssignRole" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/coordinator/functionary/assign-roles"
          data-data-table="tableBodyFunctionaries"
          data-display="formAssignRole_message">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Administrar roles del funcionario</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-lg-3">Funcionario :</label>
                        <div class="col-lg-4">
                            <p class="form-control-static">
                                ${funcionario.getNombre()} ${funcionario.getApellido()}
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3">Roles :</label>
                        <div class="col-lg-4">
                            <input type="hidden" name="id" value="${funcionario.getId()}">
                            <c:forEach items="${roles}" var="rol">
                                <c:set var="selectedRol" value="false" scope="request"/>
                                <c:forEach items="${funcionario.getRoles()}" var="rolF">
                                    <c:if test="${rol.getId()==rolF.getId()}" >
                                        <c:set var="selectedRol" value="true" scope="request"/>
                                    </c:if>
                                </c:forEach>
                                <div class="checkbox">
                                    <label><input type="checkbox" 
                                                  name="role" 
                                                  value="${rol.getId()}" 
                                                  ${selectedRol?"checked":""}>
                                        ${rol.getNombre()}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="formAssignRole_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" data-action="" data-panel-table="formAssignRole">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#assignRole").modal();
            $(document).on("hidden.bs.modal", "#assignRole", function (event) {
                $(this).remove();
            });
        });
    </script>

</div>