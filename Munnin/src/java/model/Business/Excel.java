/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

/**
 *
 * @author Sergio
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import model.bean.Funcionario;
import model.bean.TipoDocumento;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Encriptado;

public class Excel {

    public ArrayList<Integer> leerArchivo(String ruta, String idCentro) throws IOException, Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
        Funcionario funcionario = new Funcionario();
        TipoDocumento tipoDocumento = new TipoDocumento();
        ArrayList<Integer> fila = new ArrayList<>();
        int count = 0, bien = 0;
        FileInputStream file = new FileInputStream(new File(ruta));
        //String idCentro = "9303";
        // Crear el objeto que tendra el libro de Excel
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        /*
20	
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
21	
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
22	
	 * que nos permite recorrer cada una de las filas que contiene.
23	
         */
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Row row;
        // Recorremos todas las filas para mostrar el contenido de cada celda        
        while (rowIterator.hasNext()) {
            try {
                row = rowIterator.next();
                // Obtenemos el iterator que permite recorres todas las celdas de una fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell celda = cellIterator.next();
                String doc = celda.getStringCellValue();
                if ("cc".equals(doc.toLowerCase()) || "cedula".equals(doc.toLowerCase())) {
                    tipoDocumento.setId(1);
                    funcionario.setTipoDocumento(tipoDocumento);
                }
                celda = cellIterator.next();
                funcionario.setDocumento(Double.toString(celda.getNumericCellValue()));
                celda = cellIterator.next();
                funcionario.setCorreo(celda.getStringCellValue());
                celda = cellIterator.next();
                funcionario.setNombre(celda.getStringCellValue());
                celda = cellIterator.next();
                funcionario.setApellido(celda.getStringCellValue());
                celda = cellIterator.next();
                funcionario.setTelefono(Double.toString(celda.getNumericCellValue()));
            } catch (Exception e) {
            }
            int resultado = Coordinator.registerFunctionary(funcionario, idCentro);
            count++;
            if (resultado != 1) {
                fila.add(count);
            } else {
                bien++;
            }
        }
        workbook.close();
        return fila;
    }
}
