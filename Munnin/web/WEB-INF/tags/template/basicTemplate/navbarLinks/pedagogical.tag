<%@tag description="Links for pedagogical team role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/pedagogical/intro.jsp">Notificaciones</a></li>
<li ${actualPage==2 ? "class='active'":""}><a>Listas de Chequeo</a></li>
<li ${actualPage==3 ? "class='active'":""}><a>Pendientes</a></li>