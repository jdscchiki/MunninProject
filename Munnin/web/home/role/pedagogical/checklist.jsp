<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="2"
                        actualRole="4"
                        funcionario="${sessionScope.usuario}"
                        title="Listas de chequeo E. Pedagógico Munnin"
                        panelTitle="Listas de Chequeo">
    <jsp:body>
        <div class="row">
            <div class="col-md-12"> 
                <form action="" method="POST">
                    <div class="container-checklist">
                        <div id="myDIV" class="header">
                            <h2 style="margin:5px">Lista de chekeo</h2>
                            <input type="text" id="myInput" placeholder="Nuevo Item...">
                            <span onclick="newElement()" class="addBtn">Agregar</span>
                        </div>
                        <ul id="myUL">
                            <li class="cl"><input type="text" name="itemchecklist" value="Este es un ejemplo de un item en la lista de chequeo" disabled="disabled"></li>

                        </ul>
                        <br>
                        <button type="submit" class="btn btn-success">Enviar Lista</button>
                </form>
                    </div>
            </div>
        </div>
</jsp:body>

</template:basicTemplate>
