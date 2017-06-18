/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.database;

import java.util.ArrayList;

public class Chart {

    private String chartTitle;
    private String yAxesName;
    private String xAxesName;
    private ArrayList<ChartDataSet> dataSets;

    public Chart() {
        dataSets = new ArrayList<>();
    }

    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public String getyAxesName() {
        return yAxesName;
    }

    public void setyAxesName(String yAxesName) {
        this.yAxesName = yAxesName;
    }

    public String getxAxesName() {
        return xAxesName;
    }

    public void setxAxesName(String xAxesName) {
        this.xAxesName = xAxesName;
    }

    public ArrayList<ChartDataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(ArrayList<ChartDataSet> dataSets) {
        this.dataSets = dataSets;
    }

}
