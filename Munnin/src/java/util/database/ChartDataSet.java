/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.database;

import java.util.ArrayList;

public class ChartDataSet {

    private String name;
    private ArrayList<ChartDataPoint> dataSet;

    public ChartDataSet() {
        dataSet = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChartDataPoint> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<ChartDataPoint> dataSet) {
        this.dataSet = dataSet;
    }

}
