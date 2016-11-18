<ul class="nav navbar-nav navbar-right">
    <li><a href="#" data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Usuario</a>
        <ul class="dropdown-menu ">
            <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
            <li><a href="cambioPass.jsp">Cambiar contraseña</a></li>
            <li><a href="#" onclick="openNav()"> Rol</a></li>
        </ul>
    </li>
    <li><a href="<%=request.getContextPath()%>/salida"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
</ul>