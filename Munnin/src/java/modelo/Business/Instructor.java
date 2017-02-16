/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Business;

import java.io.File;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import modelo.bean.Centro;
import modelo.bean.Producto;
import modelo.bean.TipoArchivo;
import modelo.bean.Version;
import modelo.dao.ProductoDAO;
import modelo.dao.VersionDAO;
import util.FileManager;

/**
 *
 * @author Juan David Segura
 */
public class Instructor {

    public static int uploadNewLearningObject(Part file, Producto producto, String idCentro) throws NamingException, SQLException {
        int result = 0;

        int idProducto = 0;
        int idVersion = 0;

        //crea el registro del producto de aprendizaje en base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        idProducto = productoDAO.create(producto);
        productoDAO.closeConnection();

        if (idProducto == 0) {
            System.out.println("Error en la creacion de producto");
            return 0;
        }

        //crea el registro de la version en la base de datos
        Version version = new Version();
        version.setNumero(1);
        version.setCentro(new Centro());
        version.getCentro().setId(idCentro);
        version.setProducto(new Producto());
        version.getProducto().setId(idProducto);
        version.setTipoArchivo(new TipoArchivo());
        version.getTipoArchivo().setId(1);

        VersionDAO versionDAO = new VersionDAO();
        idVersion = versionDAO.create(version);
        versionDAO.closeConnection();

        if (idVersion == 0) {
            System.out.println("Error en la creacion de version");
            return 0;
        }

        //calcula la ruta en donde se guardara el archivo con el id del centro, id producto y id version
        String savePath = File.separator + "c" + idCentro + File.separator + "p" + idProducto + File.separator + "v" + idVersion;
        System.out.println("filePath: " + savePath);
        //guarda el archivo
        if (FileManager.saveFileMunninServer(file, savePath)) {
            result = 1;
        }
        //guarda la ruta en la base de datos

        return result;
    }

}
