<%@page import="java.util.ArrayList"%>
<%@page import="modelo.bean.Funcionario"%>
<div class="table-responsive">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Documento</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
            </tr>
        </thead>
        <tbody id="point">
            <%
                for (Funcionario funcionario : (ArrayList<Funcionario>) request.getAttribute("ContentTable")) {
            %>
            <tr data-id="<%=funcionario.getId()%>">
                <td><%=funcionario.getDocumento()%></td>
                <td><%=funcionario.getNombre()%></td>
                <td><%=funcionario.getApellido()%></td>
                <td><%=funcionario.getCorreo()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>