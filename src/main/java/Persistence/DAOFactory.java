/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author NATALIA-PC
 */
public class DAOFactory {
    private ClientesDAO clientesDao;
    private FacturasDAO facturasDAO;
    private FotosDAO fotosDAO;
    private MantenimientosDAO mantenimientosDAO;
    private MantenimientosXFacturasDAO mantenimientosXFacturasDAO;
    private MarcasDAO marcasDAO;
    private MecanicosDAO mecanicosDAO;
    private RepuestosDAO repuestosDAO;
    private RepuestosXMantenimientosDAO repuestosXMantenimientosDAO;
    private ServiciosDAO serviciosDAO;
    private ServiciosXMantenimientoDAO serviciosXMantenimientoDAO;
    private VehiculosDAO vehiculosDAO;

    public ClientesDAO getClientesDao() {
        if(clientesDao == null){
            clientesDao = new ClientesDAOImpl();
        }
        return clientesDao;
    }

    public FacturasDAO getFacturasDAO() {
        if(facturasDAO == null){
            facturasDAO = new FacturasDAOImpl();
        }
        return facturasDAO;
    }

    public FotosDAO getFotosDAO() {
        if(fotosDAO == null){
            fotosDAO = new FotosDAOImpl();
        }
        return fotosDAO;
    }

    public MantenimientosDAO getMantenimientosDAO() {
        if(mantenimientosDAO == null){
            mantenimientosDAO = new MantenimientosDAOImpl();
        }
        return mantenimientosDAO;
    }

    public MantenimientosXFacturasDAO getMantenimientosXFacturasDAO() {
        if(mantenimientosXFacturasDAO == null){
            mantenimientosXFacturasDAO = new MantenimientosXFacturasDAOImpl();
        }
        return mantenimientosXFacturasDAO;
    }

    public MarcasDAO getMarcasDAO() {
        if(marcasDAO == null){
            marcasDAO = new MarcasDAOImpl();
        }
        return marcasDAO;
    }

    public MecanicosDAO getMecanicosDAO() {
        if(mecanicosDAO == null){
            mecanicosDAO = new MecanicosDAOImpl();
        }
        return mecanicosDAO;
    }

    public RepuestosDAO getRepuestosDAO() {
        if(repuestosDAO == null){
            repuestosDAO = new RepuestosDAOImpl();
        }
        return repuestosDAO;
    }

    public RepuestosXMantenimientosDAO getRepuestosXMantenimientosDAO() {
        if(repuestosXMantenimientosDAO == null){
            repuestosXMantenimientosDAO = new RepuestosXMantenimientosDAOImpl();
        }
        return repuestosXMantenimientosDAO;
    }

    public ServiciosDAO getServiciosDAO() {
        if(serviciosDAO == null){
            serviciosDAO = new ServiciosDAOImpl();
        }
        return serviciosDAO;
    }

    public ServiciosXMantenimientoDAO getServiciosXMantenimientoDAO() {
        if(serviciosXMantenimientoDAO == null){
            serviciosXMantenimientoDAO = new ServiciosXMantenimientoDAOImpl();
        }
        return serviciosXMantenimientoDAO;
    }

    public VehiculosDAO getVehiculosDAO() {
        if(vehiculosDAO == null){
            vehiculosDAO = new VehiculosDAOImpl();
        }
        return vehiculosDAO;
    }
    
}
