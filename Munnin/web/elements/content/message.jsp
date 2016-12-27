<%--
Casos:
    default. Peligro(error)
    1. Exito
    2. Informacion
    3. Alerta
--%>
<%
    int caseMessage = (Integer) request.getAttribute("caseMessage");
    String message = (String) request.getAttribute("message");
    switch (caseMessage) {
        case 1:
%>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Exito!</strong> <%=message%>
</div>
<%
        break;
    case 2:
%>
<div class="alert alert-info alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <%=message%>
</div>
<%
        break;
    case 3:
%>
<div class="alert alert-warning alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <%=message%>
</div>
<%
        break;
    case 0:
    default:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> <%=message%>
</div>
<%
            break;
    }
%>