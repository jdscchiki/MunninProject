<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<div class="modal fade" id="modalListP" role="dialog">
    <div class="modal-dialog modal-lg">
        <form id="formCreateList"  
          role="form" 
          method="POST" 
          action="${pageContext.request.contextPath}/home/role/pedagogical/list/create"
          data-display="vacio"
          data-data-table="tableBodyList"
          data-ajax-form="true">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="modal-title">Crear nueva lista de chequeo</h3>
            </div>
            <div class="modal-body">
                <div class="container-checklist">
                    <div id="myDIV" class="header">
                        <h4 class="nomLista">Nombre de la lista: </h4>
                        <input type="text" name="title" id="titlelist" placeholder="Aqui Nombre de la Lista..." maxlength="40">
                        <h4 class="nomLista">Decripcion: </h4>
                        <textarea name="description" class="description" rows="5" id="comment" placeholder="Aqui una breve descripcion de su lista..." minlength="1" maxlength="254"></textarea>
                        <input type="text" id="myInput" placeholder="Nuevo Item..." maxlength="100" class="IngresarItem">
                        <span onclick="newElement()" class="addBtn">Agregar</span>
                    </div>
                    <ul id="myUL">
                        <li class="cl"><input type="text" name="itemchecklist" value="Este es un ejemplo de un item en la lista de chequeo, no se agregara como item aun asi puede borrarlo" disabled="disabled"></li>
                    </ul>
                    <br>
                    <div id="vacio"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-munnin">Guardar Lista</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
        </form>
    </div>
</div>
