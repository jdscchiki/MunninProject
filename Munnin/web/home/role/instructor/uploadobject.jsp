<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="2"
                        actualRole="5"
                        funcionario="${sessionScope.usuario}"
                        title="Carga Objeto Instructor Munnin"
                        panelTitle="Cargar un nuevo objeto de aprendizaje">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/inputFile.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/keywordHandler.js" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-offset-2 col-sm-10" id="message_uploadobject">
                </div>
                <form class="form-horizontal"
                      enctype="multipart/form-data"
                      method="POST"
                      action="${pageContext.request.contextPath}/home/role/instructor/uploadobject/upload"
                      data-ajax-form="true"
                      data-display="message_uploadobject">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectName">Nombre del archivo</label>
                        <div class="col-sm-10">
                            <input type="text" 
                                   class="form-control" 
                                   name="objectName" 
                                   id="objectName" 
                                   placeholder="Nombre del objeto de aprendizaje">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectDescription">Descripción</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" 
                                      name="objectDescription" 
                                      id="objectDescription" 
                                      rows="3"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectKeyword">Palabras clave</label>
                        <div class="col-sm-10">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="tagcloud" data-bind-input="keywordFF">
                                        <ul>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control keyword" id="keyword" data-bind-input="keywordFF" placeholder="Ingresar palabra clave">
                                    <input type="hidden" id="keywordFF" name="objectKeyword" class="keywordhidden">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectType">Tipo de objeto</label>
                        <div class="col-sm-3">
                            <select class="form-control" 
                                    name="objectType"
                                    id="objectType">
                                <c:forEach items="${objectTypes}" var="objectType">
                                    <option value="${objectType.getId()}">${objectType.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectFile">Archivo</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <label class="input-group-btn">
                                    <span class="btn btn-default">
                                        Buscar&hellip; <input type="file" 
                                                              style="display: none;" 
                                                              name="objectFile" 
                                                              id="objectFile" 
                                                              required="required">
                                    </span>
                                </label>
                                <input type="text" class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-sm-4">
                            <button type="submit" class="btn btn-success">
                                Enviar
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </jsp:body>
</template:basicTemplate>