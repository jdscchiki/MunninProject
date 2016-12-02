<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title><%=request.getAttribute("title")%></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <base href="${pageContext.request.contextPath}/">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/logo.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/skin-start.css">
        <% if (request.getAttribute("aditionalCSS") != null) { %>
        ${aditionalCSS}
        <% }%>
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <!--navbar-->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 1px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
                        <div id="navbar-button" class="container" onclick="myFunction(this)" style="">
                            <div class="bar1"></div>
                            <div class="bar2"></div>
                            <div class="bar3"></div>
                        </div>
                    </button>
                    <a class="navbar-brand" href="inicio.jsp">Munnin</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
