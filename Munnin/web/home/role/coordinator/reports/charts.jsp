<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-12">
        <p>La siguiente grafica muestra la cantidad de versiones que son subidas y aprobadas al aplicativo MUNNIN mes a mes a lo largo del último año.</p>
        <canvas id="canvas1"></canvas>
        <script type="text/javascript">
            var ctx1 = document.getElementById("canvas1");
            var chart1 = new Chart(ctx1, {
            type: 'line',
                    /* The data for our dataset */
                    data: {
                    labels: [<c:forEach items="${chart1.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getxAxesValue()}',</c:forEach>],
                            datasets: [{
                            label: "${chart1.getDataSets().get(0).getName()}",
                                    backgroundColor: 'rgba(252,115,35,0.2)',
                                    borderColor: 'rgb(252,115,35, 0.3)',
                                    pointBorderColor: 'rgb(252,115,35)',
                                    pointBackgroundColor: 'rgb(252,115,35)',
                                    data: [<c:forEach items="${chart1.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                                    lineTension: 0,
                            }, {
                            label: "${chart2.getDataSets().get(0).getName()}",
                                    backgroundColor: 'rgba(89,181,72,0.2)',
                                    borderColor: 'rgb(89,181,72, 0.3)',
                                    pointBorderColor: 'rgb(89,181,72)',
                                    pointBackgroundColor: 'rgb(89,181,72)',
                                    data: [<c:forEach items="${chart2.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                                    lineTension: 0,
                            }]
                    },
                    /* Configuration options go here */
                    options: {
                    responsive: true,
                            title: {
                            display: true,
                                    text: 'Versiones'
                            },
                            scales: {
                            xAxes: [{
                            display: true,
                                    scaleLabel: {
                                    display: true,
                                            labelString: '${chart1.getxAxesName()}'
                                    }
                            }],
                                    yAxes: [{
                                    display: true,
                                            scaleLabel: {
                                            display: true,
                                                    labelString: '${chart1.getyAxesName()}'
                                            }
                                    }]
                            }
                    }
            })
        </script>
        <hr>
    </div>
    <div class="col-md-6">
        <p>La grafica muestra la cantidad de productos de aprendizaje que se encuentran clasificados según su categoría.</p>
        <canvas id="canvas2"></canvas>
        <script type="text/javascript">
                    var dynamicColors = function() {
                    var colors = [
                            'rgb(255,99,132)',
                            'rgb(255,159,64)',
                            'rgb(255,205,86)',
                            'rgb(75,192,192)',
                            'rgb(54,162,235)',
                            'rgb(153,102,255)',
                            'rgb(231, 76, 60)',
                            'rgb(205, 97, 85)',
                            'rgb(175, 122, 197)',
                            'rgb(69, 179, 157)',
                            'rgb(171, 178, 185)',
                            'rgb(30, 132, 73)',
                            'rgb(255, 138, 101)',
                    ];
                    var color = Math.floor(Math.random() * colors.length);
                    return colors[color];
                    }

            var ctx1 = document.getElementById("canvas2");
            var chart2 = new Chart(ctx1, {
            type: 'doughnut',
                    /* The data for our dataset */
                    data: {
                    labels: [<c:forEach items="${chart3.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getxAxesValue()}',</c:forEach>],
                            datasets: [{
                            label: "${chart3.getDataSets().get(0).getName()}",
                                    backgroundColor: [<c:forEach items="${chart3.getDataSets().get(0).getDataSet()}" var="dataSet">dynamicColors(),</c:forEach>],
                                    data: [<c:forEach items="${chart3.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                            }]
                    },
                    /* Configuration options go here */
                    options: {
                    responsive: true,
                            title: {
                            display: true,
                                    text: 'Productos por categoria'
                            }
                    }
            })


            </script>
        </div>

        <div class="col-md-6">
            <canvas id="canvas3"></canvas>
            <p>La grafica muestra la cantidad de productos de aprendizaje que se encuentran clasificados según su programa.</p>
            <script type="text/javascript">
                        var ctx1 = document.getElementById("canvas3");
                var chart3 = new Chart(ctx1, {
                type: 'doughnut',
                        /* The data for our dataset */
                        data: {
                        labels: [<c:forEach items="${chart4.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getxAxesValue()}',</c:forEach>],
                                datasets: [{
                                label: "${chart3.getDataSets().get(0).getName()}",
                                        backgroundColor: [<c:forEach items="${chart4.getDataSets().get(0).getDataSet()}" var="dataSet">dynamicColors(),</c:forEach>],
                                        data: [<c:forEach items="${chart4.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                                }]
                        },
                        /* Configuration options go here */
                        options: {
                        responsive: true,
                                title: {
                                display: true,
                                        text: 'Productos por categoria'
                                }
                        }
                })


            </script>
        </div>
        <div class="col-md-12">
            <hr>
            <p>La siguiente grafica muestra la cantidad de visitas a los productos de aprendizaje en los que su ultima version fue subida por un funcionario del centro.</p>
            <canvas id="canvas4"></canvas>
            <script type="text/javascript">
                        var ctx1 = document.getElementById("canvas4");
                var chart4 = new Chart(ctx1, {
                type: 'line',
                        /* The data for our dataset */
                        data: {
                        labels: [<c:forEach items="${chart5.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getxAxesValue()}',</c:forEach>],
                                datasets: [{
                                label: "${chart5.getDataSets().get(0).getName()}",
                                        backgroundColor: 'rgba(252,115,35,0.2)',
                                        borderColor: 'rgb(252,115,35, 0.3)',
                                        pointBorderColor: 'rgb(252,115,35)',
                                        pointBackgroundColor: 'rgb(252,115,35)',
                                        data: [<c:forEach items="${chart5.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                                        lineTension: 0,
                                }],
                        },
                        /* Configuration options go here */
                        options: {
                        responsive: true,
                                title: {
                                display: true,
                                        text: 'Visitas'
                                },
                                scales: {
                                xAxes: [{
                                display: true,
                                        scaleLabel: {
                                        display: true,
                                                labelString: '${chart5.getxAxesName()}'
                                        }
                                }],
                                        yAxes: [{
                                        display: true,
                                                scaleLabel: {
                                                display: true,
                                                        labelString: '${chart5.getyAxesName()}'
                                                }
                                        }]
                                }
                        }
                })
        </script>
        
    </div>
</div>