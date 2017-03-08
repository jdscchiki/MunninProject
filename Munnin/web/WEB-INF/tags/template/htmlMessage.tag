<%-- 
    Document   : htmlMessage
    Created on : 22/02/2017, 09:59:06 PM
    Author     : Juan David Segura
--%>

<%@tag description="message with html content" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message" fragment="true" required="true"%>
<%@attribute name="type" required="true"%>

<div class="alert alert-${type} alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <jsp:invoke fragment="message" />
</div>
