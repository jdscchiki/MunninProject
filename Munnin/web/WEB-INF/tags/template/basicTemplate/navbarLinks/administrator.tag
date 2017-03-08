<%@tag description="Links for administrator role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/administraror/intro.jsp" >Notificaciones</a></li>