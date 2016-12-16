<%--
Casos:
    default. fallo
    1. exito
    2. fallo
    3. indice sin seleccionar
    4. registro - fallo
    5. registro - exito
    6. registro - fallo - existe un usuario activo con los datos ingresados
    7. registro - fallo - existe un usuario no-activo con el mismo correo
    8. registro - fallo - existe un usuario no-activo con el mismo documento
    9. registro - fallo - el correo no pudo ser enviado
    10. registro - fallo - inconsistemcia de datos
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
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> no se ha completado el registro
</div>
<%
        break;
    case 5:
%>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Exito!</strong> se ha registrado satisfactoriamente al usuario
</div>
<%
        break;
    case 6:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> Actualmente existe un funcionario activo con los datos ingresados
</div>
<%
        break;
    case 7:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> Actualmente existe un funcionario inactivo con el correo ingresado
</div>
<%
        break;
    case 8:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> Actualmente existe un funcionario inactivo con el documento ingresado
</div>
<%
        break;
    case 9:
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Fallo!</strong> El correo con la contraseña del usuario no ha podido ser enviado
</div>
<%
        break;
    case 10:
%>
<div class="alert alert-warning alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    <strong>Error!</strong> ha ocurrido un problema, por favor vuelva a cargar la pagina
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

