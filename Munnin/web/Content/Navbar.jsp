<%-- 
    Document   : Navbar
    Created on : 30/10/2016, 07:05:10 PM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="#vtn1" class="btn" data-toggle="modal">Material de Apoyo </a></li>
                <li><a href="#vtn2" class="btn" data-toggle="modal">listas de chequeo </a></li>
                <li><a href="#vtn3" class="btn" data-toggle="modal">buscar </a></li>
                <li><a href="#vtn4" class="btn" data-toggle="modal">agregar usuario</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><input type="text" name="search" class="search" placeholder="Buscar..."></li>
                <li><a href="#" data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Imagen</a></li>
                <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
            </ul>
        </div>
    </div>
</nav>