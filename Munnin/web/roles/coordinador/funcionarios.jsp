<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Munnin</title>
        <jsp:include page="/contenido/head.jsp" ></jsp:include>
        </head>
        <body data-spy="scroll" data-target=".navbar" data-offset="50">
            <!--<div class="container-fluid" style="background-color:#FFFFFF;color:#fff;height:100px;">
                    <img src="imagenes/logo-completo.png" alt="munnin_icono" class="full-logo">
            </div>-->

            <!--navbar-->
        <jsp:include page="/roles/coordinador/contenido/navbar.jsp" ></jsp:include>

            <!--changing role-->
        <jsp:include page="/contenido/roles.jsp" ></jsp:include>

            <!--content start_page-->
            <div class="container-fluid filled">
                <div class="table-responsive">
                    <table class="table">
                        <tr>
                            <td>
                                <input type="radio" name="news2" value="1">
                            </td>
                            <td>JAN</td>
                            <td>2000</td>
                            <td>- Title 1</td>
                        <tr>
                            <td>
                                <input type="radio" name="news2" value="2">
                            </td>
                            <td>FEB</td>
                            <td>1191</td>
                            <td>- Title 2</td>
                        <tr>
                            <td>
                                <input type="radio" name="news2" value="3">
                            </td>
                            <td>MAR</td>
                            <td>2014</td>
                            <td>- Title 3</td>
                        <tr>
                            <td>
                                <input type="radio" name="news2" value="4">
                            </td>
                            <td>APR</td>
                            <td>1995</td>
                            <td>- Title 4</td>
                    </table>
                </div>
                <a href="<%=request.getContextPath()%>/roles/coordinador/formularios/registro-funcionario.jsp" >Registro de funcionarios</a>
        </div>
        <!--footer-->
        <jsp:include page="/contenido/footer.jsp"></jsp:include>

        <jsp:include page="/contenido/javascript.jsp"></jsp:include>
    </body>
</html>
