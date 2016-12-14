<%--
Casos:
    default. fallo
    1. exito
    2. fallo
    3. indice sin seleccionar
    4. registro - exito
    5. registro - inconsistencia de datos
--%>
<%
    int caseMessage = (Integer) request.getAttribute("message");
    switch (caseMessage) {
        case 1:
%>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Exito!</strong> se ha completado la acción
</div>
<%
        break;
    case 2:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> no se ha completado la acción
</div>
<%
        break;
    case 3:
%>
<div class="alert alert-warning alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    Para realizar la operación es necesario seleccionar uno de los funcionarios
</div>
<%
        break;
    case 4:
%>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Exito!</strong> se ha registrado satisfactoriamente al usuario
</div>
<%
        break;
    case 5:
%>
<div class="alert alert-warning alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Error!</strong> ha ocurrido un problema, pro favor vuelva a cargar la pagina
</div>
<%
        break;
    default:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> no se ha completado la acción
</div>
<%
            break;
    }
%>