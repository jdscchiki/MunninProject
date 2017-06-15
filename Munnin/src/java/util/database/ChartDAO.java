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
        chartDataSet.setName("Numero de versiones aprobadas");

        LocalDate today = LocalDate.now();

        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth()).minus(monthsQuantity - 1, ChronoUnit.MONTHS);

        for (int i = 0; i < monthsQuantity; i++) {
            LocalDate startQuery = start.plus(i, ChronoUnit.MONTHS);
            LocalDate endQuery = startQuery.with(TemporalAdjusters.lastDayOfMonth());

            String query = ""
                    + "SELECT count(id_version) AS count "
                    + "FROM version "
                    + "WHERE (fecha_aprobacion_version BETWEEN ? AND ?) AND "
                    + " id_centro_version = ?";

            PreparedStatement statement = this.getConexion().prepareStatement(query);
            statement.setDate(1, Date.valueOf(startQuery));
            statement.setDate(2, Date.valueOf(endQuery));
            statement.setString(3, idCenter);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ChartDataPoint dataPoint = new ChartDataPoint();
                dataPoint.setxAxesValue(startQuery.getYear() + "-" + startQuery.getMonth().getDisplayName(TextStyle.FULL, new Locale("es")));
                dataPoint.setyAxesValue("" + rs.getInt("count"));
                chartDataSet.getDataSet().add(dataPoint);
                break;
            }
        }
        result.getDataSets().add(chartDataSet);

        return result;
    }

    public Chart getChartVersionsUploadCenter(String idCenter, int monthsQuantity) throws SQLException {
        Chart result = new Chart();
        result.setChartTitle("Versiones enviadas por mes");
        result.setxAxesName("Meses");
        result.setyAxesName("Cantidad");
        ChartDataSet chartDataSet = new ChartDataSet();
        chartDataSet.setName("Numero de versiones enviadas");

        LocalDate today = LocalDate.now();

        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth()).minus(monthsQuantity - 1, ChronoUnit.MONTHS);

        for (int i = 0; i < monthsQuantity; i++) {
            LocalDate startQuery = start.plus(i, ChronoUnit.MONTHS);
            LocalDate endQuery = startQuery.with(TemporalAdjusters.lastDayOfMonth());

            String query = ""
                    + "SELECT count(id_version) AS count "
                    + "FROM version "
                    + "WHERE (fecha_version BETWEEN ? AND ?)"
                    + " AND id_centro_version = ?";

            PreparedStatement statement = this.getConexion().prepareStatement(query);
            statement.setDate(1, Date.valueOf(startQuery));
            statement.setDate(2, Date.valueOf(endQuery));
            statement.setString(3, idCenter);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ChartDataPoint dataPoint = new ChartDataPoint();
                dataPoint.setxAxesValue(startQuery.getYear() + "-" + startQuery.getMonth().getDisplayName(TextStyle.FULL, new Locale("es")));
                dataPoint.setyAxesValue("" + rs.getInt("count"));
                chartDataSet.getDataSet().add(dataPoint);
                break;
            }
        }
        result.getDataSets().add(chartDataSet);

        return result;
    }

    public Chart getChartCategoryCenter(String idCenter) throws SQLException {
        Chart result = new Chart();
        result.setChartTitle("Categoria por programa");
        result.setxAxesName("Categoria");
        result.setyAxesName("Cantidad");
        ChartDataSet chartDataSet = new ChartDataSet();
        chartDataSet.setName("Numero de productos de aprendizaje por categoria");

        String query = ""
                + "SELECT nombre_categoria, count(id_producto_cat_prod) as count "
                + "FROM categoria "
                + "INNER JOIN categoria_producto "
                + "ON id_categoria_cat_prod = id_categoria "
                + "WHERE id_centro_categoria = ? AND "
                + " activo_categoria = 1 "
                + "GROUP BY nombre_categoria";

        PreparedStatement statement = this.getConexion().prepareStatement(query);
        statement.setString(1, idCenter);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            ChartDataPoint dataPoint = new ChartDataPoint();
            dataPoint.setxAxesValue(rs.getString("nombre_categoria"));
            dataPoint.setyAxesValue("" + rs.getInt("count"));
            chartDataSet.getDataSet().add(dataPoint);
        }

        result.getDataSets().add(chartDataSet);

        return result;
    }
    
    public Chart getChartProgramsCenter(String idCenter) throws SQLException {
        Chart result = new Chart();
        result.setChartTitle("Productos por programa");
        result.setxAxesName("Programas");
        result.setyAxesName("Cantidad");
        ChartDataSet chartDataSet = new ChartDataSet();
        chartDataSet.setName("Numero de productos de aprendizaje por programa");

        String query = ""
                + "SELECT nombre_programa, count(id_producto_prog_prod) as count "
                + "FROM programa "
                + "INNER JOIN programa_producto "
                + "ON id_programa_prog_prod = id_programa "
                + "INNER JOIN area "
                + "ON id_area_programa = id_area "
                + "WHERE id_centro_area = ? AND "
                + " activo_programa = 1 "
                + "GROUP BY nombre_programa";

        PreparedStatement statement = this.getConexion().prepareStatement(query);
        statement.setString(1, idCenter);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            ChartDataPoint dataPoint = new ChartDataPoint();
            dataPoint.setxAxesValue(rs.getString("nombre_programa"));
            dataPoint.setyAxesValue("" + rs.getInt("count"));
            chartDataSet.getDataSet().add(dataPoint);
        }

        result.getDataSets().add(chartDataSet);

        return result;
    }
    
    public Chart getChartViewsCenter(String idCenter, int monthsQuantity) throws SQLException {
        Chart result = new Chart();
        result.setChartTitle("Vistas por mes");
        result.setxAxesName("Meses");
        result.setyAxesName("Cantidad");
        ChartDataSet chartDataSet = new ChartDataSet();
        chartDataSet.setName("Numero de visitas");

        LocalDate today = LocalDate.now();

        LocalDate start = today.with(TemporalAdjusters.firstDayOfMonth()).minus(monthsQuantity - 1, ChronoUnit.MONTHS);

        for (int i = 0; i < monthsQuantity; i++) {
            LocalDate startQuery = start.plus(i, ChronoUnit.MONTHS);
            LocalDate endQuery = startQuery.with(TemporalAdjusters.lastDayOfMonth());

            String query = ""
                    + "SELECT count(id_visita) as count "
                    + "FROM visita "
                    + "INNER JOIN productosaprobados "
                    + "ON id_producto = id_producto_visita "
                    + "WHERE (fecha_visita BETWEEN ? AND ?)"
                    + " AND id_centro_version = ?";

            PreparedStatement statement = this.getConexion().prepareStatement(query);
            statement.setDate(1, Date.valueOf(startQuery));
            statement.setDate(2, Date.valueOf(endQuery));
            statement.setString(3, idCenter);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ChartDataPoint dataPoint = new ChartDataPoint();
                dataPoint.setxAxesValue(startQuery.getYear() + "-" + startQuery.getMonth().getDisplayName(TextStyle.FULL, new Locale("es")));
                dataPoint.setyAxesValue("" + rs.getInt("count"));
                chartDataSet.getDataSet().add(dataPoint);
                break;
            }
        }
        result.getDataSets().add(chartDataSet);

        return result;
    }
}
