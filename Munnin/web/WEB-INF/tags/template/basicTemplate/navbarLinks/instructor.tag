<%@tag description="Links for instructor role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/instructor/intro.jsp" >Notificaciones</a></li>
<li ${actualPage==2 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/instructor/uploadobject.jsp" >Nuevo Objeto</a></li>
<li ${actualPage==3 ? "class='active'":""}><a  >Buscar</a></li>
<li ${actualPage==4 ? "class='active'":""}><a  >Mi material</a></li>