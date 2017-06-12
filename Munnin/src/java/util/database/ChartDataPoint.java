/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.database;

public class ChartDataPoint {
    
    private String xAxesValue;
    private String yAxesValue;
    
    public ChartDataPoint(){
        
    }

    public String getxAxesValue() {
        return xAxesValue;
    }

    public void setxAxesValue(String xAxesValue) {
        this.xAxesValue = xAxesValue;
    }

    public String getyAxesValue() {
        return yAxesValue;
    }

    public void setyAxesValue(String yAxesValue) {
        this.yAxesValue = yAxesValue;
    }
    
}
