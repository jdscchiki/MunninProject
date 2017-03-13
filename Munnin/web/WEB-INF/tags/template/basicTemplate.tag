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
            <div class="container-fluid">
                <div class="jumbotron">
                    <h1>${panelTitle}</h1>      
                </div>
                <div class="row">
                    <div class="col-md-9"> 
                        <div class="panelMunnin">
                            <jsp:doBody />
                        </div>
                    </div>
                    <div class="col-md-3"> 
                        <div class="panelMunnin">
                            <div class="media">
                                <div class="media-left media-middle">
                                    <img src="${pageContext.request.contextPath}/resources/img/img_avatar2.png" class="media-object" style="width:60px">
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">Media Middle</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                </div>
                            </div>
                            <hr>
                            <div class="media">
                                <div class="media-left media-middle">
                                    <img src="${pageContext.request.contextPath}/resources/img/img_avatar2.png" class="media-object" style="width:60px">
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">Media Middle</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="leftS">
            <nav class="menu">
                <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open"/>
                <label class="menu-open-button" for="menu-open">
                    <span class="hamburger hamburger-1"></span>
                    <span class="hamburger hamburger-2"></span>
                    <span class="hamburger hamburger-3"></span>
                </label>
                <a href="#" class="menu-item"> <span class="fa fa-star glyphicon"></span></a>
                <a href="#" class="menu-item"> <img src="${pageContext.request.contextPath}/resources/img/coord.png" alt="_icono" class="glyphicon"></a>
                <a href="#" class="menu-item"> <img src="${pageContext.request.contextPath}/resources/img/eTecnico.png" alt="_icono" class="glyphicon"></a>
                <a href="#" class="menu-item"> <img src="${pageContext.request.contextPath}/resources/img/ePedagogico.png" alt="_icono" class="glyphicon"></a>
                <a href="#" class="menu-item"> <span class="fa fa-user-circle glyphicon"></a>
                <a href="#" class="menu-item"> <i class="fa fa-ellipsis-h"></i></a>
            </nav>
        </div>                        
        <!--aqui preloader-->
        <component:footer />
        <component:js />
        <jsp:invoke fragment="additionalJS" />
    </body>
</html>