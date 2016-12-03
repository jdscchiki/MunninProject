<%
    String active = "active";
    String inicio = "";
    
    if (request.getAttribute("mainPage") == null) {
        inicio = active;
    } else {
        switch ((Integer) request.getAttribute("mainPage")) {
            case 1:
                inicio = active;
                break;
            default:
                inicio = active;
                break;
        }
    }
%>
<li class="<%=inicio%>"><a href="<%=request.getContextPath()%>/roles/administrador/inicio.jsp" class="btn">Inicio</a></li>