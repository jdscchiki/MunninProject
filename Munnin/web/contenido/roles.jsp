<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="<%=request.getContextPath()%>/roles/administrador/inicio.jsp">Administrador</a>
    <a href="<%=request.getContextPath()%>/roles/coordinador/inicio.jsp">Coordinador</a>
    <a href="<%=request.getContextPath()%>/roles/tecnico/inicio.jsp">E. Técnico</a>
    <a href="<%=request.getContextPath()%>/roles/pedagogico/inicio.jsp">E. Pedagógico</a>
    <a href="<%=request.getContextPath()%>/roles/instructor/inicio.jsp">Instructor</a>
</div>

<!--left changing_role-->
<div class="left">
    <a href="<%=request.getContextPath()%>/roles/administrador/inicio.jsp">
        <div class="item">
            <span class="fa fa-eye glyphicon" style="font-size:18px"></span>Administrador
        </div>
    </a>
    <a href="<%=request.getContextPath()%>/roles/coordinador/inicio.jsp">
        <div class="item active">
            <span class="fa fa-file-o glyphicon" style="font-size:18px"></span>Coordinador
        </div>
    </a>
    <a href="<%=request.getContextPath()%>/roles/tecnico/inicio.jsp">
        <div class="item">
            <span class="fa fa-group glyphicon" style="font-size:18px"></span>E. Técnico
        </div>
    </a>
    <a href="<%=request.getContextPath()%>/roles/pedagogico/inicio.jsp">
        <div class="item">
            <span class="fa fa-group glyphicon" style="font-size:18px"></span>E. Pedagógico
        </div>
    </a>
    <a href="<%=request.getContextPath()%>/roles/instructor/inicio.jsp">
        <div class="item">
            <span class="fa fa-user-circle glyphicon" style="font-size:18px"></span>Instructor
        </div>
    </a>
</div>