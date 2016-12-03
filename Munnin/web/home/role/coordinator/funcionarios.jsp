<%@page import="java.util.ArrayList"%>
<%@page import="modelo.bean.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>
<%
    request.setAttribute("title", "Munnin Coordinador");
    request.setAttribute("navbar", 3);
    request.setAttribute("mainPage", 3);
    
    String aditionalJS = "";
    aditionalJS += "<script src='" + request.getContextPath() + "/elements/js/TableTest.js' languaje='Javascript' type='text/javascript'></script>";
    request.setAttribute("aditionalJS", aditionalJS);
%>
<jsp:include page="/elements/content/top.jsp" />
    <div class="row">
        <div class="col-lg-10">
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

            //si la pagina no es la primera entonces habilita el boton anterior
            %>
            <li class=${(pagina > 1) ? "":"disabled"}><a ${(pagina > 1) ? "href='"+URICoordinator+"funcionarios.jsp?pagina="+(pagina - 1)+"'":""}>anterior</a></li>
                <%
                for (int i = inicioPag; i <= finPag; i++) {//despliega los redireccionamientos a otras paginas
                    if (i == pagina) {//si la pagina en el paginador es la actual es marcada para que se vea diferente
                %>
            <li class="active"><a href="${URICoordinator}funcionarios.jsp?pagina=<%=i%>"><%=i%></a></li>
                <%
                    } else {
                %>
            <li><a href="${URICoordinator}funcionarios.jsp?pagina=<%=i%>"><%=i%></a></li>
                <%
                    }
                }
                %>
            <li <%= (pagina<paginas)? "": "class='disabled'"%> ><a <%= (pagina<paginas)? "href='"+request.getAttribute("URICoordinator")+"funcionarios.jsp?pagina="+(pagina + 1)+"'" : ""%> >siguiente</a></li>
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
    </div>
    <div class="col-lg-2">
        <form action="${URIMunnin}/adminFuncionarios" method="POST">
            <input type="hidden" name="selected" id="selected" value="-1">
            <button type="submit" name="opcion" value="eliminar" class="btn btn-primary btn-block">Eliminar funcionario</button>
        </form>
        <a href="${URICoordinator}formularios/registro-funcionario.jsp" class="btn btn-primary btn-block" role="button">Registro de funcionarios</a>
    </div>
</div>
<div id="div_mensaje" class="">
    <p id="mensaje">
    </p>
</div>

<jsp:include page="/elements/content/bot.jsp" />