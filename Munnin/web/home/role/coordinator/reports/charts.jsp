<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-12">
        <h3>Numero de versiones aprovadas </h3>
        <div>
            <canvas id="canvasVA"></canvas>
        </div>
        <script type="text/javascript">
            var ctx1 = document.getElementById("canvasVA");
            var chartVA = new Chart(ctx1, {
                type: 'line',

                /* The data for our dataset */
                data: {
                    labels: [<c:forEach items="${chart.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getxAxesValue()}',</c:forEach>],
                    datasets: [{
                            label: "${chart.getDataSets().get(0).getName()}",
                            backgroundColor: 'rgba(89, 181, 72,0.5)',
                            borderColor: 'rgb(89, 181, 72)',
                            data: [<c:forEach items="${chart.getDataSets().get(0).getDataSet()}" var="dataSet">'${dataSet.getyAxesValue()}',</c:forEach>],
                        }]
                },

                /* Configuration options go here */
                options: {
                    title: {
                        display: true,
                        text: '${chart.getChartTitle()}'
                    },
                    scales: {
                        xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: '${chart.getxAxesName()}'
                                }
                            }],
                        yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: '${chart.getyAxesName()}'
                                }
                            }]
                    }
                }
            })
        </script>
    </div>
    <div class="col-md-6"></div>
</div>