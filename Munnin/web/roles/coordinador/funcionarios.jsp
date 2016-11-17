<%@page import="modelo.bean.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <jsp:include page="/contenido/head.jsp" ></jsp:include>
        </head>
        <body data-spy="scroll" data-target=".navbar" data-offset="50">
            <!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
                    <img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
            </div>-->

            <!--navbar-->
            <jsp:include page="/roles/coordinador/contenido/navbar.jsp" ></jsp:include>

            <!--changing role-->
            <jsp:include page="/contenido/roles.jsp" ></jsp:include>

            <!--content start_page-->
            <div class="container-fluid filled">
                <ul class="pagination">
                <%
                    int paginas = (Integer)request.getAttribute("paginas");
                    for (int i = 1; i <= paginas; i++) {
                %>
                    <li><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp?pagina=<%=i%>"><%=i%></a></li>
                <%
                    }
                %>
                </ul>
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
                        <%
                            for (Funcionario funcionario : (ArrayList<Funcionario>) request.getAttribute("contTabla")) {
                        %>
                        <tr onclick="selectRowTable(<%=funcionario.getId()%>)">
                            <td><%=funcionario.getDocumento()%></td>
                            <td><%=funcionario.getNombre()%></td>
                            <td><%=funcionario.getApellido()%></td>
                            <td><%=funcionario.getCorreo()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
                <form action="" method="POST">
                    <input type="hidden" name="selected" id="selected" value="-1">
                </form>
                <a href="<%=request.getContextPath()%>/roles/coordinador/formularios/registro-funcionario.jsp" >Registro de funcionarios</a>
            </div>
            <!--footer-->
            <jsp:include page="/contenido/footer.jsp"></jsp:include>

            <jsp:include page="/contenido/javascript.jsp"></jsp:include>
            <script src="<%=request.getContextPath()%>/js/TableTest.js" languaje="Javascript" type="text/javascript"></script>
    </body>
</html>
