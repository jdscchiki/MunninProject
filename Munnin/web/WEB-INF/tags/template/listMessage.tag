<%-- 
    Document   : listMessage
    Created on : 22/02/2017, 10:03:39 PM
    Author     : Juan David Segura
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag import="java.util.ArrayList"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="messages" required="true" type="ArrayList"%>
<%@attribute name="type" required="true"%>

<div class="alert alert-${type} alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <c:forEach items="${messages}" var="message">
      <ul>
          <li>
              ${message}
          </li>
      </ul>
  </c:forEach>
</div>