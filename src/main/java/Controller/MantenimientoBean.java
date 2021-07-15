/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mantenimientos;
import Model.ServiciosXMantenimiento;
import Persistence.DAOFactory;
import java.util.ArrayList;

/**
 *
 * @author NATALIA-PC
 */
public class MantenimientoBean {
    private DAOFactory fabrica = new DAOFactory();
    
    public ArrayList<Mantenimientos> obtenerMantenimientosUltimoMes(){
        ArrayList<Mantenimientos> list = new ArrayList<Mantenimientos>();
        list = fabrica.getMantenimientosDAO().listarMantenimientosUltimoMes();
        return list;
    }
    
    public ArrayList<ServiciosXMantenimiento> obtenerServiciosXMantenimientos(int codMant){
        ArrayList<ServiciosXMantenimiento> list = new ArrayList<ServiciosXMantenimiento>();
        ServiciosXMantenimiento sxm = new ServiciosXMantenimiento();
        sxm.setCodMantenimiento(codMant);
        
        list = fabrica.getServiciosXMantenimientoDAO().listarServiciosXMantenimiento(sxm);
        return list;
    }
}
