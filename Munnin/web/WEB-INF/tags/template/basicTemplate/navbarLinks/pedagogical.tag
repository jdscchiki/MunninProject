<%-- 
    Document   : coordinator
    Created on : 22/02/2017, 10:15:42 PM
    Author     : Juan David Segura
--%>

<%@tag description="Links for pedagogical team role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/pedagogical/intro.jsp" class="btn">Notificaciones</a></li>
<li ${actualPage==2 ? "class='active'":""}><a  class="btn">Listas de Chequeo</a></li>
<li ${actualPage==3 ? "class='active'":""}><a  class="btn">Pendientes</a></li>