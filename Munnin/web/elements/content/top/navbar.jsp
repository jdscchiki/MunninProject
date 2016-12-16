<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
                <div class="containerBtn" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
                    <div class="bar1"></div>
                    <div class="bar2"></div>
                    <div class="bar3"></div>
                </div>
            </button>
            <img class="navbar-brand" src="${URIMunnin}/elements/img/LogoNavbar.png" alt="munnin-logo" style="padding: 7px 7px;">
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <jsp:include page="/elements/content/top/navbarCont.jsp" />
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a data-toggle="popover" data-placement="bottom" title="funciona!" data-content="Aqui irian las notificaciones."><span class="glyphicon glyphicon-bell"></span></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${nombreUsuario}</a>
                    <ul class="dropdown-menu ">
                        <li><a ><span class="glyphicon glyphicon-cog"></span> Editar Perfil</a></li>
                        <li><a data-toggle="modal" data-target="#changePassword"><i class="fa fa-shield" aria-hidden="true"> </i>Cambio de contraseña</a></li>
                    </ul>
                </li>
                <li><a href="#vtn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
            </ul>
        </div>
    </div>
</nav>