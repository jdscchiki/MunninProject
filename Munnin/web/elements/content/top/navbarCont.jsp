<%--
    1- INICIO
    2- ADMINISTRADOR
    3- COORDINADOR
    4- INSTRUCTOR
    5- PEDAGOGICO
    6- TECNICO
--%>
<%
    int menuNavbar = 1;
    try{
        menuNavbar = (Integer)request.getAttribute("navbar");
    }catch(Exception e){
        
    }
    
    switch (menuNavbar) {
        case 1:
%>
<%--
    menu de inicio
--%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URIHome}inicio.jsp" class="btn">Inicio</a></li>
<li ${mainPage==2 ? "class='active'":""}><a  class="btn">Buscar</a></li>
<li ${mainPage==3 ? "class='active'":""}><a  class="btn">Manual</a></li>
<li ${mainPage==4 ? "class='active'":""}><a  class="btn">Contactenos</a></li>
    <%
            break;
        case 2:
    %>

<%--
    menu administrador
--%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URIAdministrator}inicio.jsp" class="btn">Inicio</a></li>
    <%
            break;
        case 3:
    %>
    <%--
        menu coordinador
    --%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URICoordinator}inicio.jsp" class="btn">Notificaciones</a></li>
<li ${mainPage==2 ? "class='active'":""}><a  class="btn">Reportes</a></li>
<li ${mainPage==3 ? "class='active'":""}><a href="${URICoordinator}funcionarios.jsp" class="btn">Funcionarios</a></li>
<li ${mainPage==4 ? "class='active'":""}><a  class="btn">Categorias</a></li>
<li ${mainPage==5 ? "class='active'":""}><a  class="btn">Areas</a></li>
    <%
            break;
        case 4:
    %>
    <%--    
        menu instructor
    --%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URIInstructor}inicio.jsp" class="btn">Notificaciones</a></li>
<li ${mainPage==2 ? "class='active'":""}><a  class="btn">Buscar</a></li>
<li ${mainPage==3 ? "class='active'":""}><a  class="btn">Mi material</a></li>
    <%
            break;
        case 5:
    %>
    <%--
        menu equipo pedagogico
    --%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URIPedagogical}inicio.jsp" class="btn">Notificaciones</a></li>
<li ${mainPage==2 ? "class='active'":""}><a  class="btn">Listas de Chequeo</a></li>
<li ${mainPage==3 ? "class='active'":""}><a  class="btn">Pendientes</a></li>
    <%
            break;
        case 6:
    %>
    <%--
        menu equipo tecnico
    --%>
<li ${mainPage==1 ? "class='active'":""}><a href="${URITechnical}inicio.jsp" class="btn">Notificaciones</a></li>
<li ${mainPage==2 ? "class='active'":""}><a  class="btn">Listas de Chequeo</a></li>
<li ${mainPage==3 ? "class='active'":""}><a  class="btn">Pendientes</a></li>

<%
            break;
    }
%>