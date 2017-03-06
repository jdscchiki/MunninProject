<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<template:basicTemplate actualPage="2"
                        actualRole="2"
                        funcionario="${sessionScope.usuario}"
                        title="Reportes Coordinador Munnin"
                        panelTitle="Reportes del centro">

    <jsp:body>
        <div class="row">
            <div class="col-md-12" id="message_functionaries">
                <div class="container">
                    <h2>Line Chart Demo</h2>
                    <div>
                        <canvas id="myChart"></canvas>
                    </div>
                </div>
                <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.2/Chart.min.js'></script>
                <script>
                    var ctx = document.getElementById("myChart");
                    var myChart = new Chart(ctx, {
                        type: 'radar',
                        data: {
                            labels: ["M", "T", "W", "T", "F", "S", "S"],
                            datasets: [{
                                    label: 'Visitas Marzo',
                                    backgroundColor: "rgba(153,255,51,0.4)",
                                    borderColor: "rgba(153,255,51,1)",
                                    data: [12, 19, 3, 17, 28, 24, 7]
                                }, {
                                    label: 'Visitas Abril',
                                    backgroundColor: "rgba(255,153,0,0.4)",
                                    borderColor: "rgba(255,153,0,1)",
                                    data: [30, 29, 5, 5, 20, 3, 10]
                                }]
                        }
                    });
                </script>
                <style>
                    .container {
                        width: 100%;
                    }
                </style>
            </div>
        </div>
    </jsp:body>

</template:basicTemplate>