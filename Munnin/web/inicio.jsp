<%-- 
    Document   : inicio
    Created on : 4/11/2016, 02:06:46 AM
    Author     : Juan David Segura Castro <JBadCode>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" session="false"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Munnin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="right">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="inicio.jsp">Munnin</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Inicio</a></li>
                            <li><a href="coordinador.jsp">Coordinador</a></li>
                            <li><a href="equipo-tecnico.jsp">Equipo Tecnico</a></li>
                            <li><a href="equipo-pedagogico.jsp">Equipo Pedagógico</a></li>
                            <li><a href="instructor.jsp">Instructor</a></li>
                            <li><a href="administrador.jsp">Administrador</a></li>
                        </ul>
                        <jsp:include page="contenido/navbar.jsp"></jsp:include>
                    </div>
                </div>
            </nav>
            <div class="container-fluid">
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tempus viverra nisl ac sagittis. Integer consectetur eget risus facilisis euismod. Aenean at rutrum neque. Etiam sed est molestie, fermentum libero id, iaculis nisi. Mauris id magna tincidunt, accumsan ex quis, consequat mi. Nam nec augue eget eros tincidunt placerat. Phasellus finibus orci vitae bibendum blandit.
                </p>
                <p>
                    Aliquam quis blandit lacus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce a fermentum leo. Morbi ipsum ex, ultrices eget fringilla et, vestibulum ac ipsum. Sed porttitor ac dui a imperdiet. Suspendisse sit amet maximus justo. Nulla molestie fermentum accumsan. Nullam placerat, ex nec tincidunt malesuada, leo velit fermentum nunc, sit amet egestas odio purus sit amet eros. Praesent vitae dolor consequat, lobortis mi at, porta est. Nulla ac lorem commodo, imperdiet sapien et, rutrum quam. Mauris in placerat sem, ut porta augue. Aliquam mollis ultrices arcu at condimentum. In id placerat ligula. Etiam nec ligula volutpat, rutrum diam eu, tristique turpis. Donec suscipit augue quam, ac suscipit ante dapibus in. Etiam vel maximus risus.
                </p>
                <p>
                    Vivamus elementum nunc sit amet nisl viverra aliquam. Integer feugiat magna id egestas bibendum. Morbi porttitor lorem dolor. Aliquam fringilla ac dolor in tristique. Duis elementum lorem lorem, in elementum lacus varius quis. Sed non enim tristique, vestibulum lectus sit amet, porttitor est. Phasellus vehicula risus ac tincidunt aliquam. Sed elementum eu dui id faucibus. Fusce accumsan sem in congue iaculis.
                </p>
                <p>
                    Curabitur pharetra justo at augue sodales iaculis. In hac habitasse platea dictumst. Phasellus et lacinia velit, faucibus ultrices magna. Vivamus rutrum orci ut lorem viverra, lobortis elementum leo venenatis. Vestibulum interdum magna in orci sodales condimentum. Donec eros ante, posuere ultricies nisl dictum, consectetur fermentum lectus. Sed eget iaculis lectus. Sed maximus velit at tristique lacinia. Proin ut orci facilisis, consequat velit vitae, egestas dolor.
                </p>
                <p>
                    Nam venenatis nisl nisl, vel fringilla risus posuere quis. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus laoreet eros ut fringilla varius. Sed sed nisl quis nibh interdum pharetra vitae eget quam. Pellentesque consectetur massa purus, eget sodales tellus vulputate congue. Vestibulum imperdiet, enim id blandit pretium, nulla justo molestie libero, in ornare ex mauris eu lacus. Vestibulum vel leo pellentesque, viverra nulla et, viverra massa. Nullam turpis ligula, scelerisque vel ligula et, bibendum pharetra nibh. Etiam pulvinar, elit a tincidunt viverra, justo ante sollicitudin lacus, eget volutpat ligula orci eget leo. Proin laoreet ultricies risus vel tincidunt. Maecenas rutrum sit amet mauris sed pretium. Suspendisse hendrerit, velit eu vehicula pellentesque, magna leo convallis metus, id convallis mi felis id mi. Cras tempus lobortis odio, eu euismod sapien condimentum vitae. Fusce aliquet euismod ultrices.
                </p>
                <p>
                    Aenean viverra ligula a odio ornare, in ultricies metus lobortis. Curabitur ac dolor arcu. Etiam sit amet tincidunt mi, vitae porttitor ex. Suspendisse ultricies consectetur enim, a malesuada risus hendrerit accumsan. Quisque ac metus vitae lectus eleifend luctus. Donec mollis nulla dui. Sed sem ante, vehicula a pulvinar ac, commodo a felis. Ut fringilla faucibus porttitor. Integer nec rutrum nibh. In ligula dui, lacinia in viverra eget, posuere sed ex. Praesent sed sodales dolor. Vestibulum molestie metus dictum sollicitudin porttitor. Proin pellentesque urna eget metus consequat pretium. Suspendisse tincidunt luctus aliquet.
                </p>
                <p>
                    Mauris varius tempus lorem, ac mollis lorem gravida vitae. Nullam quis congue lectus. Etiam cursus sapien odio, eu posuere metus aliquet nec. Cras sollicitudin varius lacus, vitae auctor eros rutrum et. Cras feugiat cursus ipsum. Nunc semper porttitor felis et ultrices. Nam scelerisque cursus lectus. Fusce eget est ipsum. Curabitur tincidunt massa tortor, non faucibus orci venenatis blandit. Aliquam pharetra ultricies rhoncus. Morbi feugiat pellentesque pharetra. Nam at leo eu erat tempus condimentum eget pellentesque neque.
                </p>
                <p>
                    Suspendisse nec interdum leo, id tristique nisi. Nulla tristique dolor quis tincidunt fringilla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla ornare pretium lectus nec molestie. Etiam mollis non dui nec auctor. Aliquam eget interdum nulla, vitae semper diam. Proin lacinia rutrum erat in euismod. Quisque euismod blandit dignissim. Etiam semper sagittis libero vitae fermentum.
                </p>
                <p>
                    Vivamus a condimentum erat. Aenean in sollicitudin mauris, egestas commodo turpis. Donec sed pharetra magna, vitae vulputate ipsum. Phasellus imperdiet ipsum ut porttitor consequat. Praesent luctus felis in pretium gravida. Mauris volutpat magna turpis, ac tincidunt nisl mollis vitae. Donec vestibulum mauris justo, vitae gravida leo sodales id. Vestibulum ultricies fringilla rutrum. Cras ullamcorper facilisis pharetra. Vivamus ornare nulla tellus, egestas gravida arcu porta eu. Phasellus augue orci, elementum vitae interdum vel, placerat volutpat turpis.
                </p>
                <p>
                    Fusce consectetur mauris neque, vel lacinia risus imperdiet vel. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris posuere ex vel velit pharetra malesuada. Proin et purus mauris. Duis ullamcorper ligula augue. Pellentesque a velit vel tortor vestibulum condimentum nec at nulla. Mauris accumsan erat dui, vel dignissim enim blandit vitae. Etiam et interdum tortor, at tincidunt purus. Etiam porttitor viverra pellentesque. Sed id convallis velit. Phasellus vitae consectetur orci, non scelerisque ipsum. Vivamus varius erat a faucibus eleifend.
                </p>
            </div>
            <footer class="text-center">
                copyright 2016
            </footer>
        </div>
    </body>
</html>
