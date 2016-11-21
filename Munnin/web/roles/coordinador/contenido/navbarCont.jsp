<%
    String active = "active";
    String inicio = "";
    String reportes = "";
    String funcionarios = "";
    String categorias = "";
    String areas = "";
    if (request.getAttribute("mainPage") == null) {
        inicio = active;
    } else {
        switch ((Integer) request.getAttribute("mainPage")) {
            case 1:
                inicio = active;
                break;
            case 2:
                reportes = active;
                break;
            case 3:
                funcionarios = active;
                break;
            case 4:
                categorias = active;
                break;
            case 5:
                areas = active;
                break;
            default:
                inicio = active;
                break;
        }
    }
%>
<li class="<%=inicio%>"><a href="<%=request.getContextPath()%>/roles/coordinador/inicio.jsp" class="btn">Notificaciones</a></li>
<li class="<%=reportes%>"><a href="#" class="btn">Reportes</a></li>
<li class="<%=funcionarios%>"><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp" class="btn">Funcionarios</a></li>
<li class="<%=categorias%>"><a href="#" class="btn">Categorias</a></li>
<li class="<%=areas%>"><a href="#" class="btn">Areas</a></li>
