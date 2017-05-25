<%@tag description="Links for coordinator role" pageEncoding="UTF-8"%>

<%@attribute name="actualPage" required="true"%>

<li ${actualPage==1 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/intro.jsp">Notificaciones</a></li>
<li ${actualPage==2 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/reports.jsp" >Reportes</a></li>
<li ${actualPage==3 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/functionary.jsp" >Funcionarios</a></li>
<li ${actualPage==4 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/categories.jsp" >Categorias</a></li>
<li ${actualPage==5 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/area.jsp" >Áreas</a></li>
<li ${actualPage==6 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/programs.jsp" >Programas</a></li>
<li ${actualPage==7 ? "class='active'":""}><a href="${pageContext.request.contextPath}/home/role/coordinator/files.jsp" >Autorizar</a></li>