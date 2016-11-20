<%
    request.setAttribute("title", "Munnin inicio");
%>
<jsp:include page="/contenido/top1.jsp"></jsp:include>
<jsp:include page="/contenido/navbarCont.jsp"></jsp:include>
<jsp:include page="/contenido/top2.jsp"></jsp:include>

    <form class="form-horizontal" action="cambioContrasena" method="POST" onsubmit="return validarPass()">

        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordActual">Contrase�a actual:</label>
            <div class="col-sm-4">
                <input id="passwordActual" type="password" name="passwordActual" class="form-control" placeholder="Contrase�a actual" maxlength="16" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordNew1">Nueva contrase�a:</label>
            <div class="col-sm-4">
                <input id="passwordNew1" type="password" name="passwordNew1" class="form-control" placeholder="Nueva contrase�a" maxlength="16" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordNew2">Repite contrase�a:</label>
            <div class="col-sm-4">
                <input id="passwordNew2" type="password" name="passwordNew2" class="form-control" placeholder="Repite nueva contrase�a"  maxlength="16" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
        <div id="div_mensaje" class="">
            <p id="mensaje">
            </p>
        </div>
    </form>

<jsp:include page="/contenido/bot.jsp"></jsp:include>