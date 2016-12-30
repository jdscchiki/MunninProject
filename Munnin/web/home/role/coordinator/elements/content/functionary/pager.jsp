<ul class="pagination">
    <%
        int pagina = (Integer) request.getAttribute("page");//pagina
        int cantPaginas = 10;//cantidad de links de redireccionamiento
        int paginas = (Integer) request.getAttribute("pagesTable");//la cantidad de paginas que seran cargadas

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
    <li <%=(pagina > 1) ? "" : "class='disabled'"%>><a <%= (pagina > 1) ? ("data-page='"+(pagina-1))+"'"  : ""%>>anterior</a></li>
    <%
        for (int i = inicioPag; i <= finPag; i++) {//despliega los redireccionamientos a otras paginas
            //si la pagina en el paginador es la actual es marcada para que se vea diferente
    %>
    <li <%= (i == pagina) ? "class = 'active'" : ""%> ><a data-page="<%=i%>" data-search="<%=request.getAttribute("search")%>"><%=i%></a></li>
    <%
        }
    %>
    <li <%= (pagina < paginas) ? "" : "class='disabled'"%> ><a <%= (pagina < paginas) ? "data-page='"+(pagina+1)+"'" : ""%> >siguiente</a></li>
</ul>