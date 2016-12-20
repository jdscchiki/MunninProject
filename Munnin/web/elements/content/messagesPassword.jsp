<%--

    
--%>
<%
    boolean[] caseMessage = (boolean[]) request.getAttribute("message");
    if (caseMessage[0]) {
%>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Exito!</strong> se ha completado el cambio de contraseña
</div>
<%
} else {
    if (caseMessage[1]) {
%>
<div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
    La nueva contraseña no es segura, debido a:
    <ul>
        <%
            if (!caseMessage[3]) {
        %>
        <li>No tiene numeros</li>
            <%
                }
                if (!caseMessage[4]) {
            %>
        <li>No tiene minusculas</li>
            <%
                }
                if (!caseMessage[5]) {
            %>
        <li>No tiene mayusculas</li>
            <%
                }
                if (!caseMessage[6]) {
            %>
        <li>No es lo suficientemente larga</li>
            <%
                }
            %>
    </ul>
    <%
    } else {

    %>
    <div class="alert alert-danger alert-dismissible">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>    
        La contraseña no es correcta
    </div>

    <%            
    }
}
    %>
