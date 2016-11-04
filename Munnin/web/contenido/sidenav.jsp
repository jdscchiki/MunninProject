<%@page import="modelo.bean.Rol"%>
<%@page import="modelo.bean.Funcionario"%>
<%@ page language="java" session="false"%>

<div id="sidenav" class="sidenav">
    <div class="item-right-rs">
        <%
            HttpSession s = request.getSession(false);
            Funcionario fun = (Funcionario) s.getAttribute("usuario");
        %>
        <%
            boolean isCoordinador = false;
            boolean isETecnico = false;
            boolean isEPedagogico = false;
            boolean isInstructor = false;
            boolean isAdmin = false;
            for (Rol rol : fun.getRoles()) {
                if (rol.getId() == 1) {
                    isCoordinador = true;
                    break;
                }
                if (rol.getId() == 2) {
                    isETecnico = true;
                    break;
                }
                if (rol.getId() == 3) {
                    isEPedagogico = true;
                    break;
                }
                if (rol.getId() == 4) {
                    isInstructor = true;
                    break;
                }
                if (rol.getId() == 5) {
                    isAdmin = true;
                    break;
                }
            }

            if (isCoordinador) {
        %>
        <div class="item">
            <a class="nice-link" href="coordinador.jsp">
                <span class="glyphicon glyphicon-king"></span>
                Coordinador
            </a>
        </div>
        <%
            }
            if (isETecnico) {
        %>
        <div class="item">
            <a class="nice-link" href="equipo-tecnico.jsp">
                <span class="glyphicon glyphicon-wrench"></span>
                Equipo Tecnico
            </a>
        </div>
        <%
            }
            if (isEPedagogico) {
        %>
        <div class="item">
            <a class="nice-link" href="equipo-pedagogico.jsp">
                <span class="glyphicon glyphicon-blackboard"></span>
                Equipo Pedagógico
            </a>
        </div>
        <%
            }
            if (isInstructor) {
        %>
        <div class="item">
            <a class="nice-link" href="instructor.jsp">
                <span class="glyphicon glyphicon-book"></span>
                Instructor
            </a>
        </div>
        <%
            }
            if (isAdmin) {
        %>
        <div class="item">
            <a class="nice-link" href="administrador.jsp">
                <span class="glyphicon glyphicon-glass"></span>
                Administrador
            </a>
        </div>
        <%
            }
        %>
    </div>
</div>