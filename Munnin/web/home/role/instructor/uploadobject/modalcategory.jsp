<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalInstructorSelectCategory" 
     class="modal fade" 
     role="dialog">
    <form id="formInstructorSelectCategory" 
          class="form-horizontal" 
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/instructor/uploadobject/addcategories"
          data-ajax-form="true"
          data-display="message_uploadobject">
        <input type="hidden" name="learningObject" value="${learningObject}">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Agregar categorias al objeto de aprendizaje</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div id="divRegisterFunctionary_message" class="col-lg-offset-3 col-lg-9">
                            <c:if test="${message != null}">
                                <template:message message="${message}" type="${messageType}" />
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="formInstructorSelectCategoryInputCategory" 
                               class="control-label col-lg-3">
                            Categorias:</label>
                        <div class="col-lg-5">
                            <select multiple 
                                    class="form-control" 
                                    id="formInstructorSelectCategoryInputCategory"
                                    name="categories">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.getId()}">${category.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" 
                            class="btn btn-success">
                        Guardar</button>
                    <button type="button" 
                            class="btn btn-default" 
                            data-dismiss="modal">
                        Cerrar</button>
                </div>
            </div>

        </div>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#modalInstructorSelectCategory").modal();
            $(document).on("hidden.bs.modal", "#modalInstructorSelectCategory", function (event) {
                $(this).remove();
            });
        });
    </script>
</div>