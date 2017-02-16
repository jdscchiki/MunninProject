/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Business;

/**
 *
 * @author Sergio
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
     public void leerArchivo(String ruta) throws IOException{
	FileInputStream file = new FileInputStream(new File(ruta));
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
	while (rowIterator.hasNext()){
	    row = rowIterator.next();
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
	    while (cellIterator.hasNext()){
		celda = cellIterator.next();
		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
		switch(celda.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
		    if(DateUtil.isCellDateFormatted(celda) ){
		       System.out.println(celda.getDateCellValue());
		    }else{
		       System.out.println(celda.getNumericCellValue());
		    }
		    break;
		case Cell.CELL_TYPE_STRING:
		    System.out.println(celda.getStringCellValue());
		    break;
		case Cell.CELL_TYPE_BOOLEAN:
		    System.out.println(celda.getBooleanCellValue());
		    break;
		}
	    }
	}
	workbook.close();
        
    }
}
