<%@tag description="tag used to present information to administrate" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@tag import="java.util.ArrayList"%>

<%@attribute name="thead" 
             fragment="true" 
             required="true"
             description="titles of the table content"%>
<%@attribute name="tbody" 
             fragment="true" 
             required="true"
             description="titles of the table content"%>
<%@attribute name="idTable" required="true"%>
<%@attribute name="displayResult" required="true"%>
<%@attribute name="actionDisplay" required="true"%>
<%@attribute name="actionUrl" required="true"%>
<%@attribute name="lastSearch" required="true"%>
<%@attribute name="page" required="true"%>
<%@attribute name="urlServlet" required="true"%>
<%@attribute name="pages" required="true" type="ArrayList<Integer>"%>

<div class="table-responsive">
    <table class="table table-hover">
        <thead>
            <tr>
                <jsp:invoke fragment="thead" />
            </tr>
        </thead>
        <tbody id="${idTable}"
               data-action-multiple="false"
               data-action-display="${actionDisplay}"
               data-action-url-servlet="${actionUrl}"
               data-display="${displayResult}"
               data-actual-state="${lastSearch}page=${page}"
               data-url-receiver="${urlServlet}">
            <jsp:invoke fragment="tbody" />
        </tbody>
    </table>
</div>
<template:paginate actualPage="${page}"
                   pages="${pages}"
                   search="${lastSearch}"
                   servlet="${urlServlet}"
                   displayResult="${displayResult}" />