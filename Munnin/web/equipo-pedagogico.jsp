<%-- 
    Document   : equipo-pedagogico
    Created on : 4/11/2016, 01:41:48 AM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>

<!DOCTYPE html>
<html lang="">
    <head>
        <title>Munnin</title>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/prueba1.css">
        <script type="text/javascript" src="js/prueba1.js" ></script>
    </head>
    <body>
        <jsp:include page="contenido/sidenav.jsp"></jsp:include>
        <div class="right">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="inicio.jsp">Munnin</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a data-toggle="tab" href="#home">Inicio</a></li>
                            <li><a data-toggle="tab" href="#menu1">Listas de chequeo</a></li>
                        </ul>
                        <jsp:include page="contenido/navbar.jsp"></jsp:include>
                    </div>
                </div>
            </nav>
            <div class="container-fluid">
                <div class="tab-content">
                    <div id="home" class="tab-pane fade in active">
                        <h3>Inicio</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                    <div id="menu1" class="tab-pane fade">
                        <h3>Listas de chequeo</h3>
                        <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                </div>
            </div>
            <footer class="text-center">
                copyright 2016
            </footer>
        </div>
    </body>
</html>