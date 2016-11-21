<%
    String active = "active";
    String inicio = "";
    String lista = "";
    String pendiente = "";
    
    if (request.getAttribute("mainPage") == null) {
        inicio = active;
    } else {
        switch ((Integer) request.getAttribute("mainPage")) {
            case 1:
                inicio = active;
                break;
            case 2:
                lista = active;
                break;
            case 3:
                pendiente = active;
                break;
            default:
                inicio = active;
                break;
        }
    }
%>
<li class="<%=inicio%>"><a href="<%=request.getContextPath()%>/roles/tecnico/inicio.jsp" class="btn">Notificaciones</a></li>
<li class="<%=lista%>"><a href="#" class="btn">Listas de Chequeo</a></li>
<li class="<%=pendiente%>"><a href="#" class="btn">Pendientes</a></li>
