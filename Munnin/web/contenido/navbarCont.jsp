<%
    String active = "active";
    String inicio = "";
    String buscar = "";
    String manual = "";
    String contactenos = "";
    
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
                manual = active;
                break;
            case 4:
                contactenos = active;
                break;
            default:
                inicio = active;
                break;
        }
    }
%>
<li class="<%=inicio%>"><a href="inicio.jsp" class="btn">Inicio</a></li>
<li class="<%=buscar%>"><a href="#" class="btn">Buscar</a></li>
<li class="<%=manual%>"><a href="#" class="btn">Manual</a></li>
<li class="<%=contactenos%>"><a href="#" class="btn">Contactenos</a></li>