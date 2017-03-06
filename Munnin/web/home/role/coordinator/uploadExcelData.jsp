<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="2"
                        actualRole="5"
                        funcionario="${sessionScope.usuario}"
                        title="Carga Mavisa Coordinador Munnin"
                        panelTitle="Carga Masiva de Datos">
    <jsp:attribute name="additionalJS">
        <script src="${pageContext.request.contextPath}/resources/js/ajaxMunnin.js" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <form class="form-horizontal"
                      enctype="multipart/form-data"
                      method="POST"
                      action="${pageContext.request.contextPath}/home/role/coordinator/uploadExcelData/uploadData"
                      data-ajax-form="true"
                      data-display="message_uploadobject">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="objectFile">Archivo</label>
                        <div class="col-sm-10">
                            <input type="file" 
                                   name="objectFile" 
                                   id="objectFile" 
                                   class="form-control" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-sm-10" id="message_uploadobject">
                        </div>
                        <div class="col-lg-offset-2 col-sm-10" id="message_uploadobject2">
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