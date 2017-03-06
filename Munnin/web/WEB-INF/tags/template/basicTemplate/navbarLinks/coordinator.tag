<%-- 
    Document   : coordinator
    Created on : 22/02/2017, 10:15:42 PM
    Author     : Juan David Segura
--%>

<%@tag description="Links for coordinator role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/intro.jsp" class="btn">Notificaciones</a></li>
<li ${actualPage==2 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/reports.jsp" class="btn">Reportes</a></li>
<li ${actualPage==3 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/functionary.jsp" class="btn">Funcionarios</a></li>
<li ${actualPage==4 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/categories.jsp" class="btn">Categorias</a></li>
<li ${actualPage==5 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/areas.jsp" class="btn">Areas</a></li>