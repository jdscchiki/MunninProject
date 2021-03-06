<%-- 
    Document   : head
    Created on : 22/02/2017, 07:50:52 PM
    Author     : Juan David Segura
--%>

<%@tag description="head of basic template" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/template/ba"%>

<title>${title}</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/logo.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/skin-start.css">