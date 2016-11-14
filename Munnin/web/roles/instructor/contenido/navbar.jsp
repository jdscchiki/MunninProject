<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="padding-top: 1px;padding-bottom: 0px;padding-left: 5px;padding-right: 5px;margin-right: 12px;">
                <div class="container" onclick="myFunction(this)" style="padding-right: 0px;padding-left: 0px;">
                    <div class="bar1"></div>
                    <div class="bar2"></div>
                    <div class="bar3"></div>
                </div>
            </button>
            <a class="navbar-brand" href="<%=request.getContextPath()%>/inicio.jsp">Munnin</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="<%=request.getContextPath()%>/roles/instructor/inicio.jsp" class="btn">Notificaciones</a></li>
                <li><a href="#" class="btn">Buscar</a></li>
                <li><a href="#" class="btn">Mi material</a></li>
            </ul>
            <jsp:include page="/contenido/navbar-right.jsp"></jsp:include>
        </div>
    </div>
</nav>