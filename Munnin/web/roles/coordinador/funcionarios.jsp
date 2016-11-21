<%-- esto se usa en el top para dar propiedades segun la pagina--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.bean.Funcionario"%>
<%
    request.setAttribute("title", "Munnin Funcionarios");
    request.setAttribute("mainPage", 3);
    
    String aditionalJS = "";
    aditionalJS += "<script src='"+request.getContextPath()+"/js/TableTest.js' languaje='Javascript' type='text/javascript'></script>";

    request.setAttribute("aditionalJS", aditionalJS);
%>
<jsp:include page="/contenido/top1.jsp"></jsp:include>
<jsp:include page="/roles/coordinador/contenido/navbarCont.jsp"></jsp:include><%-- cambia dependiendo de la pagina--%>
<jsp:include page="/contenido/top2.jsp"></jsp:include>

    <ul class="pagination">
    <%
        int pagina = 1;//pagina inicial predeterminada
        int cantPaginas = 10;//cantidad de links de redireccionamiento
        if (request.getParameter("pagina") != null) {
            pagina = Integer.parseInt(request.getParameter("pagina"));//cambia la pagina predeterminada por la pagina necesaria
        }
        int paginas = (Integer) request.getAttribute("cantPaginas");//la cantidad de paginas que seran cargadas

        int inicioPag = 1;//primer redireccionamiento a pagina en aparecer
        int finPag = paginas;//ultimo redireccionamiento a pagina en aparecer
        if (paginas > cantPaginas) {
            if (pagina <= (cantPaginas / 2)) {
                finPag = cantPaginas;
            } else if (paginas - pagina <= (cantPaginas / 2)) {
                inicioPag = paginas - (cantPaginas - 1);
            } else {
                finPag = pagina + (cantPaginas / 2);
                inicioPag = pagina - (cantPaginas / 2 - 1);
            }
        }

        if (pagina > 1) {//si la pagina no es la primera entonces habilita el boton anterior
    %>
    <li><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp?pagina=<%=pagina - 1%>">anterior</a></li>
        <%
        } else {
        %>
    <li class="disabled"><a href="#">anterior</a></li>
        <%
            }
            for (int i = inicioPag; i <= finPag; i++) {//despliega los redireccionamientos a otras paginas
                if (i == pagina) {//si la pagina en el paginador es la actual es marcada para que se vea diferente
        %>
    <li class="active"><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp?pagina=<%=i%>"><%=i%></a></li>
        <%
        } else {
        %>
    <li><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp?pagina=<%=i%>"><%=i%></a></li>
        <%
                }
            }

            if (pagina < paginas) {//si la pagina no es la ultima entonces habilita el boton siguiente
        %>
    <li><a href="<%=request.getContextPath()%>/roles/coordinador/funcionarios.jsp?pagina=<%=pagina + 1%>">siguiente</a></li>
        <%
        } else {
        %>
    <li class="disabled"><a href="#">siguiente</a></li>
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
<form action="<%=request.getContextPath()%>/adminFuncionarios" method="POST">
    <input type="hidden" name="selected" id="selected" value="-1">
    <button type="submit" name="opcion" value="eliminar">Eliminar funcionario</button>
</form>
<a href="<%=request.getContextPath()%>/roles/coordinador/formularios/registro-funcionario.jsp" >Registro de funcionarios</a>

<jsp:include page="/contenido/bot.jsp"></jsp:include>