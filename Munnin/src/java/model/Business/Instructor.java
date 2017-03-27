/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import model.bean.Categoria;
import model.bean.Centro;
import model.bean.Producto;
import model.bean.Programa;
import model.bean.TipoArchivo;
import model.bean.TipoObjetoAprendizaje;
import model.bean.Version;
import model.dao.CategoriaDAO;
import model.dao.ProductoDAO;
import model.dao.ProgramaDAO;
import model.dao.TipoObjetoAprendizajeDAO;
import model.dao.VersionDAO;
import util.FileManager;

/**
 *
 * @author Juan David Segura
 */
public class Instructor {

    public static ArrayList<TipoObjetoAprendizaje> viewAllObjectType() throws NamingException, SQLException {
        ArrayList<TipoObjetoAprendizaje> result;

        TipoObjetoAprendizajeDAO tipoObjetoAprendizajeDAO = new TipoObjetoAprendizajeDAO();
        result = tipoObjetoAprendizajeDAO.selectAll();
        tipoObjetoAprendizajeDAO.closeConnection();

        return result;
    }

    public static int[] uploadNewLearningObject(Part file, Producto producto, String idCentro) throws NamingException, SQLException {
        //0. error inesperado
        //1. exito
        //2. error al Insertar Objeto en la base de datos
        //3. error al Insertar Version en la base de datos
        //4. error al guardar archivo en repositorio
        //5. error al guardar ruta de archivo en base de datos
        int result[] = {0, 0};

        int idProducto = 0;
        int idVersion = 0;

        //crea el registro del producto de aprendizaje en base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        idProducto = productoDAO.create(producto);
        productoDAO.closeConnection();
        if (idProducto == 0) {
            result[0] = 2;
        } else {

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
                result[0] = 3;
            } else {
                //calcula la ruta en donde se guardara el archivo con el id del centro, id producto y id version
                String savePath = File.separator + "c" + idCentro + File.separator + "p" + idProducto + File.separator + "v" + idVersion;

                //guarda el archivo
                if (!FileManager.saveFileMunninServer(file, savePath)) {
                    result[0] = 4;
                } else {
                    //guarda la ruta en la base de datos
                    version.setId(idVersion);
                    version.setUrl(savePath);
                    versionDAO = new VersionDAO();
                    if (versionDAO.editUrl(version)) {
                        result[0] = 1;
                        result[1] = idProducto;
                    } else {
                        result[0] = 5;
                    }
                    versionDAO.closeConnection();
                }
            }
        }

        return result;
    }

    public static ArrayList<Categoria> viewAllCategoryCenter(String idCenter) throws NamingException, SQLException {
        ArrayList<Categoria> result;

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        result = categoriaDAO.selectAllCenter(idCenter);
        categoriaDAO.closeConnection();

        return result;
    }

    public static int setCategoriesProduct(Producto producto) throws NamingException, SQLException {
        int result = 0;
        
        if (producto == null
                || producto.getId() <= 0
                || producto.getCategorias() != null) {
            ProductoDAO productoDAO = new ProductoDAO();
            result = productoDAO.insertCategories(producto);
            productoDAO.closeConnection();
        }

        return result;
    }
    
    public static ArrayList<Programa> viewAllProgrammes(String idCenter) throws NamingException, SQLException{
        ArrayList<Programa> result;
        
        ProgramaDAO programaDAO = new ProgramaDAO();
        result = programaDAO.selectAllCenter(idCenter);
        programaDAO.closeConnection();
        
        return result;
    }
    
    public static int setProgrammesProduct(Producto producto) throws NamingException, SQLException {
        int result = 0;
        
        if (producto == null
                || producto.getId() <= 0
                || producto.getProgramas()!= null) {
            ProductoDAO productoDAO = new ProductoDAO();
            result = productoDAO.insertProgrammes(producto);
            productoDAO.closeConnection();
        }

        return result;
    }
}
