/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.file;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import model.Business.Coordinator;
import model.bean.Funcionario;
import model.bean.TipoDocumento;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.security.Encrypt;

public class Excel {

    public static ArrayList[] funtionariesRegister(String fileRoute, String idCenter) throws IOException, Encrypt.CannotPerformOperationException, NamingException, SQLException, UnsupportedEncodingException, MessagingException {
        ArrayList<String[]> errorsRowCol = new ArrayList();
        ArrayList<Integer> correctRegisterRow = new ArrayList<>();

        Map<String, Integer> mapDocTypes = new HashMap<>();
        mapDocTypes.put("cc", 1);
        mapDocTypes.put("c.c.", 1);
        mapDocTypes.put("cedula", 1);
        mapDocTypes.put("cédula", 1);

        int countRows = 0;
        File fileInput = null;
        FileInputStream file = null;
        XSSFWorkbook workbook = null;
        try {

            fileInput = new File(fileRoute);

            file = new FileInputStream(fileInput);
            // Crear el objeto que tendra el libro de Excel
            workbook = new XSSFWorkbook(file);
            /*
            * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
            * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
            * que nos permite recorrer cada una de las filas que contiene.
             */
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            // Recorremos todas las filas para mostrar el contenido de cada celda
            Row row;
            while (rowIterator.hasNext()) {
                countRows++;
                Funcionario funcionario = new Funcionario();

                int errorOnCell = 0;
                int resultado = 0;

                row = rowIterator.next();

                try {

                    // Obtenemos el iterator que permite recorrer todas las celdas de una fila
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    
                    if(!cellIterator.hasNext()){
                        errorOnCell = 1;
                    }else if(errorOnCell == 0){
                        cell = cellIterator.next();
                        String doc = cell.getStringCellValue().toLowerCase();
                        TipoDocumento tipoDocumento = new TipoDocumento();
                        if (mapDocTypes.containsKey(doc)) {
                            tipoDocumento.setId(mapDocTypes.get(doc));
                            try {
                                funcionario.setTipoDocumento(tipoDocumento);
                            } catch (Exception e) {
                                errorOnCell = 1;
                            }
                        } else {
                            errorOnCell = 1;
                        }
                    }
                    if(!cellIterator.hasNext()){
                        errorOnCell = 2;
                    }else if(errorOnCell == 0){
                        cell = cellIterator.next();
                        try {
                            funcionario.setDocumento(Double.toString(cell.getNumericCellValue()));
                        } catch (Exception e) {
                            errorOnCell = 2;
                        }
                    }
                    
                    if(!cellIterator.hasNext()){
                        errorOnCell = 3;
                    }else if(errorOnCell == 0){
                        cell = cellIterator.next();
                        try {
                            funcionario.setCorreo(cell.getStringCellValue());
                        } catch (Exception e) {
                            errorOnCell = 3;
                        }
                    }
                    if(!cellIterator.hasNext()){
                        errorOnCell = 4;
                    }else if(errorOnCell == 0){
                        cell = cellIterator.next();
                        try {
                            funcionario.setNombre(cell.getStringCellValue());
                        } catch (Exception e) {
                            errorOnCell = 4;
                        }
                    }
                    if(!cellIterator.hasNext()){
                        errorOnCell = 5;
                    }else if(errorOnCell == 0){
                        cell = cellIterator.next();
                        try {
                            funcionario.setApellido(cell.getStringCellValue());
                        } catch (Exception e) {
                            errorOnCell = 5;
                        }
                    }
                    if(errorOnCell == 0){
                        cell = cellIterator.next();
                        try {
                            funcionario.setTelefono(cell.getStringCellValue());
                        } catch (Exception e) {
                            errorOnCell = 6;
                        }
                    }
                    if (errorOnCell == 0) {
                        resultado = Coordinator.registerFunctionary(funcionario, idCenter);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                if (errorOnCell != 0) {
                    String[] arrayErrors = {"fila " + countRows, "columna " + errorOnCell};
                    errorsRowCol.add(arrayErrors);
                } else if (resultado != 1) {
                    String[] arrayErrors = {"fila " + countRows, ""};
                    switch (resultado) {
                        case 2:
                            arrayErrors[1] = "Actualmente existe un funcionario activo con los datos ingresados";
                            break;
                        case 3:
                            arrayErrors[1] = "Actualmente existe un funcionario inactivo con el correo ingresado";
                            break;
                        case 4:
                            arrayErrors[1] = "Actualmente existe un funcionario inactivo con el documento ingresado";
                            break;
                        case 5:
                            arrayErrors[1] = "No ha podido ser enviado el correo con la contraseña del nuevo funcionario";
                            break;
                        case 0:
                        default:
                            arrayErrors[1] = "Ha ocurrido un error durante el registro";
                    }
                    errorsRowCol.add(arrayErrors);
                } else {
                    correctRegisterRow.add(countRows);
                }
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        if (workbook != null) {
            workbook.close();
        }
        if (file != null) {
            file.close();
        }
        fileInput = null;
        
        errorsRowCol.remove(errorsRowCol.size()-1);

        ArrayList[] d = {errorsRowCol, correctRegisterRow};
        return d;
    }
}
