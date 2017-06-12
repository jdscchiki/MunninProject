/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import javax.naming.NamingException;

public class ChartDAO extends connectionDB {

    /**
     * Este constructor permite establecer la conexion con la base de datos
     *
     * @throws NamingException Error en el constructor connectionDB
     * @throws SQLException Error en el constructor connectionDB
     */
    public ChartDAO() throws NamingException, SQLException {
        super();
    }

    public Chart getChartAprovedVersionsCenter(String idCenter, int monthsQuantity) throws SQLException {
        Chart result = new Chart();
        result.setChartTitle("Versiones aprobadas por mes del centro");
        result.setxAxesName("Meses");
        result.setyAxesName("Cantidad");
        ChartDataSet chartDataSet = new ChartDataSet();
        chartDataSet.setName("Numero de versiones");
        
        LocalDate today = LocalDate.now();

        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth()).minus(monthsQuantity - 1, ChronoUnit.MONTHS);

        for (int i = 0; i < monthsQuantity; i++) {
            LocalDate startQuery = start.plus(i, ChronoUnit.MONTHS);
            LocalDate endQuery = startQuery.with(TemporalAdjusters.lastDayOfMonth());

            String query = ""
                    + "select count(id_version) as count\n"
                    + "from version\n"
                    + "WHERE (fecha_aprobacion_version between ? and ?)";

            PreparedStatement statement = this.getConexion().prepareStatement(query);
            statement.setDate(1, Date.valueOf(startQuery));
            statement.setDate(2, Date.valueOf(endQuery));
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ChartDataPoint dataPoint = new ChartDataPoint();
                dataPoint.setxAxesValue(startQuery.getYear() +"-"+ startQuery.getMonth().getDisplayName(TextStyle.FULL, new Locale("es")));
                dataPoint.setyAxesValue(""+rs.getInt("count"));
                chartDataSet.getDataSet().add(dataPoint);
                break;
            }
        }
        result.getDataSets().add(chartDataSet);
        
        return result;
    }
}
