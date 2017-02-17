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
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Iterator;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import managedBeans.session.LoggedInUser;
import modelo.bean.Funcionario;
import modelo.bean.TipoDocumento;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Encriptado;

public class Excel {
     public void leerArchivo(String ruta) throws IOException, Encriptado.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException{        
        LoggedInUser loggedInUser = new LoggedInUser();
        Funcionario funcionario = new Funcionario();        
        TipoDocumento tipoDocumento = new TipoDocumento();
	FileInputStream file = new FileInputStream(new File(ruta));        
        String idCentro = loggedInUser.getFuncionario().getIdCentro();
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
	    row = rowIterator.next();
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
            celda = cellIterator.next();
                tipoDocumento.setId((int)(celda.getNumericCellValue()));
                funcionario.setTipoDocumento(tipoDocumento);
                cellIterator.next();
                funcionario.setDocumento(Double.toString(celda.getNumericCellValue()));
                celda = cellIterator.next();
                funcionario.setCorreo(celda.getStringCellValue());
                celda = cellIterator.next(); 
                funcionario.setNombre(celda.getStringCellValue());
                celda = cellIterator.next(); 
                funcionario.setApellido(celda.getStringCellValue());
                celda = cellIterator.next(); 
                funcionario.setTelefono(Double.toString(celda.getNumericCellValue()));
                Coordinator.registerFunctionary(funcionario, idCentro);
	}
	workbook.close();
    }
}
