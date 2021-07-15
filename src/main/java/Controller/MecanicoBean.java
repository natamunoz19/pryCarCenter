/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mantenimientos;
import Model.Mecanicos;
import Model.ServiciosXMantenimiento;
import Persistence.DAOFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author NATALIA-PC
 */
public class MecanicoBean {
    private DAOFactory fabrica = new DAOFactory();
    private MantenimientoBean mantBean = new MantenimientoBean();

    public MecanicoBean() {
    }
    
    public ArrayList<Mecanicos> obtenerMecanicos(){
        ArrayList<Mecanicos> list = new ArrayList<Mecanicos>();
        list = fabrica.getMecanicosDAO().listarMecanicos();
        return list;
    }
    
    public void crearMecanicos(Mecanicos mec){
        fabrica.getMecanicosDAO().crearMecanicos(mec);
    }
    
    public ArrayList<Mecanicos> listarMecanicosOrden(){
        ArrayList<Mantenimientos> listaMant = new ArrayList<Mantenimientos>();
        ArrayList<Mecanicos> list = new ArrayList<Mecanicos>();
        ArrayList<Mecanicos> listP = new ArrayList<Mecanicos>();
        Mecanicos meca = new Mecanicos();
        Mecanicos mecan = new Mecanicos();
        ArrayList<ServiciosXMantenimiento> sxm = new ArrayList<ServiciosXMantenimiento>();
        int contador = 0;
        int contador2 = 0;
        
        listaMant = mantBean.obtenerMantenimientosUltimoMes();
        meca.setEstado("L");
        
        list = fabrica.getMecanicosDAO().listarMecanicos(meca);
        
        Map<Mecanicos, Integer> mapa = new HashMap<Mecanicos, Integer>();
        Map<Mecanicos, Integer> mapaCopia = new HashMap<Mecanicos, Integer>();
        
        for(int j = 0; j<list.size();j++){
            mapa.put(list.get(j), 0);
        }
        
        if(listaMant.size()==0){
            list = fabrica.getMecanicosDAO().listarMecanicos(meca);
        }else{
            for(int i = 0; i<listaMant.size(); i++){
                mecan = new Mecanicos();
                mecan.setTipoDocumento(listaMant.get(i).getMecTipoDocumento());
                mecan.setDocumento(listaMant.get(i).getMecDocumento());
                listP = new ArrayList<Mecanicos>();
                listP = fabrica.getMecanicosDAO().listarMecanicos(mecan);
                if(listP.size()>0){
                    mecan = list.get(0);
                }
                
                if(mapa.containsKey(mecan)){
                    contador = 0;
                    sxm = mantBean.obtenerServiciosXMantenimientos(listaMant.get(i).getCodigo());
                    for(int k = 0; k<sxm.size(); k++){
                        contador = contador + sxm.get(k).getTiempoEstimado();
                    }
                    mapa.put(mecan, (mapa.get(mecan)+contador));
                }
                
            }
            list = new ArrayList<Mecanicos>();
            while(contador2<10 && mapa.size()>0){
                int c = Collections.min(mapa.values());
                mapaCopia = mapa;
                for (Entry<Mecanicos, Integer> entry : mapaCopia.entrySet()) {
                    if (entry.getValue()==c && contador2 <10) {
                        list.add(entry.getKey());
                        contador2++;
                        mapa.remove(entry.getKey());
                    }
                }
                
            }
        }
        
        return list;
    } 

}
