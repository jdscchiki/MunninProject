<%
    String active = "active";
    String inicio = "";
    String buscar = "";
    String material = "";
    
    if (request.getAttribute("mainPage") == null) {
        inicio = active;
    } else {
        switch ((Integer) request.getAttribute("mainPage")) {
            case 1:
                inicio = active;
                break;
            case 2:
                buscar = active;
                break;
            case 3:
                material = active;
                break;
            default:
                inicio = active;
                break;
        }
    }
%>
<li class="<%=inicio%>"><a href="<%=request.getContextPath()%>/roles/instructor/inicio.jsp" class="btn">Notificaciones</a></li>
<li class="<%=buscar%>"><a href="#" class="btn">Buscar</a></li>
<li class="<%=material%>"><a href="#" class="btn">Mi material</a></li>