<%@tag description="Links for coordinator role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/intro.jsp">Inicio</a></li>
<li ${actualPage==2 ? "class='active'":""}><a>Buscar</a></li>
<li ${actualPage==3 ? "class='active'":""}><a>Manual</a></li>
<li ${actualPage==4 ? "class='active'":""}><a>Contactenos</a></li>