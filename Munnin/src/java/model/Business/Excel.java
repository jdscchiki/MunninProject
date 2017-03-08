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
     public void leerArchivo(String ruta, String idCentro) throws IOException, Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException{        
        System.out.println("bandera 10");
        Funcionario funcionario = new Funcionario();        
        TipoDocumento tipoDocumento = new TipoDocumento();
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
	while (rowIterator.hasNext()){
            System.out.println("bandera2");
	    row = rowIterator.next();
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
            celda = cellIterator.next();
                tipoDocumento.setId((int)(celda.getNumericCellValue()));
                funcionario.setTipoDocumento(tipoDocumento);
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
                System.out.println(funcionario.getTipoDocumento().getId());
                System.out.println(funcionario.getDocumento());
                System.out.println(funcionario.getNombre());
                System.out.println(funcionario.getCorreo());
                System.out.println(funcionario.getTelefono());
                System.out.println(idCentro);
                int resultado = Coordinator.registerFunctionary(funcionario, idCentro);
                System.out.println(resultado);
	}        
	workbook.close();
    }
}
