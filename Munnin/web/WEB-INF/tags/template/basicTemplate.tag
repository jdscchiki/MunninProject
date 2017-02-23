<%-- 
    Document   : basicTemplate
    Created on : 22/02/2017, 07:10:28 PM
    Author     : Juan David Segura
--%>

<%@tag description="Template for most of the application" pageEncoding="UTF-8"%>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/template/basicTemplate/"%>
<%@tag import="modelo.bean.Funcionario" %>

<%@attribute name="title" required="true"%>
<%@attribute name="panelTitle" required="true"%>
<%@attribute name="actualPage" required="true" type="Integer"%>
<%@attribute name="actualRole" required="false" type="Integer" %>
<%@attribute name="funcionario" required="true" type="Funcionario"%>

<%@attribute name="aditionalJS" fragment="true" required="false"%>

<!DOCTYPE html>
<html lang="es">
    <head>
    <component:head title="${title}" />
    <component:navbar funcionario="${funcionario}" 
                      actualRole="${actualRole}" 
                      actualPage="${actualPage}"/>
    <component:sidebar funcionario="${funcionario}"
                       activeRole="${actualRole}" />
    <component:modalLogOut />
    <component:modalPassword />
</head>
<body>
    <div id="main" class="contain">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="panelMunnin">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3>${panelTitle}</h3>
                            </div>
                            <div class="panel-body">
                                <jsp:doBody />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<component:footer />
<component:js />
<jsp:invoke fragment="aditionalJS" />
</body>
</html>