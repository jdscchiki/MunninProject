<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setAttribute("title", "Cambio Contraseña");
    
    String aditionalJS = "";
    String aditionalCSS = "";
    
    aditionalJS += "<script src='"+request.getContextPath()+"/js/index_validator.js' type='text/javascript'></script>";
    aditionalJS += "<script src='"+request.getContextPath()+"/js/mensajes.js' type='text/javascript'></script>";
    
    request.setAttribute("aditionalJS", aditionalJS);
    request.setAttribute("aditionalCSS", aditionalCSS);
%>

<jsp:include page="/contenido/top1.jsp"></jsp:include>
<jsp:include page="/contenido/navbarCont.jsp"></jsp:include>
<jsp:include page="/contenido/top2.jsp"></jsp:include>

    <form class="form-horizontal" action="cambioContrasena" method="POST" onsubmit="return validarPass()">

        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordActual">Actual:</label>
            <div class="col-sm-4">
                <input id="passwordActual" type="password" name="passwordActual" class="form-control" placeholder="Contraseña actual" maxlength="16" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordNew1">Nueva:</label>
            <div class="col-sm-4">
                <input id="passwordNew1" type="password" name="passwordNew1" onkeyup="muestra_seguridad_clave(this.value, this.form)" class="form-control" placeholder="Nueva contraseña" maxlength="16" />
                <i>seguridad:</i> <input name="seguridad" type="text" style="border: 0px; background-color:#fff; text-decoration:italic;" onfocus="blur()">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="passwordNew2">Vuleva a escribir la contraseña nueva:</label>
            <div class="col-sm-4">
                <input id="passwordNew2" type="password" name="passwordNew2" class="form-control" placeholder="Repite nueva contraseña"  maxlength="16" />
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