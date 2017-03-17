<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="hintExcel" class="modal fade" role="dialog">
    <form id="hintExcel" class="form-horizontal" role="form" method="POST" data-ajax-form="true"
                      data-display="message_areas">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title">Ayuda</h3>
                </div>
                <div class="modal-body">
                    <h4>Organizar los datos de la siguiente manera</h4>
                        <img src="${pageContext.request.contextPath}/resources/img/excel.png" alt=""/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>

        </div>
    </form>
</div>