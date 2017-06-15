<%-- 
    Document   : basicTemplate
    Created on : 22/02/2017, 07:10:28 PM
    Author     : Juan David Segura
--%>

<%@tag description="Template for most of the application" pageEncoding="UTF-8"%>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/template/basicTemplate/"%>
<%@tag import="model.bean.Funcionario" %>

<%@attribute name="title" 
             required="true"
             description="The title of the page in the browser tab"%>
<%@attribute name="panelTitle" 
             required="true"
             description="The title of the page in the panel header"%>
<%@attribute name="actualPage" 
             required="true" 
             type="Integer" 
             description="Integer of the page selected in navbar"%>
<%@attribute name="actualRole" 
             required="true" 
             type="Integer" 
             description="Integer of the selected roles in sidenav"%>
<%@attribute name="funcionario" 
             required="true" 
             type="Funcionario"
             description="Logged in user"%>

<%@attribute name="additionalJS" 
             fragment="true" 
             required="false"
             description="space to add JavaScript import or code"%>

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
    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <div id="main" class="contain">
            <div class="container">
                <div class="row">
                    <div class="col-md-12"> 
                        <div class="panelMunnin">
                            <h3>${panelTitle}</h3>
                            <hr>
                            <jsp:doBody />
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--aqui preloader-->
        <component:footer />
        <component:js />
        <jsp:invoke fragment="additionalJS" />
    </body>
</html>