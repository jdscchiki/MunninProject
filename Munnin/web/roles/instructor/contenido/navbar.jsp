<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <jsp:include page="/contenido/navbarHeader.jsp"></jsp:include>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="<%=request.getContextPath()%>/roles/instructor/inicio.jsp" class="btn">Notificaciones</a></li>
                <li><a href="#" class="btn">Buscar</a></li>
                <li><a href="#" class="btn">Mi material</a></li>
            </ul>
            <jsp:include page="/contenido/navbarRight.jsp"></jsp:include>
        </div>
    </div>
</nav>