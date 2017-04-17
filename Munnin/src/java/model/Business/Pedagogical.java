/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.bean.Estado;
import model.bean.EvaluacionItem;
import model.bean.EvaluacionLista;
import model.bean.Funcionario;
import model.bean.Item;
import model.bean.Lista;
import model.bean.Version;
import model.dao.EvaluacionItemDAO;
import model.dao.EvaluacionListaDAO;
import model.dao.ItemDAO;
import model.dao.ListaDAO;
import model.dao.VersionDAO;

/**
 *
 * @author Sergio
 */
public class Pedagogical {
    
    public static int countPagesFilesPedagogicalCenter(String idCentro, int cantXpag, String search) throws NamingException, SQLException {
        int paginas;
        int countAreas;
        VersionDAO versionDAO = new VersionDAO();
        countAreas = versionDAO.countFilesPedagocicalCenter(idCentro, search);
        versionDAO.cerrarConexion();
        paginas = countAreas / cantXpag;
        if (countAreas % cantXpag != 0) {
            paginas++;
        }

        return paginas;
    }

    public static ArrayList<Version> viewFilesPedagogicalCenter(String idCentro, int pagina, int cantXpag, String search) throws NamingException, SQLException {
        ArrayList<Version> version;
        VersionDAO versionDAO = new VersionDAO();
        version = versionDAO.selectSomeFilesPedagogicalCenter(idCentro, pagina, cantXpag, search);

        versionDAO.cerrarConexion();

        return version;
    }    
    
    public static int countPagesCheckList(int idAutor, int cantXpag, String search) throws NamingException, SQLException {
        int paginas;
        int cantFuncionarios;
        ListaDAO listaDAO = new ListaDAO();
        cantFuncionarios = listaDAO.countCheckListFunctionay(idAutor, search, false);
        listaDAO.cerrarConexion();

        paginas = cantFuncionarios / cantXpag;
        if (cantFuncionarios % cantXpag != 0) {
            paginas++;
        }

        return paginas;
    }
    
    public static ArrayList<Lista> viewCheckListFunctionary(int idAutor, int pagina, int cantXpag, String search) throws NamingException, SQLException {
        ArrayList<Lista> lista;
        ListaDAO listaDAO = new ListaDAO();
        lista = listaDAO.selectSomeCheckListFunctionary(idAutor, pagina, cantXpag, search);        
        listaDAO.cerrarConexion();

        return lista;
    }
    
    public static Version viewAllInfoVersion(int idVersion) throws NamingException, SQLException {
        Version resultado = new Version();
        VersionDAO versionDAO = new VersionDAO();
        resultado.setId(idVersion);
        resultado = versionDAO.select(resultado);
        
        versionDAO.cerrarConexion();
        
        return resultado;
    }
    
    public static Lista viewAllInfoLista(int idLista) throws NamingException, SQLException {
        Lista resultado = new Lista();
        ListaDAO listaDAO = new ListaDAO();
        resultado.setId(idLista);
        resultado = listaDAO.select(resultado);
        
        listaDAO.cerrarConexion();
        
        return resultado;
    }
    
    public static ArrayList<Item> viewItems(int idItem) throws NamingException, SQLException {
        ArrayList<Item> items;
        Item item = new Item();
        item.setId(idItem);
        ItemDAO itemDAO = new ItemDAO();
        items = itemDAO.selectItems(item);
        itemDAO.cerrarConexion();

        return items;
    }
    
    public static boolean AssignLista(int idVer, int idList, Funcionario funcionario) throws NamingException, SQLException {
        boolean resultado = false;
        Version version = new Version();
        Lista lista = new Lista();
        version.setId(idVer);        
        lista.setId(idList);
        EvaluacionLista evaluacionLista = new EvaluacionLista();
        evaluacionLista.setEvaluador(funcionario);
        evaluacionLista.setLista(lista);
        evaluacionLista.setVersion(version);
        evaluacionLista.setObservaciones("bueno");
        evaluacionLista.setCalificacion(1);
        //se realizan la operaciones en la base de datos
        EvaluacionListaDAO evaluacionListaDAO = new EvaluacionListaDAO();
        resultado = evaluacionListaDAO.agregarListaVersion(evaluacionLista);
        evaluacionListaDAO.cerrarConexion();

        return resultado;
    }
    
    public static EvaluacionLista datosLista(int idVer, int idList, Funcionario funcionario) throws NamingException, SQLException{
        Version version = new Version();
        Lista lista = new Lista();
        version.setId(idVer);        
        lista.setId(idList);
        EvaluacionLista evaluacionLista = new EvaluacionLista();
        evaluacionLista.setEvaluador(funcionario);
        evaluacionLista.setLista(lista);
        evaluacionLista.setVersion(version);
        EvaluacionListaDAO evListDAO = new EvaluacionListaDAO();
        evaluacionLista = evListDAO.selectEvList(evaluacionLista);
        return evaluacionLista;
    }
    
    public static boolean AssignItems(int idEvalucionLista, ArrayList<String> strIdItems) throws NamingException, SQLException {
        boolean resultado = false;
        int calificacion = 1;
        String coment = "bien";
        EvaluacionLista evList = new EvaluacionLista();
        evList.setId(idEvalucionLista);
        EvaluacionItem evItem;
        Item item;
        EvaluacionItemDAO evItemDAO = new EvaluacionItemDAO();
        System.out.println("banderaitems");
        for (int i = 0; i < strIdItems.size(); i++) {
            evItem = new EvaluacionItem();
            evItem.setCalificacion(calificacion);
            evItem.setObservarcion(coment);
            evItem.setEvaluacionLista(evList);
            item = new Item();
            item.setId(Integer.parseInt(strIdItems.get(i)));
            evItem.setItem(item);
            resultado = evItemDAO.AsignEvaluacionItem(evItem);
        }
        evItemDAO.cerrarConexion();

        return resultado;
    }
    
    public static boolean cambioEstado(int idVer) throws NamingException, SQLException{
        VersionDAO versionDAO = new VersionDAO();
        Estado estado = new Estado();
        estado.setId(5);
        Version version = new Version();
        version.setId(idVer);
        version.setEstado(estado);
        boolean resultado=false;
        if (versionDAO.updateEstado(version)) {
            resultado = true;
        }
        return resultado;
    }
    
    public static boolean cambioEstadoRechazado(int idVer) throws NamingException, SQLException{
        VersionDAO versionDAO = new VersionDAO();
        Estado estado = new Estado();
        estado.setId(1);
        Version version = new Version();
        version.setId(idVer);
        version.setEstado(estado);
        boolean resultado=false;
        if (versionDAO.updateEstado(version)) {
            resultado = true;
        }
        return resultado;
    }
}